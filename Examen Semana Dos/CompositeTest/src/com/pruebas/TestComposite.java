package com.pruebas;

import static org.junit.jupiter.api.Assertions.*;
import com.composite.*;
import org.junit.jupiter.api.Test;

class TestComposite {

	@Test
	void getNombre() {
		String nombre= "Jetta 2022";
		assertEquals(nombre, "Jetta 2022");
	}
	
	@Test
	void getPrecio() {
		double precioUnidad= 379990.0;
		assertEquals(precioUnidad, 379990.0);
	}
	
	@Test
	void getMarca() {
		String marca= "volkswagen";
		assertEquals(marca, "volkswagen");
	}
	
	@Test
	void getNombre2() {
		ProductoFinal transaccion = new ProductoFinal();
		ProductoPeso venta1 = new ProductoPeso(0.16, 379990.0, "Jetta 2022", "volkswagen");
		transaccion.addProducto(venta1);
		assertEquals(venta1.getNombre(), "Jetta 2022");
	}
	
	@Test
	void getPrecio2() {
		ProductoFinal transaccion = new ProductoFinal();
		ProductoPeso venta1 = new ProductoPeso(0.16, 379990.0, "Jetta 2022", "volkswagen");
		transaccion.addProducto(venta1);
		assertEquals(venta1.getPrecio(), 5.0);
	}
	
	
	
	@Test
	void getCliente() {
		String cliente= "Autos S.A";
		assertEquals(cliente, "Auton S.A");
	}

}
