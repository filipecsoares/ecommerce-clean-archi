package com.simpledev.ecommerce.infra.repository.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.simpledev.ecommerce.domain.entity.StockEntry;
import com.simpledev.ecommerce.domain.repository.StockEntryRepository;

public class StockEntryRepositoryMemory implements StockEntryRepository {

	private List<StockEntry> stockEntries;

	public StockEntryRepositoryMemory() {
		this.stockEntries = new ArrayList<>();
	}

	@Override
	public void save(StockEntry stockEntry) {
		this.stockEntries.add(stockEntry);

	}

	@Override
	public List<StockEntry> getStockEntries(Long idItem) {
		return this.stockEntries.stream().filter(stock -> stock.getIdItem().equals(idItem))
				.collect(Collectors.toList());
	}

}
