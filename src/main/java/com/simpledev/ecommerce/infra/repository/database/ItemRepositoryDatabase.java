package com.simpledev.ecommerce.infra.repository.database;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.simpledev.ecommerce.domain.entity.Item;
import com.simpledev.ecommerce.domain.repository.ItemRepository;
import com.simpledev.ecommerce.infra.repository.database.models.ItemModel;

public class ItemRepositoryDatabase implements ItemRepository {

	@Autowired
	private ItemJPARepository itemJPARepository;

	@Override
	public Item get(Long idItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Item item) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Item> getAll() {
		List<ItemModel> items = this.itemJPARepository.findAll();
		return items.stream().map(item -> new Item(item.getId(), item.getDescription(), item.getPrice()))
				.collect(Collectors.toList());
	}

}
