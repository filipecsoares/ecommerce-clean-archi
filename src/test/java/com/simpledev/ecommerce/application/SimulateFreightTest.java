package com.simpledev.ecommerce.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.simpledev.ecommerce.application.dto.OrderItemInput;
import com.simpledev.ecommerce.application.dto.SimulateFreightInput;
import com.simpledev.ecommerce.application.dto.SimulateFreightOutput;
import com.simpledev.ecommerce.domain.entity.Dimension;
import com.simpledev.ecommerce.domain.entity.Item;
import com.simpledev.ecommerce.domain.repository.ItemRepository;
import com.simpledev.ecommerce.infra.repository.memory.ItemRepositoryMemory;

class SimulateFreightTest {

	@Test
	void shouldSimulateOrderFreight() {
		ItemRepository itemRepository = new ItemRepositoryMemory();
		itemRepository.save(new Item(1L, "Guitarra", BigDecimal.valueOf(1000), new Dimension(100, 30, 10), 3));
		itemRepository.save(new Item(2L, "Amplificador", BigDecimal.valueOf(5000), new Dimension(50, 50, 50), 20));
		itemRepository.save(new Item(3L, "Cabo", BigDecimal.valueOf(30), new Dimension(10, 10, 10), 1));
		SimulateFreight simulateFreight = new SimulateFreight(itemRepository);
		List<OrderItemInput> items = Arrays.asList(new OrderItemInput(1L, 1), new OrderItemInput(2L, 1),
				new OrderItemInput(3L, 3));
		SimulateFreightInput input = new SimulateFreightInput(items);
		SimulateFreightOutput output = simulateFreight.execute(input);
		assertEquals(BigDecimal.valueOf(260.0), output.getTotal());
	}

	@Test
	void shouldSimulateOrderFreightWithMinimumFreight() {
		ItemRepository itemRepository = new ItemRepositoryMemory();
		itemRepository.save(new Item(3L, "Cabo", BigDecimal.valueOf(30), new Dimension(10, 10, 10), 1));
		SimulateFreight simulateFreight = new SimulateFreight(itemRepository);
		List<OrderItemInput> items = Arrays.asList(new OrderItemInput(3L, 1));
		SimulateFreightInput input = new SimulateFreightInput(items);
		SimulateFreightOutput output = simulateFreight.execute(input);
		assertEquals(BigDecimal.valueOf(10.0), output.getTotal());
	}

}
