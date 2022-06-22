package com.simpledev.ecommerce.domain;

public class OrderItemInput {

	private Long idItem;
	private int quantity;

	public OrderItemInput(Long idItem, int quantity) {
		this.idItem = idItem;
		this.quantity = quantity;
	}

	public Long getIdItem() {
		return this.idItem;
	}

	public int getQuantity() {
		return this.quantity;
	}
}
