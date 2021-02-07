package pruebasJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {
	ShoppingCart shc;
	Product p = new Product("Teclado", 25.05);
	Product p1 = new Product("Raton", 15.0);

	@BeforeEach
	void setUp() {
		shc = new ShoppingCart();
	}

	@AfterEach
	void tearDown() {
		shc = null;
	}

	// 1. Cuando se crea, el carro tiene 0 elementos.
	@Test
	void testGetItemCount() {
		assertEquals(0, shc.getItemCount());
	}

	// Cuando está vacío, el carro tiene 0 elementos.
	@Test
	void testEmpty() {
		shc.addItem(p);
		shc.addItem(p1);
		shc.empty();
		assertEquals(0, shc.getItemCount());
	}

	// Cuando se añade un producto, el número de elementos debe incrementarse.
	@Test
	void testAddItem() {
		shc.addItem(p);
		assertEquals(1, shc.getItemCount());
		shc.addItem(p1);
		assertEquals(2, shc.getItemCount());
	}

	// Cuando se añade un producto, el balance nuevo debe ser la suma del balance
	// anterior y el precio del producto añadido.
	@Test
	void testGetBalance() {
		shc.addItem(p);
		assertEquals(p.getPrice(), shc.getBalance());
		shc.addItem(p1);
		assertEquals(p.getPrice() + p1.getPrice(), shc.getBalance());
	}

	// Cuando se elimina un producto, el número de elementos debe decrementarse
	@Test
	void testRemoveItem() throws Exception {
		shc.addItem(p);
		shc.removeItem(p);
		assertEquals(0, shc.getItemCount());

	}

	// Cuando se intenta eliminar un producto que no está en el carro, se debe
	// lanzar una excepción ProductNotFoundException. Pista: inserta la llamada en
	// un bloque try y pon un método fail() después de la llamada a removeItem().

	@Test
	public void testProductNotFoundException() {
		try {
			shc.removeItem(p1);
		} catch (ProductNotFoundException ex) {
			assertEquals(null, ex.getMessage());	// entiendo que el mensaje que lanza una Excepcion generica es nulo
		}
	}

}
