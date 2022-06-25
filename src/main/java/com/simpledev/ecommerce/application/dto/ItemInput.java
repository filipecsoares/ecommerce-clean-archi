package com.simpledev.ecommerce.application.dto;

import java.math.BigDecimal;

import com.simpledev.ecommerce.domain.entity.Dimension;

public class ItemInput {
	private String description;
	private BigDecimal price;
	private Dimension dimension;
	private double weight;

	public ItemInput() {
	}

	public ItemInput(String description, BigDecimal price, Dimension dimension, double weight) {
		this.description = description;
		this.price = price;
		this.dimension = dimension;
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public double getWeight() {
		return weight;
	}
}
