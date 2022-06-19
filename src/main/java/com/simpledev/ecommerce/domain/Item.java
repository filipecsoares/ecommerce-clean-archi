package com.simpledev.ecommerce.domain;

import java.math.BigDecimal;

public class Item {
	private Long id;
	private String description;
	private BigDecimal price;

	public Item(Long id, String description, BigDecimal price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}

	public Long getId() {
		return this.id;
	}

	public BigDecimal getPrice() {
		return this.price;
	}
}
