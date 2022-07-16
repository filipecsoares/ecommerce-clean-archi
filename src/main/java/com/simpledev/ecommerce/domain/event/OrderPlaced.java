package com.simpledev.ecommerce.domain.event;

import java.util.List;

import com.simpledev.ecommerce.domain.entity.OrderItem;

public class OrderPlaced implements DomainEvent {

	private String code;
	private List<OrderItem> orderItems;

	public OrderPlaced(String code, List<OrderItem> orderItems) {
		this.code = code;
		this.orderItems = orderItems;
	}

	@Override
	public String getName() {
		return "orderPlaced";
	}

	public String getCode() {
		return code;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

}
