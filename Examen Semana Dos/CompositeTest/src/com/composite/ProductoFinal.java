package com.composite;
import java.util.ArrayList;
import java.util.Iterator;
public class ProductoFinal implements Precio{
	private ArrayList<Precio> listaProductos ;

	public ProductoFinal() {
		this.listaProductos =new ArrayList<Precio>();
	}
	
	
	public void addProducto(Precio precio) {
		listaProductos.add(precio);	
	}
	
	
	public void removeProducto(Precio precio) {
		listaProductos.remove(precio);	
	}
	

	public ArrayList<Precio> getListaProductos() {
		return listaProductos;
	}

	
	@Override
	public double getImporteTotal() {
		double importeTotal=0;
		for (Iterator<Precio> it = listaProductos.iterator(); it.hasNext();) {
			Precio precio = it.next();
			importeTotal+= precio.getImporteTotal();
		}
		return importeTotal;
	}
}
