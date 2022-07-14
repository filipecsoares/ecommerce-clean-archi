package com.simpledev.ecommerce.domain.service;

import java.util.List;

import com.simpledev.ecommerce.domain.entity.OperationEnum;
import com.simpledev.ecommerce.domain.entity.StockEntry;

public class StockCalculator {

	public static int calculate(List<StockEntry> stockEntries) {
		int total = 0;
		for (StockEntry stockEntry : stockEntries) {
			if (OperationEnum.IN.equals(stockEntry.getOperation())) {
				total += stockEntry.getQuantity();
			}
			if (OperationEnum.OUT.equals(stockEntry.getOperation())) {
				total -= stockEntry.getQuantity();
			}
		}
		return total;
	}

}
