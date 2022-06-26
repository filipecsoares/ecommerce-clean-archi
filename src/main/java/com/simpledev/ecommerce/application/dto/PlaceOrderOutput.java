package com.simpledev.ecommerce.application.dto;

import java.math.BigDecimal;

public class PlaceOrderOutput {

	private BigDecimal total;
	private String code;

	public PlaceOrderOutput(BigDecimal total, String code) {
		this.total = total;
		this.code = code;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public String getCode() {
		return code;
	}
}
