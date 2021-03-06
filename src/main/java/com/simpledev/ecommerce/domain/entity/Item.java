package com.simpledev.ecommerce.domain.entity;

import java.math.BigDecimal;

public class Item {
	private Long id;
	private String description;
	private BigDecimal price;
	private Dimension dimension;
	private double weight;

	public Item(Long id, String description, BigDecimal price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}

	public Item(Long id, String description, BigDecimal price, Dimension dimension, double weight) {
		if (weight < 0) {
			throw new IllegalArgumentException("Invalid weight");
		}
		this.id = id;
		this.description = description;
		this.price = price;
		this.dimension = dimension;
		this.weight = weight;
	}

	public Long getId() {
		return this.id;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public double getWeight() {
		return weight;
	}

	public double getVolume() {
		if (this.dimension != null) {
			return this.dimension.getVolume();
		} else {
			return 0.0;
		}
	}

	public double getDensity() {
		if (this.dimension != null && this.weight > 0) {
			return this.weight / this.dimension.getVolume();
		} else {
			return 0.0;
		}
	}
}
