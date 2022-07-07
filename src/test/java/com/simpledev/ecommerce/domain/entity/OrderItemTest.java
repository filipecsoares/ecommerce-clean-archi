package com.simpledev.ecommerce.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class OrderItemTest {

	@Test
	void shouldCreateAnOrderItem() {
		OrderItem item = new OrderItem(1L, BigDecimal.valueOf(100), 2);
		assertEquals(BigDecimal.valueOf(200), item.getTotal());
	}

	@Test
	void shouldThrowsIfQuantityIsNegativeCreateAnOrderItem() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new OrderItem(1L, BigDecimal.valueOf(100), -2);
		});

		String expectedMessage = "Invalid quantity";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

}
