package com.simpledev.ecommerce.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class PlaceOrderTest {

	@Test
	void shouldPlaceAnOrder() {
		ItemRepository itemRepository = new ItemRepositoryMemory();
		itemRepository.save(new Item(1L, "Guitarra", BigDecimal.valueOf(1000), new Dimension(100, 30, 10), 3));
		itemRepository.save(new Item(2L, "Amplificador", BigDecimal.valueOf(5000), new Dimension(50, 50, 50), 20));
		itemRepository.save(new Item(3L, "Cabo", BigDecimal.valueOf(30), new Dimension(10, 10, 10), 1));
		OrderRepository orderRepository = new OrderRepositoryMemory();
		PlaceOrder placeOrder = new PlaceOrder(itemRepository, orderRepository);
		OrderItemInput item1 = new OrderItemInput(1L, 1);
		OrderItemInput item2 = new OrderItemInput(2L, 1);
		OrderItemInput item3 = new OrderItemInput(3L, 3);
		List<OrderItemInput> orderItems = Arrays.asList(item1, item2, item3);
		PlaceOrderInput input = new PlaceOrderInput("918.461.310-65", orderItems);

		PlaceOrderOutput output = placeOrder.execute(input);

		assertEquals(BigDecimal.valueOf(6350.0), output.getTotal());
	}

}
