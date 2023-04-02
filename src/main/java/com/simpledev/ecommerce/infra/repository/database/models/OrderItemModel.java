package com.simpledev.ecommerce.infra.repository.database.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class)
public class OrderItemModel {
	@Id
	@Column(name = "id_order")
	private Long idOrder;
	@Id
	@Column(name = "id_item")
	private Long idItem;
	private String category;
	private BigDecimal price;
	private Integer quantity;
}
