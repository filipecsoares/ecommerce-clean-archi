package com.simpledev.ecommerce.domain.repository;

import java.util.List;

import com.simpledev.ecommerce.domain.entity.Order;

public interface OrderRepository {

	void save(Order order);

	long count();

	Order get(String code);
	
	List<Order> list();	
}
