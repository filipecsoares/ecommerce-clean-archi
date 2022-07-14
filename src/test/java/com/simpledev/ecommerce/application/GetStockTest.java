package com.simpledev.ecommerce.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.simpledev.ecommerce.application.dto.StockOutput;
import com.simpledev.ecommerce.domain.entity.OperationEnum;
import com.simpledev.ecommerce.domain.entity.StockEntry;
import com.simpledev.ecommerce.domain.factory.RepositoryFactory;
import com.simpledev.ecommerce.domain.repository.StockEntryRepository;
import com.simpledev.ecommerce.infra.factory.MemoryRepositoryFactory;

class GetStockTest {

	@Test
	void shouldReturnStockOfAnItem() {
		RepositoryFactory repositoryFactory = new MemoryRepositoryFactory();
		StockEntryRepository stockEntryRepository = repositoryFactory.createStockEntryRepository();
		stockEntryRepository.save(new StockEntry(1L, OperationEnum.IN, 10));
		stockEntryRepository.save(new StockEntry(1L, OperationEnum.IN, 10));
		stockEntryRepository.save(new StockEntry(1L, OperationEnum.OUT, 5));
		stockEntryRepository.save(new StockEntry(1L, OperationEnum.OUT, 5));
		GetStock getStock = new GetStock(repositoryFactory);
		StockOutput output = getStock.execute(1L);
		assertEquals(10, output.getTotal());
	}

}
