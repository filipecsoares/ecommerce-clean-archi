package com.simpledev.ecommerce.application.dto;

import java.math.BigDecimal;

public class ItemOutput {

	private Long idItem;
	private String description;
	private BigDecimal price;

	public ItemOutput() {

	}

	public ItemOutput(Long idItem, String description, BigDecimal price) {
		this.idItem = idItem;
		this.description = description;
		this.price = price;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
