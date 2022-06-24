package com.simpledev.ecommerce.domain.repository;

import java.util.List;

import com.simpledev.ecommerce.domain.entity.Item;

public interface ItemRepository {

	Item get(Long idItem);

	void save(Item item);

	List<Item> getAll();

}
