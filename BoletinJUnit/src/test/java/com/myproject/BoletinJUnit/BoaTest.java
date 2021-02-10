package com.myproject.BoletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class BoaTest {
	
	@ParameterizedTest (name = "Test IsHealthy")
	@CsvSource ({
		"Spooky, 15, mice, false",
		"Leggy, 14, granola bars, true",
		"Nancy, 11, leafs, false",
		"Danny, 23, granola bars, true"
	})
	
	void testIsHealthy(String name, int length, String favFood, boolean expectedResult) throws Exception {
		Boa a = new Boa(name, length, favFood);
		assertEquals(a.isHealthy(), expectedResult);
	}

	@ParameterizedTest (name = "Test FitsInCage")
	@CsvSource ({
		"Spooky, 15, mice, 15, false",
		"Leggy, 14, granola bars, 13, false",
		"Nancy, 11, leafs, 18, true",
		"Danny, 23, granola bars, 0, false"
	})
	
	void testFitsInCage(String name, int length, String favFood, int cageLength, boolean expectedResult) throws Exception {
		Boa a = new Boa(name, length, favFood);
		assertEquals(a.fitsInCage(cageLength), expectedResult);
	}

}
