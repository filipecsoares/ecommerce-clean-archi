package com.simpledev.ecommerce.infra.repository.database;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.simpledev.ecommerce.domain.entity.StockEntry;
import com.simpledev.ecommerce.domain.repository.StockEntryRepository;
import com.simpledev.ecommerce.infra.repository.database.jparepositories.StockEntryJPARepository;
import com.simpledev.ecommerce.infra.repository.database.models.StockEntryModel;

public class StockEntryRepositoryDatabase implements StockEntryRepository {

	@Autowired
	private StockEntryJPARepository stockEntryJPARepository;

	@Override
	public void save(StockEntry stockEntry) {
		this.stockEntryJPARepository
				.save(new StockEntryModel(stockEntry.getIdItem(), stockEntry.getOperation(), stockEntry.getQuantity()));
	}

	@Override
	public List<StockEntry> getStockEntries(Long idItem) {
		List<StockEntryModel> stockEntryModels = this.stockEntryJPARepository.findByIdItem(idItem);
		return stockEntryModels.stream()
				.map(model -> new StockEntry(model.getIdItem(), model.getOperation(), model.getQuantity()))
				.collect(Collectors.toList());
	}

}
