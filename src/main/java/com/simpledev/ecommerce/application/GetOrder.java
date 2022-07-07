package com.simpledev.ecommerce.application;

import com.simpledev.ecommerce.application.dto.OrderOutput;
import com.simpledev.ecommerce.domain.entity.Order;
import com.simpledev.ecommerce.domain.repository.OrderRepository;

public class GetOrder {

	private final OrderRepository orderRepository;

	public GetOrder(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public OrderOutput execute(String code) {
		Order order = this.orderRepository.get(code);
		return new OrderOutput(order.getCode(), order.getTotal());
	}
}
