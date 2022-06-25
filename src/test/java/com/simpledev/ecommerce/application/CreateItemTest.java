package com.simpledev.ecommerce.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.simpledev.ecommerce.application.dto.ItemInput;
import com.simpledev.ecommerce.application.dto.ItemOutput;
import com.simpledev.ecommerce.domain.entity.Dimension;
import com.simpledev.ecommerce.domain.repository.ItemRepository;
import com.simpledev.ecommerce.infra.repository.memory.ItemRepositoryMemory;

class CreateItemTest {

	@Test
	void shouldCreateItem() {
		ItemRepository itemRepository = new ItemRepositoryMemory();
		CreateItem createItem = new CreateItem(itemRepository);
		ItemInput item = new ItemInput("Guitarra", BigDecimal.valueOf(1000), new Dimension(100, 30, 10), 3);
		createItem.execute(item);
		GetItems getItems = new GetItems(itemRepository);
		List<ItemOutput> items = getItems.execute();

		assertEquals(1, items.size());
	}

}
