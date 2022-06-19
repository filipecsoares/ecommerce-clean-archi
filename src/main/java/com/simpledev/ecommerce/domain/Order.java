package com.simpledev.ecommerce.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private Cpf cpf;
	private List<OrderItem> items;
	private Coupon coupon;
	private LocalDateTime createdAt;

	public Order(String cpf) {
		this.cpf = new Cpf(cpf);
		this.items = new ArrayList<>();
		this.createdAt = LocalDateTime.now();
	}

	public Order(String cpf, LocalDateTime createdAt) {
		this.cpf = new Cpf(cpf);
		this.items = new ArrayList<>();
		this.createdAt = createdAt;
	}

	public void addItem(Item item, int quantity) {
		this.items.add(new OrderItem(item.getId(), item.getPrice(), quantity));
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (OrderItem orderItem : items) {
			total = total.add(orderItem.getTotal());
		}
		if (this.coupon != null) {
			total = total.subtract(this.coupon.calculateDiscount(total));
		}
		return total;
	}

	public void addCoupon(Coupon coupon) {
		if (!coupon.isExpired(this.createdAt)) {
			this.coupon = coupon;
		}
	}
}
