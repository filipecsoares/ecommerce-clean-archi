package com.simpledev.ecommerce.domain.entity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class ItemTest {

	@Test
	void shouldThrowsIfNegativeWeight() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Item(1L, "Guitarra", BigDecimal.valueOf(1000), new Dimension(100, 30, 10), -3);
		});

		String expectedMessage = "Invalid weight";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

}
