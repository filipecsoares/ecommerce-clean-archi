package com.simpledev.ecommerce.domain.repository;

import java.util.List;

import com.simpledev.ecommerce.domain.entity.StockEntry;

public interface StockEntryRepository {
	void save(StockEntry stockEntry);

	List<StockEntry> getStockEntries(Long idItem);
}
