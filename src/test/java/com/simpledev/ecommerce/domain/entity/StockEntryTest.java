package com.simpledev.ecommerce.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StockEntryTest {

	@Test
	void shouldCreateAnStockEntry() {
		StockEntry stockEntry = new StockEntry(1L, OperationEnum.IN, 10);
		assertEquals(1L, stockEntry.getIdItem());
		assertEquals(OperationEnum.IN, stockEntry.getOperation());
		assertEquals(10, stockEntry.getQuantity());
	}
}
