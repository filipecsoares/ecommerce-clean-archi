package com.simpledev.ecommerce.infra.repository.database.models;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.simpledev.ecommerce.domain.entity.OperationEnum;

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
