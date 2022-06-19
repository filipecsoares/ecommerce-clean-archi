package com.simpledev.ecommerce.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private Cpf cpf;
	private List<ItemOrder> items;
	private Coupon coupon;

	public Order(String cpf) {
		this.cpf = new Cpf(cpf);
		this.items = new ArrayList<>();
	}

	public void addItem(Item item, int quantity) {
		this.items.add(new ItemOrder(item.getId(), item.getPrice(), quantity));
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (ItemOrder orderItem : items) {
			total = total.add(orderItem.getTotal());
		}
		if (this.coupon != null) {
			total = total.subtract(this.coupon.calculateDiscount(total));
		}
		return total;
	}

	public void addCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
}
