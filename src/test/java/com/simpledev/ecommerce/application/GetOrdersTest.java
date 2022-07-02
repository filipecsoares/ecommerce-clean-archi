package com.simpledev.ecommerce.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.simpledev.ecommerce.application.dto.OrderOutput;
import com.simpledev.ecommerce.domain.repository.OrderRepository;
import com.simpledev.ecommerce.infra.repository.memory.OrderRepositoryMemory;

class GetOrdersTest {

	@Test
	void shouldGetZeroOrdersIfTheresNoOrders() {
		OrderRepository orderRepository = new OrderRepositoryMemory();
		GetOrders getOrders = new GetOrders(orderRepository);
		List<OrderOutput> output = getOrders.execute();
		assertEquals(0, output.size());
	}

}
