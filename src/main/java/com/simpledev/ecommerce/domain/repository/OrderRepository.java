package com.simpledev.ecommerce.domain.repository;

import com.simpledev.ecommerce.domain.entity.Order;

public interface OrderRepository {

	void save(Order order);

	int count();
}
