package com.simpledev.ecommerce.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.simpledev.ecommerce.application.dto.OrderItemInput;
import com.simpledev.ecommerce.application.dto.OrderOutput;
import com.simpledev.ecommerce.application.dto.PlaceOrderInput;
import com.simpledev.ecommerce.domain.entity.Dimension;
import com.simpledev.ecommerce.domain.entity.Item;
import com.simpledev.ecommerce.domain.factory.RepositoryFactory;
import com.simpledev.ecommerce.domain.repository.ItemRepository;
import com.simpledev.ecommerce.domain.repository.OrderRepository;
import com.simpledev.ecommerce.infra.factory.MemoryRepositoryFactory;

class GetOrdersTest {

	private RepositoryFactory repositoryFactory;
	private ItemRepository itemRepository;
	private OrderRepository orderRepository;

	@BeforeEach
	void setup() {
		this.repositoryFactory = new MemoryRepositoryFactory();
		this.itemRepository = repositoryFactory.createItemRepository();
		this.orderRepository = repositoryFactory.createOrderRepository();
	}

	@Test
	void shouldGetZeroOrdersIfTheresNoOrders() {
		GetOrders getOrders = new GetOrders(orderRepository);
		List<OrderOutput> output = getOrders.execute();
		assertEquals(0, output.size());
	}

	@Test
	void shouldGetOrders() {
		itemRepository.save(new Item(1L, "Guitarra", BigDecimal.valueOf(1000), new Dimension(100, 30, 10), 3));
		itemRepository.save(new Item(2L, "Amplificador", BigDecimal.valueOf(5000), new Dimension(50, 50, 50), 20));
		itemRepository.save(new Item(3L, "Cabo", BigDecimal.valueOf(30), new Dimension(10, 10, 10), 1));
		PlaceOrder placeOrder = new PlaceOrder(repositoryFactory);
		OrderItemInput item1 = new OrderItemInput(1L, 1);
		OrderItemInput item2 = new OrderItemInput(2L, 1);
		OrderItemInput item3 = new OrderItemInput(3L, 3);
		List<OrderItemInput> orderItems = Arrays.asList(item1, item2, item3);
		PlaceOrderInput input = new PlaceOrderInput("918.461.310-65", orderItems, LocalDateTime.of(2022, 3, 10, 1, 0));
		placeOrder.execute(input);
		placeOrder.execute(input);

		GetOrders getOrders = new GetOrders(orderRepository);
		List<OrderOutput> output = getOrders.execute();
		assertEquals(2, output.size());
		assertEquals("202200000001", output.get(0).getCode());
		assertEquals(BigDecimal.valueOf(6350.0), output.get(0).getTotal());
	}
}
