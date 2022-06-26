package com.simpledev.ecommerce.application.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PlaceOrderInput {

	private String cpf;
	private List<OrderItemInput> ordemItems;
	private String coupon;
	private LocalDateTime createdAt;

	public PlaceOrderInput(String cpf, List<OrderItemInput> ordemItems, LocalDateTime createdAt) {
		this.cpf = cpf;
		this.ordemItems = ordemItems;
		this.createdAt = createdAt;
	}

	public PlaceOrderInput(String cpf, List<OrderItemInput> ordemItems, String coupon, LocalDateTime createdAt) {
		this.cpf = cpf;
		this.ordemItems = ordemItems;
		this.coupon = coupon;
		this.createdAt = createdAt;
	}

	public String getCpf() {
		return this.cpf;
	}

	public List<OrderItemInput> getOrdemItems() {
		return this.ordemItems;
	}

	public String getCoupon() {
		return coupon;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}
