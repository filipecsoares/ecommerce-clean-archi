package com.simpledev.ecommerce.application.dto;

import java.util.List;

public class SimulateFreightInput {

	private List<OrderItemInput> items;

	public SimulateFreightInput(List<OrderItemInput> items) {
		this.items = items;
	}

	public List<OrderItemInput> getItems() {
		return items;
	}
}
