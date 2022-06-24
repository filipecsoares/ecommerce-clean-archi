package com.simpledev.ecommerce.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.simpledev.ecommerce.application.dto.ItemOutput;
import com.simpledev.ecommerce.domain.entity.Dimension;
import com.simpledev.ecommerce.domain.entity.Item;
import com.simpledev.ecommerce.domain.repository.ItemRepository;
import com.simpledev.ecommerce.infra.repository.memory.ItemRepositoryMemory;

class GetItemsTest {

	@Test
	void shouldGetItems() {
		ItemRepository itemRepository = new ItemRepositoryMemory();
		itemRepository.save(new Item(1L, "Guitarra", BigDecimal.valueOf(1000), new Dimension(100, 30, 10), 3));
		itemRepository.save(new Item(2L, "Amplificador", BigDecimal.valueOf(5000), new Dimension(50, 50, 50), 20));
		itemRepository.save(new Item(3L, "Cabo", BigDecimal.valueOf(30), new Dimension(10, 10, 10), 1));
		GetItems getItems = new GetItems(itemRepository);
		List<ItemOutput> output = getItems.execute();
		assertEquals(3, output.size());
	}

}
