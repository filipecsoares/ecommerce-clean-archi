package com.simpledev.ecommerce.infra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpledev.ecommerce.application.CreateItem;
import com.simpledev.ecommerce.application.GetItems;
import com.simpledev.ecommerce.application.dto.ItemInput;
import com.simpledev.ecommerce.application.dto.ItemOutput;
import com.simpledev.ecommerce.domain.repository.ItemRepository;

@RestController
@RequestMapping("/items")
public class ItemController {

	private final ItemRepository itemRepository;
	private GetItems getItems;
	private CreateItem createItem;

	public ItemController(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
		this.getItems = new GetItems(this.itemRepository);
		this.createItem = new CreateItem(this.itemRepository);
	}

	@GetMapping
	public ResponseEntity<List<ItemOutput>> getItems() {
		return ResponseEntity.ok(this.getItems.execute());
	}

	@PostMapping
	public ResponseEntity<String> save(@RequestBody ItemInput input) {
		this.createItem.execute(input);
		return ResponseEntity.status(HttpStatus.CREATED).body("Success!");
	}
}
