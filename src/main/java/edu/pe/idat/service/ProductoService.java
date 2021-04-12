package edu.pe.idat.service;

import edu.pe.idat.repository.ProductoRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pe.idat.model.*;

@Service
public class ProductoService implements ProductoRepository {

	@Override
	public List<Producto> listarProductos() {
        List<Producto> lstproductos = new ArrayList<>();
        lstproductos.add(new Producto ("P001", "Arroz", 3.5));
        lstproductos.add(new Producto ("P002", "Azucar", 3.4));
        lstproductos.add(new Producto ("P003", "Mantequilla", 2.0));
        lstproductos.add(new Producto ("P004", "Yogurt", 5.5));
        lstproductos.add(new Producto ("P005", "Leche", 3.2));
        return lstproductos;
	}

	@Override
	public Producto buscarProducto(List<Producto> lstproducto, String codproducto) {
		 Producto objProducto = null;
	        for(Producto objProd : lstproducto){
	            if(objProd.getCodProducto().equals(codproducto)){
	                objProducto = objProd; break;
	            }
	        }
	        return objProducto;
	}

	@Override
	public List<VentaProducto> agregarProducto(VentaProducto objVentaProd, 
			List<VentaProducto> listVentaProd) {
		boolean nuevoactualizado = false;
        boolean agregarnuevo = false;
        List<VentaProducto> listaventa = new ArrayList<>();
        if(listVentaProd.size() == 0){
            listaventa.add(objVentaProd);
        }else{
            for(VentaProducto objVenta : listVentaProd){
                if(objVenta.getCodProducto().equals(objVentaProd.getCodProducto())){
                    listaventa.add(new VentaProducto(
                            objVenta.getCodProducto(),
                            objVenta.getNomProducto(),
                            objVenta.getCantidadTotal() + objVentaProd.getCantidadTotal(),
                            objVenta.getPrecioTotal() + objVentaProd.getPrecioTotal()
                    ));
                    nuevoactualizado = true; agregarnuevo = false;
                }else{
                    listaventa.add(objVenta);
                    if(nuevoactualizado)
                        agregarnuevo = false;
                     else
                        agregarnuevo = true;
                }
            }
            if(agregarnuevo){
                listaventa.add(objVentaProd);
            }
        }
        return listaventa;
	}

}
