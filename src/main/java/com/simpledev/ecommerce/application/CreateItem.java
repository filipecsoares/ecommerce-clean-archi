package com.simpledev.ecommerce.application;

import com.simpledev.ecommerce.application.dto.ItemInput;
import com.simpledev.ecommerce.domain.entity.Item;
import com.simpledev.ecommerce.domain.repository.ItemRepository;

public class CreateItem {

	private final ItemRepository itemRepository;

	public CreateItem(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public void execute(ItemInput input) {
		Item item = new Item(null, input.getDescription(), input.getPrice(), input.getDimension(), input.getWeight());
		this.itemRepository.save(item);
	}

}
