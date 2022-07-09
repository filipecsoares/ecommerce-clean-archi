package com.simpledev.ecommerce.infra.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpledev.ecommerce.application.GetOrders;
import com.simpledev.ecommerce.application.dto.OrderOutput;
import com.simpledev.ecommerce.domain.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderRepository orderRepository;
	private GetOrders getOrders;

	public OrderController(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
		this.getOrders = new GetOrders(this.orderRepository);
	}

	@GetMapping
	public ResponseEntity<List<OrderOutput>> getOrders() {
		return ResponseEntity.ok(getOrders.execute());
	}
}
