package com.simpledev.ecommerce.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class FreightTest {

	@Test
	void shouldCalculateFreght() {
		Freight freight = new Freight();
		freight.addItem(new Item(1L, "Guitarra", BigDecimal.valueOf(1000), new Dimension(100, 30, 10), 3), 1);
		freight.addItem(new Item(2L, "Amplificador", BigDecimal.valueOf(5000), new Dimension(50, 50, 50), 20), 1);
		freight.addItem(new Item(3L, "Cabo", BigDecimal.valueOf(30), new Dimension(10, 10, 10), 1), 3);
		BigDecimal total = freight.getTotal();
		assertEquals(BigDecimal.valueOf(260.0), total);
	}

	@Test
	void shouldCalculateFreghtWithMinimumPrice() {
		Freight freight = new Freight();
		freight.addItem(new Item(3L, "Cabo", BigDecimal.valueOf(30), new Dimension(10, 10, 10), 0.9), 1);
		BigDecimal total = freight.getTotal();
		assertEquals(BigDecimal.valueOf(10), total);
	}
}
