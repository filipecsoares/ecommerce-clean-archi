package com.simpledev.ecommerce.domain.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.simpledev.ecommerce.domain.entity.OperationEnum;
import com.simpledev.ecommerce.domain.entity.StockEntry;

class StockCalculatorTest {

	@Test
	void shouldCalculateStockQuantity() {
		List<StockEntry> stockEntries = Arrays.asList(new StockEntry(1L, OperationEnum.IN, 10), new StockEntry(1L, OperationEnum.IN, 10), new StockEntry(1L, OperationEnum.OUT, 10));
		int total = StockCalculator.calculate(stockEntries);
		assertEquals(10, total);
	}

}
