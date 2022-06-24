package com.simpledev.ecommerce.application.dto;

import java.util.List;

public class PlaceOrderInput {

	private String cpf;
	private List<OrderItemInput> ordemItems;
	private String coupon;

	public PlaceOrderInput(String cpf, List<OrderItemInput> ordemItems) {
		this.cpf = cpf;
		this.ordemItems = ordemItems;
	}

	public PlaceOrderInput(String cpf, List<OrderItemInput> ordemItems, String coupon) {
		this.cpf = cpf;
		this.ordemItems = ordemItems;
		this.coupon = coupon;
	}

	public String getCpf() {
		return this.cpf;
	}

	public List<OrderItemInput> getOrdemItems() {
		return this.ordemItems;
	}
}
