package com.composite;

public class Pedido extends ProductoFinal{
	private String cliente;

	public Pedido(String cliente) {
		super();
		this.cliente = cliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	
	@Override
	public void addProducto(Precio producto) {
		super.addProducto(producto);
	}

	
	public void removeProducto(Precio producto) {
		super.removeProducto(producto);
	}
	
	
	public void establecerCantidad(Precio producto, int cantidadFinal) {
		if (producto instanceof ProductoUnitario) {
			((ProductoUnitario)super.getListaProductos().
					get(super.getListaProductos().indexOf(producto))).setCantidad(cantidadFinal);
		}
	}
	
	
	public void establecerPeso(Precio producto, double precioFinal) {
		if (producto instanceof ProductoPeso) {
			((ProductoPeso)super.getListaProductos().
					get(super.getListaProductos().indexOf(producto))).setIva(precioFinal);
		}
	}
}
