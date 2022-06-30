package com.simpledev.ecommerce.domain.entity;

import java.math.BigDecimal;

public class OrderCoupon {

	private String code;
	private int percentage;

	public OrderCoupon(String code, int percentage) {
		super();
		this.code = code;
		this.percentage = percentage;
	}

	public String getCode() {
		return code;
	}

	public int getPercentage() {
		return percentage;
	}

	public BigDecimal calculateDiscount(BigDecimal total) {
		return total.multiply(BigDecimal.valueOf(this.getPercentage())).divide(BigDecimal.valueOf(100));
	}
}
