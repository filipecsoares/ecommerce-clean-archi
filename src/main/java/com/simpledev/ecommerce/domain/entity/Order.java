package com.simpledev.ecommerce.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private Cpf cpf;
	private List<OrderItem> items;
	private Coupon coupon;
	private LocalDateTime createdAt;
	private Freight freigth;
	private OrderCode code;

	public Order(String cpf) {
		this.cpf = new Cpf(cpf);
		this.items = new ArrayList<>();
		this.createdAt = LocalDateTime.now();
		this.freigth = new Freight();
		this.code = new OrderCode(this.createdAt, 1);
	}

	public Order(String cpf, LocalDateTime createdAt, Integer sequence) {
		this.cpf = new Cpf(cpf);
		this.items = new ArrayList<>();
		this.createdAt = createdAt;
		this.freigth = new Freight();
		this.code = new OrderCode(this.createdAt, sequence);
	}

	public void addItem(Item item, int quantity) {
		this.freigth.addItem(item, quantity);
		this.items.add(new OrderItem(item.getId(), item.getPrice(), quantity));
	}
	
	public Cpf getCpf() {
		return cpf;
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (OrderItem orderItem : items) {
			total = total.add(orderItem.getTotal());
		}
		if (this.coupon != null) {
			total = total.subtract(this.coupon.calculateDiscount(total));
		}
		total = total.add(this.freigth.getTotal());
		return total;
	}

	public void addCoupon(Coupon coupon) {
		if (!coupon.isExpired(this.createdAt)) {
			this.coupon = coupon;
		}
	}

	public BigDecimal getFreight() {
		return this.freigth.getTotal();
	}

	public String getCode() {
		return code.getValue();
	}
}
