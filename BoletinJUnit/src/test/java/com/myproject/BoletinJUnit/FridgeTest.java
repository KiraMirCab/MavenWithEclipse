package com.myproject.BoletinJUnit;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class FridgeTest {
	Fridge f;
	
	@BeforeEach
	void setUp() {
		f = new Fridge();
		f.put("Milk");
		f.put("Butter");
		f.put("Eggs");
	}
	
	@AfterEach
	void tearDown() {
		f = null;
	}
	
	@ParameterizedTest (name = "Test put")
	@CsvSource({
		"Nuggets, true",
		"Sour cream, true",
		"Eggs, false",
		"Milk, false"
	})
	void testPut(String item, Boolean resultado) {
		assertEquals(f.put(item), resultado);
	}

	@ParameterizedTest (name = "Test Contains")
	@CsvSource({
		"Milk, true",
		"Butter, true",
		"Eggs, true",
		"Carrots, false"
	})
		void testContains(String item, Boolean resultado) {
		assertEquals(f.contains(item), resultado);
	}

	@ParameterizedTest (name = "Test Take")
	@CsvSource({
		"Milk",
		"Butter",
		"Eggs",
	})
		void testTake(String item) throws Exception {
		f.take(item);
		assertEquals(f.contains(item), false);
	}

	
	@Test
	void testNoSuchItemException() {
		try {
			f.take("Carrots");
			Assert.fail("Expected exception to be thrown");
		}catch (NoSuchItemException ex) {
			assertEquals("Carrots"+" not found in the fridge", ex.getMessage());
		}
	}

}
