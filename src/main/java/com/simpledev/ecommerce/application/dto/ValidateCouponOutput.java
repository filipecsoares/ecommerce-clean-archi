package com.simpledev.ecommerce.application.dto;

public class ValidateCouponOutput {

	private boolean expired;

	public ValidateCouponOutput(boolean expired) {
		this.expired = expired;
	}

	public boolean isExpired() {
		return expired;
	}

}
