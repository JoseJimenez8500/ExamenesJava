package com.composite;

public class Cliente {
	public static void main(String[] args) {
	
		Pedido pedido = new Pedido("Autos S.A");
		
	
		ProductoPeso automovil = new ProductoPeso(0.16, 379990.0, "Saveiro", "volkswagen");
		ProductoPeso camioneta = new ProductoPeso(0.16, 576660.0, "Nivus", "volkswagen");
		
	
		ProductoUnitario cross = new ProductoUnitario(1, 76660.50, "t-cross", "volkswagen");
		ProductoUnitario taos = new ProductoUnitario(2, 3799.25, "taos", "volkswagen");
		
		
		ProductoFinal transaccion = new ProductoFinal();
		
		
		transaccion.addProducto(cross);
		transaccion.addProducto(taos);
		
	
		pedido.addProducto(taos);
		pedido.addProducto(cross);
		
		
		System.out.println(pedido.getCliente());
		System.out.println("El importe por unidad es : " +  pedido.getListaProductos().toString());
		
	
		pedido.addProducto(transaccion);
		System.out.println("El importe total del Pedido es : " + pedido.getImporteTotal());

	}
}
