package edu.pe.idat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.pe.idat.model.Producto;
import edu.pe.idat.model.VentaProducto;
import edu.pe.idat.service.ProductoService;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/Producto")
public class ProductoController {
	
	@Autowired
	protected ProductoService servicio;

	
	@GetMapping("/formVentaProducto")
	public String formAlumno(Model model) {
		model.addAttribute("ventaproductoform", new VentaProducto());
		model.addAttribute("lstproductos", servicio.listarProductos());
		model.addAttribute("visualizar", false);
		return "Producto/formventaproducto";
	}
	

	@PostMapping("/registrarProducto")
	public String registrarAlumno(
			@ModelAttribute("ventaproductoform") VentaProducto ventaProductoForm,
			final HttpServletRequest request,
			Model model) {
        List<VentaProducto> lstVentaProducto = (List<VentaProducto>)request.getSession().getAttribute("lstproducto");
        if (CollectionUtils.isEmpty(lstVentaProducto)) {
        	lstVentaProducto = new ArrayList<VentaProducto>();
        }
        List<Producto> lstproductos = servicio.listarProductos();
        Producto objProducto = servicio.buscarProducto(lstproductos, ventaProductoForm.getCodProducto());
        Double preciototal = ventaProductoForm.getCantidadTotal() * objProducto.getPrecioProducto();
        String respuesta = "El precio unitario del producto "+objProducto.getNomProducto()+
                " es: "+ objProducto.getPrecioProducto() + " el valor total de venta es: " +
                preciototal;
        //Almacenamiento de información en sesión
        VentaProducto objVentaProd = new VentaProducto(objProducto.getCodProducto(), 
        		objProducto.getNomProducto(), 
        		ventaProductoForm.getCantidadTotal(), 
        		preciototal);
      
        List<VentaProducto> nuevaListVentaProducto = servicio.agregarProducto(
        		objVentaProd, lstVentaProducto);       
     
        request.getSession().setAttribute("lstproducto", nuevaListVentaProducto);
        model.addAttribute("ventaproductoform", new VentaProducto());
        model.addAttribute("lstproductos", servicio.listarProductos());
    	model.addAttribute("visualizar", true);
    	model.addAttribute("respuesta", respuesta);
        return "Producto/formventaproducto";
	}	

	@GetMapping("/listarVentaProductos")
	public String listarVentaProductos(Model model, final HttpSession session) {
		List<VentaProducto> lstVentaProducto = (List<VentaProducto>)
				session.getAttribute("lstproducto");
		if (CollectionUtils.isEmpty(lstVentaProducto)) {
			lstVentaProducto = new ArrayList<VentaProducto>();
        } 
		model.addAttribute("lstventaproducto", lstVentaProducto);
		return "Producto/listarventaproducto";
	}
	
}
