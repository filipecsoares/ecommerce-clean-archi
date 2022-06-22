package com.simpledev.ecommerce.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryMemory implements OrderRepository {

	private List<Order> orders;

	public OrderRepositoryMemory() {
		this.orders = new ArrayList<>();
	}

	@Override
	public void save(Order order) {
		this.orders.add(order);
	}

}
