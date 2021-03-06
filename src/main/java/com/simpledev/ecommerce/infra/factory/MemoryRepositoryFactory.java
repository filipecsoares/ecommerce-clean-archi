package com.simpledev.ecommerce.infra.factory;

import com.simpledev.ecommerce.domain.factory.RepositoryFactory;
import com.simpledev.ecommerce.domain.repository.CouponRepository;
import com.simpledev.ecommerce.domain.repository.ItemRepository;
import com.simpledev.ecommerce.domain.repository.OrderRepository;
import com.simpledev.ecommerce.domain.repository.StockEntryRepository;
import com.simpledev.ecommerce.infra.repository.memory.CouponRepositoryMemory;
import com.simpledev.ecommerce.infra.repository.memory.ItemRepositoryMemory;
import com.simpledev.ecommerce.infra.repository.memory.OrderRepositoryMemory;
import com.simpledev.ecommerce.infra.repository.memory.StockEntryRepositoryMemory;

public class MemoryRepositoryFactory implements RepositoryFactory {

	private ItemRepository itemRepository;
	private OrderRepository orderRepository;
	private CouponRepository couponRepository;
	private StockEntryRepository stockEntryRepository;

	@Override
	public ItemRepository createItemRepository() {
		if (this.itemRepository == null) {
			this.itemRepository = new ItemRepositoryMemory();
		}
		return this.itemRepository;
	}

	@Override
	public OrderRepository createOrderRepository() {
		if (this.orderRepository == null) {
			this.orderRepository = new OrderRepositoryMemory();
		}
		return this.orderRepository;
	}

	@Override
	public CouponRepository createCouponRepository() {
		if (this.couponRepository == null) {
			this.couponRepository = new CouponRepositoryMemory();
		}
		return couponRepository;
	}

	@Override
	public StockEntryRepository createStockEntryRepository() {
		if (this.stockEntryRepository == null) {
			this.stockEntryRepository = new StockEntryRepositoryMemory();
		}
		return this.stockEntryRepository;
	}

}
