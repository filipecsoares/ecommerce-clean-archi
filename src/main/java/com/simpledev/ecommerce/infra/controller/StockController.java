package com.simpledev.ecommerce.infra.controller;

import com.simpledev.ecommerce.application.handler.StockHandler;
import com.simpledev.ecommerce.domain.factory.RepositoryFactory;
import com.simpledev.ecommerce.infra.queue.Queue;

public class StockController {

	public StockController(Queue queue, RepositoryFactory repositoryFactory) {
		queue.consume("orderPlaced", (orderPlaced) -> {
			StockHandler stockHandler = new StockHandler(repositoryFactory);
			stockHandler.handler(orderPlaced);
		});
	}
}
