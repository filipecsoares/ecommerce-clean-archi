package com.simpledev.ecommerce.infra.repository.database.models;

import com.simpledev.ecommerce.domain.entity.OperationEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "stock_entry_model")
public class StockEntryModel {

	public StockEntryModel(Long idItem, OperationEnum operation, int quantity) {
		this.idItem = idItem;
		this.operation = operation;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idItem;
	@Enumerated
	private OperationEnum operation;
	private int quantity;
}
