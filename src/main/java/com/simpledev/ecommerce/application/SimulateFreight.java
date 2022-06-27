package com.simpledev.ecommerce.application;

import com.simpledev.ecommerce.application.dto.OrderItemInput;
import com.simpledev.ecommerce.application.dto.SimulateFreightInput;
import com.simpledev.ecommerce.application.dto.SimulateFreightOutput;
import com.simpledev.ecommerce.domain.entity.Freight;
import com.simpledev.ecommerce.domain.entity.Item;
import com.simpledev.ecommerce.domain.repository.ItemRepository;

public class SimulateFreight {

	private final ItemRepository itemRepository;

	public SimulateFreight(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public SimulateFreightOutput execute(SimulateFreightInput input) {
		Freight freight = new Freight();
		for (OrderItemInput orderItem : input.getItems()) {
			Item item = this.itemRepository.get(orderItem.getIdItem());
			freight.addItem(item, orderItem.getQuantity());
		}
		return new SimulateFreightOutput(freight.getTotal());
	}
}
