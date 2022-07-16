package com.simpledev.ecommerce.application.handler;

import com.simpledev.ecommerce.domain.entity.OperationEnum;
import com.simpledev.ecommerce.domain.entity.OrderItem;
import com.simpledev.ecommerce.domain.entity.StockEntry;
import com.simpledev.ecommerce.domain.event.DomainEvent;
import com.simpledev.ecommerce.domain.event.OrderPlaced;
import com.simpledev.ecommerce.domain.factory.RepositoryFactory;
import com.simpledev.ecommerce.domain.repository.StockEntryRepository;

public class StockHandler {

	private final StockEntryRepository stockEntryRepository;

	public StockHandler(RepositoryFactory repositoryFactory) {
		this.stockEntryRepository = repositoryFactory.createStockEntryRepository();
	}

	public void handler(DomainEvent domainEvent) {
		OrderPlaced orderPlaced = (OrderPlaced) domainEvent;
		for (OrderItem ordemItem : orderPlaced.getOrderItems()) {
			this.stockEntryRepository
					.save(new StockEntry(ordemItem.getIdItem(), OperationEnum.OUT, ordemItem.getQuantity()));
		}
	}
}
