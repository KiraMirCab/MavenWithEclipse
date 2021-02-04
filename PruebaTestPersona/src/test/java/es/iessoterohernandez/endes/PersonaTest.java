package es.iessoterohernandez.endes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonaTest {

	@Test
	void testCalcularIMC() {
		Persona p = new Persona("Juan", 35, 'H', 70, 1.75);
		assertEquals(0, p.calcularIMC());
		p = new Persona("Miguel", 20, 'H', 30, 1.9);
		assertEquals(-1, p.calcularIMC());
		p = new Persona("Ana", 60, 'M', 110, 1.60);
		assertEquals(1, p.calcularIMC());
	}

	@Test
	void testEsMayorDeEdad() {
		Persona p = new Persona("Juan", 35, 'H', 70, 1.75);
		assertEquals(true, p.esMayorDeEdad());
	}
	
	@Test
	void testToString() {
		Persona p = new Persona("Juan", 35, 'H', 70, 1.75);
		assertEquals("Informacion de la persona:\n"
                + "Nombre: " + "Juan" + "\n"
                + "Sexo: " + "hombre" + "\n"
                + "Edad: " + 35 + " años\n"
                + "DNI: " + p.getDNI() + "\n"
                + "Peso: " + 70.0 + " kg\n"
                + "Altura: " + 1.75 + " metros\n", p.toString());
	}
	

}
