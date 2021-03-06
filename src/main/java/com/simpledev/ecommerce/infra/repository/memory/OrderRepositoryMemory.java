package com.simpledev.ecommerce.infra.repository.memory;

import java.util.ArrayList;
import java.util.List;

import com.simpledev.ecommerce.domain.entity.Order;
import com.simpledev.ecommerce.domain.repository.OrderRepository;

public class OrderRepositoryMemory implements OrderRepository {

	private List<Order> orders;

	public OrderRepositoryMemory() {
		this.orders = new ArrayList<>();
	}

	@Override
	public void save(Order order) {
		this.orders.add(order);
	}

	@Override
	public long count() {
		return this.orders.size();
	}

	@Override
	public Order get(String code) {
		return this.orders.stream().filter(order -> code.equals(order.getCode())).findFirst().orElseThrow();
	}

	@Override
	public List<Order> list() {
		return this.orders;
	}
}
