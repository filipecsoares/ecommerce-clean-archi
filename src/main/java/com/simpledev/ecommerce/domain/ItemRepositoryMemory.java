package com.simpledev.ecommerce.domain;

import java.util.ArrayList;
import java.util.List;

public class ItemRepositoryMemory implements ItemRepository {

	private List<Item> items;

	public ItemRepositoryMemory() {
		this.items = new ArrayList<>();
	}

	@Override
	public Item get(Long idItem) {
		return items.stream().filter(item -> item.getId().equals(idItem)).findFirst().orElseThrow();
	}

	@Override
	public void save(Item item) {
		this.items.add(item);
	}

	@Override
	public List<Item> getAll() {
		return this.items;
	}

}
