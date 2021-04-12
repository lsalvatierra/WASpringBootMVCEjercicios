package edu.pe.idat.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Producto;
import edu.pe.idat.model.VentaProducto;
@Repository
public interface ProductoRepository {

	List<Producto> listarProductos();
	
	Producto buscarProducto(List<Producto> lstproducto, String codproducto);
	
	List<VentaProducto> agregarProducto(VentaProducto objVentaProd, List<VentaProducto> listVentaProd);
}
