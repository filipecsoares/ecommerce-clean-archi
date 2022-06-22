package com.simpledev.ecommerce.domain;

import java.util.List;

public interface ItemRepository {

	Item get(Long idItem);

	void save(Item item);

	List<Item> getAll();

}
