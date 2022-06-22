package com.simpledev.ecommerce.domain;

import java.math.BigDecimal;

public class ItemOutput {

	private Long idItem;
	private String description;
	private BigDecimal price;

	public ItemOutput(Long idItem, String description, BigDecimal price) {
		this.idItem = idItem;
		this.description = description;
		this.price = price;
	}
}
