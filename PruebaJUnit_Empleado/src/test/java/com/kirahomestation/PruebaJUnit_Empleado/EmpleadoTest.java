package com.kirahomestation.PruebaJUnit_Empleado;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class EmpleadoTest {
	Empleado e;
	
	@BeforeEach
	void setUp() throws Exception {
		e = new Empleado("Juan", "Perro", 66, 3600);
	}

	@AfterEach
	void tearDown() throws Exception {
		e = null;
	}

	@ParameterizedTest (name = "Test Plus")
	@CsvSource({
		"18, 1500.0, false, 500.0, 1500.0",
		"25, 1600.0, false, 250.0, 1600.0",
		"35, 2500.0, false, 500.0, 2500.0",
		"41, 3500.0, true, 500.0, 4000.0",
		"60, 4500.0, true, 700.0, 5200.0",	
	})
	void testPlus(int edad, double salario, boolean resultado, double plus, double sueldofinal) {
		Empleado emp = new Empleado("Paco", "Plaza", edad, salario);
		assertThat(emp.plus(plus), is(resultado));
		assertThat(emp.getSalario(), is(sueldofinal));
	}

	@ParameterizedTest (name = "Test Equals")
	@CsvSource({
		"Juan, Perro, true",
		"Enrique, Bunbury, false",
		"Jim, Morrison, false",
		"Mathew, Bellamy, false",
	})
	void testEqualsEmpleado(String nombre, String apellido, boolean resultado) {
		Empleado emp = new Empleado(nombre, apellido);
		assertThat(emp.equals(e), is(resultado));
	}

	@ParameterizedTest (name = "Test CompareTo")
	@CsvSource({
		"26, -1",
		"66, 0",
		"68, 1",
	})
	void testCompareTo(int edad, int resultado) {
		Empleado emp = new Empleado("John", "Lennon", edad);
		assertThat(emp.compareTo(e), is(resultado));
	}

}
