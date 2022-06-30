package com.simpledev.ecommerce.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private Cpf cpf;
	private List<OrderItem> items;
	private OrderCoupon coupon;
	private LocalDateTime createdAt;
	private Freight freigth;
	private OrderCode code;
	private Long sequence;

	public Order(String cpf) {
		this.cpf = new Cpf(cpf);
		this.items = new ArrayList<>();
		this.createdAt = LocalDateTime.now();
		this.freigth = new Freight();
		this.sequence = 1l;
		this.code = new OrderCode(this.createdAt, this.sequence);
	}

	public Order(String cpf, LocalDateTime createdAt, Long sequence) {
		this.cpf = new Cpf(cpf);
		this.items = new ArrayList<>();
		this.createdAt = createdAt;
		this.freigth = new Freight();
		this.sequence = sequence;
		this.code = new OrderCode(this.createdAt, this.sequence);
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
			this.coupon = new OrderCoupon(coupon.getCode(), coupon.getPercentage());
		}
	}

	public BigDecimal getFreight() {
		return this.freigth.getTotal();
	}

	public String getCode() {
		return code.getValue();
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public OrderCoupon getCoupon() {
		return coupon;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public Freight getFreigth() {
		return freigth;
	}
	
	public Long getSequence() {
		return sequence;
	}
}
