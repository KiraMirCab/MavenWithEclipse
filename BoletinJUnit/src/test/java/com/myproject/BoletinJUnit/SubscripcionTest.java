package com.myproject.BoletinJUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubscripcionTest {
	Subscripcion s;
	 
	@BeforeEach
	void setUp() throws Exception {
		s = new Subscripcion(9851, 12);
	}

	@AfterEach
	void tearDown() throws Exception {
		s = null;
	}

	
	@Test
	void testPrecioPorMes() {
		assertThat(
	    		"El cálculo ha fallado",
	    		s.precioPorMes(), 
	    		allOf(is(821), is(notNullValue())));
	}

	@Test
	void testCancel() {
		s.cancel();
		assertThat(
				s.precioPorMes(),
				equalTo(0.0));
	}

}
