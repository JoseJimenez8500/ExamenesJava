package com.composite;

public class ProductoPeso implements Precio{
	private double iva;
	private double precio;
	private String nombre;
	private String categoria;
	
	public ProductoPeso(double iva, double precio, String nombre, String categoria) {
		this.iva = iva;
		this.precio = precio;
		this.nombre = nombre;
		this.categoria = categoria;
	}

	
	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}


	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public double getImporteTotal() {
		return getPrecio()*getIva();
	}
	
	@Override
	public String toString() {
		return "["+ "El precio de " + getNombre()+" es: "+ getPrecio() +"]";
	}
}
