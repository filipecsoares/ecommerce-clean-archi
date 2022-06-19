package com.simpledev.ecommerce.domain;

import java.math.BigDecimal;

public class Coupon {

	private String code;
	private int percentage;

	public Coupon(String code, int percentage) {
		this.code = code;
		this.percentage = percentage;
	}

	public int getPercentage() {
		return this.percentage;
	}

	public BigDecimal calculateDiscount(BigDecimal total) {
		return total.multiply(BigDecimal.valueOf(this.getPercentage())).divide(BigDecimal.valueOf(100));
	}
}
