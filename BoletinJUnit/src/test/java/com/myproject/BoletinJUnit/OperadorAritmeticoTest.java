package com.myproject.BoletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OperadorAritmeticoTest {

	@Test
	void testSuma() {
		int resultado = 25;
		assertThat(resultado, allOf(is(OperadorAritmetico.suma(17, 8)), not(21), notNullValue()));
	}

	@Test
	void testDivision() throws Exception {
		int resultado = 11;
		assertThat(OperadorAritmetico.division(71, 6), is(resultado));

	}

	@Test
	void testDivisionException() {
		try {
			OperadorAritmetico.division(658, 0);
		} catch (Exception ex) {
			assertEquals(null, ex.getMessage());

		}
	}
}
