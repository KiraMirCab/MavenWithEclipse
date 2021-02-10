package cuentas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MovimientoTest {
	Movimiento m;

	@Before
	public void setUp() throws Exception {
		m = new Movimiento();
	}

	@After
	public void tearDown() throws Exception {
		m = null;
	}

	@Test
	public void testGetImporte() {
		m.setImporte(14.55);
		assertThat(m.getImporte(), allOf(is(14.55), is(not(15.89)), is(notNullValue())));
	}

	@Test
	public void testGetConcepto() {
		m.setConcepto("Pago en tienda");
		assertThat(m.getConcepto(), allOf(is("Pago en tienda"), is(not("")), is(notNullValue())));
	}

}
