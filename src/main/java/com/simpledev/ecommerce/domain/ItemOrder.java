package com.simpledev.ecommerce.domain;

import java.math.BigDecimal;

public class ItemOrder {

	private Long idItem;
	private BigDecimal price;
	private int quantity;

	public ItemOrder(Long idItem, BigDecimal price, int quantity) {
		this.idItem = idItem;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getIdItem() {
		return idItem;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getTotal() {
		return this.getPrice().multiply(BigDecimal.valueOf(this.getQuantity()));
	}
}
