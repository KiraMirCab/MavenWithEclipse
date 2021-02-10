package cuentas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CuentaTest {
	Cuenta c, c1;
	
	@Before
	public void setUp() throws Exception {
		c = new Cuenta("1267 7899 4039 8476", "JUANITO HEAVY METALITO");
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	@Test
	public void testIngresar() throws Exception {
		c.ingresar("Nomina Pollitos Inc", 1423.0);
		assertThat(1423.0, is(c.getSaldo()));
	}
	@Test
	public void testIngresoNegativoException() {
		try {
			c.ingresar("Comision", -3.0);
			Assert.fail("Se espera una excepcion");
		}catch (IngresoNegativoException ex) {
			assertEquals("No se puede ingresar una cantidad negativa", ex.getMessage());
		}
	}

	@Test
	public void testRetirar() throws Exception {
		c.ingresar("Ingreso", 1500.0);
		c.retirar("Sacar efectivo", 150.0);
		assertThat(1350.0, is(c.getSaldo()));
	}

	@Test
	public void testRetirarExceptions() {
		try {
			c.retirar("Comision", -3.0);
			c.retirar("Sacar efectivo", 200.0);
			Assert.fail("Se espera una excepcion");
		}catch (IngresoNegativoException ex) {
			assertEquals("No se puede retirar una cantidad negativa", ex.getMessage());
		}catch (SaldoInsuficienteException e) {
			assertEquals("Saldo insuficiente", e.getMessage());
		}
	}
	@Test
	public void testGetSaldo() throws Exception  {
		c.ingresar("Ingreso", 1500.0);
		assertThat(c.getSaldo(), is(1500.0));
		c.retirar("Sacar efectivo", 1400);
		assertThat(c.getSaldo(), is(100.0));
	}

	@Test
	public void testAddMovimiento() {
		Movimiento m = new Movimiento();
		m.setConcepto("Devuelto por hacienda");
		m.setImporte(986.0);
		c.addMovimiento(m);
		assertThat(c.getSaldo(), is(986.0));
		
		Movimiento mov = new Movimiento();
		mov.setConcepto("Pago Mercadona");
		mov.setImporte(-125.6);
		c.addMovimiento(mov);
		assertThat(c.getSaldo(), is(860.4));		
	}
}
