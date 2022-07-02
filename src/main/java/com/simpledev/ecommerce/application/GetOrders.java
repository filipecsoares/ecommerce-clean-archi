package com.simpledev.ecommerce.application;

import java.util.List;
import java.util.stream.Collectors;

import com.simpledev.ecommerce.application.dto.OrderOutput;
import com.simpledev.ecommerce.domain.repository.OrderRepository;

public class GetOrders {

	private final OrderRepository orderRepository;

	public GetOrders(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<OrderOutput> execute() {
		return this.orderRepository.list().stream().map(order -> new OrderOutput(order.getCode(), order.getTotal()))
				.collect(Collectors.toList());
	}
}
