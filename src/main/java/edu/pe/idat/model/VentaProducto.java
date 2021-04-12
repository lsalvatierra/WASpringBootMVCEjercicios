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
public class VentaProducto {
    
    private String codProducto;
    private String nomProducto;
    private Double cantidadTotal;
    private Double precioTotal;

    public VentaProducto(String codProducto, String nomProducto, Double cantidadTotal, Double precioTotal) {
        this.codProducto = codProducto;
        this.nomProducto = nomProducto;
        this.cantidadTotal = cantidadTotal;
        this.precioTotal = precioTotal;
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

    public Double getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Double cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

	public VentaProducto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}
