package com.simpledev.ecommerce.domain.entity;

public class StockEntry {

	private Long idItem;
	private OperationEnum operation;
	private int quantity;

	public StockEntry(Long idItem, OperationEnum operation, int quantity) {
		super();
		this.idItem = idItem;
		this.operation = operation;
		this.quantity = quantity;
	}

	public Long getIdItem() {
		return idItem;
	}

	public OperationEnum getOperation() {
		return operation;
	}

	public int getQuantity() {
		return quantity;
	}
}
