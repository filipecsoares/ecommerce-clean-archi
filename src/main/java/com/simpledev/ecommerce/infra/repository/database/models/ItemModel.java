package com.simpledev.ecommerce.infra.repository.database.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "item")
public class ItemModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String category;
	private String description;
	private BigDecimal price;
	private Double width;
	private Double height;
	private Double length;
	private Double weight;

	public ItemModel(String description, BigDecimal price, Double weight) {
		this.description = description;
		this.price = price;
		this.weight = weight;
	}

	public ItemModel(String description, BigDecimal price, Double width, Double height, Double length, Double weight) {
		this.description = description;
		this.price = price;
		this.width = width;
		this.height = height;
		this.length = length;
		this.weight = weight;
	}
}
