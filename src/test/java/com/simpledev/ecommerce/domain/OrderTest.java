package com.simpledev.ecommerce.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class OrderTest {

	@Test
	void shouldNotCreateAnOrderWithInvalidCpf() {
		String invalidCpf = "111.111.111-11";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Order(invalidCpf);
		});

		String expectedMessage = "Invalid cpf";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void shouldCreateAnOrderWithThreeItems() {
		Order order = new Order("918.461.310-65");
		order.addItem(new Item(1L, "Guitar", BigDecimal.valueOf(1000)), 1);
		order.addItem(new Item(2L, "Book I", BigDecimal.valueOf(25.5)), 2);
		order.addItem(new Item(3L, "TV", BigDecimal.valueOf(1500.0)), 1);

		assertEquals(BigDecimal.valueOf(2551.0), order.getTotal());
	}
}
