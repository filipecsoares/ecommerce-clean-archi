package com.simpledev.ecommerce.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Coupon {

	private String code;
	private int percentage;
	private LocalDateTime expiredAt;

	public Coupon(String code, int percentage) {
		this.code = code;
		this.percentage = percentage;
		this.expiredAt = LocalDateTime.now();
	}

	public Coupon(String code, int percentage, LocalDateTime expiredAt) {
		this.code = code;
		this.percentage = percentage;
		this.expiredAt = expiredAt;
	}

	public int getPercentage() {
		return this.percentage;
	}

	public BigDecimal calculateDiscount(BigDecimal total) {
		return total.multiply(BigDecimal.valueOf(this.getPercentage())).divide(BigDecimal.valueOf(100));
	}

	public boolean isExpired(LocalDateTime today) {
		return this.expiredAt.isBefore(today);
	}
}
