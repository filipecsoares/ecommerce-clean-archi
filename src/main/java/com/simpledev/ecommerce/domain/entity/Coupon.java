package com.simpledev.ecommerce.domain.entity;

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

	public String getCode() {
		return code;
	}

	public LocalDateTime getExpiredAt() {
		return expiredAt;
	}

	public boolean isExpired(LocalDateTime today) {
		return this.expiredAt.isBefore(today);
	}
}
