package com.simpledev.ecommerce.application;

import java.util.List;

import com.simpledev.ecommerce.application.dto.StockOutput;
import com.simpledev.ecommerce.domain.entity.StockEntry;
import com.simpledev.ecommerce.domain.factory.RepositoryFactory;
import com.simpledev.ecommerce.domain.repository.StockEntryRepository;
import com.simpledev.ecommerce.domain.service.StockCalculator;

public class GetStock {

	private StockEntryRepository stockEntryRepository;

	public GetStock(RepositoryFactory repositoryFactory) {
		this.stockEntryRepository = repositoryFactory.createStockEntryRepository();
	}

	public StockOutput execute(Long idItem) {
		List<StockEntry> stockEntries = this.stockEntryRepository.getStockEntries(idItem);
		int total = StockCalculator.calculate(stockEntries);
		return new StockOutput(total);
	}

}
