package com.simpledev.ecommerce.domain.entity;

import java.math.BigDecimal;

public class OrderItem {

	private Long idItem;
	private BigDecimal price;
	private int quantity;

	public OrderItem(Long idItem, BigDecimal price, int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("Invalid quantity");
		}
		this.idItem = idItem;
		this.price = price;
		this.quantity = quantity;
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

	public Long getIdItem() {
		return idItem;
	}
}
