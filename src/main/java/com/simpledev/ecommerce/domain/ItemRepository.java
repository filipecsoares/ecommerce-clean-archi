package com.simpledev.ecommerce.domain;

public interface ItemRepository {

	Item get(Long idItem);

	void save(Item item);

}
