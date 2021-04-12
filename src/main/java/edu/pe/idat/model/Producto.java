/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pe.idat.model;

/**
 *
 * @author luis_
 */
public class Producto {
    
    private String codProducto;
    private String nomProducto;
    private Double precioProducto;

    public Producto(String codProducto, String nomProducto, Double precioProducto) {
        this.codProducto = codProducto;
        this.nomProducto = nomProducto;
        this.precioProducto = precioProducto;
    }
    
    

    public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }
    
    
    
}
