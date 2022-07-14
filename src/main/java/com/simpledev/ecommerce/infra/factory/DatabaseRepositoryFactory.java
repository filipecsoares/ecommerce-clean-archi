package com.simpledev.ecommerce.infra.factory;

import com.simpledev.ecommerce.domain.factory.RepositoryFactory;
import com.simpledev.ecommerce.domain.repository.CouponRepository;
import com.simpledev.ecommerce.domain.repository.ItemRepository;
import com.simpledev.ecommerce.domain.repository.OrderRepository;
import com.simpledev.ecommerce.domain.repository.StockEntryRepository;
import com.simpledev.ecommerce.infra.repository.database.CouponRepositoryDatabase;
import com.simpledev.ecommerce.infra.repository.database.ItemRepositoryDatabase;
import com.simpledev.ecommerce.infra.repository.database.OrderRepositoryDatabase;
import com.simpledev.ecommerce.infra.repository.database.StockEntryRepositoryDatabase;

public class DatabaseRepositoryFactory implements RepositoryFactory {

	@Override
	public ItemRepository createItemRepository() {
		return new ItemRepositoryDatabase();
	}

	@Override
	public OrderRepository createOrderRepository() {
		return new OrderRepositoryDatabase();
	}

	@Override
	public CouponRepository createCouponRepository() {
		return new CouponRepositoryDatabase();
	}

	@Override
	public StockEntryRepository createStockEntryRepository() {
		return new StockEntryRepositoryDatabase();
	}

}
