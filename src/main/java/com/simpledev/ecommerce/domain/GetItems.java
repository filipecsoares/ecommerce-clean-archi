package com.simpledev.ecommerce.domain;

import java.util.ArrayList;
import java.util.List;

public class GetItems {

	private final ItemRepository itemRepository;

	public GetItems(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public List<ItemOutput> execute() {
		List<Item> items = this.itemRepository.getAll();
		List<ItemOutput> output = new ArrayList<>();
		items.forEach(item -> output.add(new ItemOutput(item.getId(), item.getDescription(), item.getPrice())));
		return output;
	}
}
