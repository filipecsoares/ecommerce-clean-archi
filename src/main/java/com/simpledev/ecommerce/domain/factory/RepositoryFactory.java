package com.simpledev.ecommerce.domain.factory;

import com.simpledev.ecommerce.domain.repository.CouponRepository;
import com.simpledev.ecommerce.domain.repository.ItemRepository;
import com.simpledev.ecommerce.domain.repository.OrderRepository;

public interface RepositoryFactory {

	ItemRepository createItemRepository();

	OrderRepository createOrderRepository();

	CouponRepository createCouponRepository();
}
