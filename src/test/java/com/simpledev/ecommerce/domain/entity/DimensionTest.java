package com.simpledev.ecommerce.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DimensionTest {

	@Test
	void shouldCreateDimension() {
		Dimension dimension = new Dimension(100, 30, 10);
		double volume = dimension.getVolume();
		assertEquals(0.03, volume);
	}

	@Test
	void shouldThrowsIfNegativeParameters() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Dimension(-100, -30, -10);
		});

		String expectedMessage = "Invalid dimension";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}
}
