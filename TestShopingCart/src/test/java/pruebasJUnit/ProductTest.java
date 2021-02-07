package pruebasJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ProductTest {
	Product p;
	
	@BeforeEach
	void setUp() {
		p = new Product("Teclado", 25.05);
	}

	@AfterEach
	void tearDown() {
		p = null;
	}

	@Test
	void testEqualsObject() {
		Product p1 = p;
		assertEquals(p1, p);
		p1 = new Product("Teclado", 20.0);
		assertEquals(p1, p);
	}

}
