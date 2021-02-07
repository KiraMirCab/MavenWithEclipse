package com.myproject.BoletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class PilaTest {
	Pila p;
	
	@BeforeEach
	void setUp() throws Exception {
		p = new Pila();
	}

	@AfterEach
	void tearDown() throws Exception {
		p = null;
	}

	@Test
	void testPush() {
		p.push(25);
		assertTrue(p.isEmpty());
		p.push(17);
		assertThat(p.top(), is(17));
	}

	@Test
	void testPop() {
		p.push(5);
		p.push(19);
		assertThat(p.pop(), is(19));
		assertThat(p.pop(), is(5));
		assertTrue(p.isEmpty());
	}

	@Test
	void testIsEmpty() {
		assertTrue(p.isEmpty());
	}

	@Test
	void testTop() {
		p.push(12);
		p.push(17);
		assertThat(p.top(), is(17));
	}

}
