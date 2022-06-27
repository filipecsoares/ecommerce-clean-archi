package com.simpledev.ecommerce.application.dto;

import java.time.LocalDateTime;

public class ValidateCouponInput {

	private String code;
	private LocalDateTime date;

	public ValidateCouponInput(String code, LocalDateTime date) {
		this.code = code;
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public LocalDateTime getDate() {
		return date;
	}
}