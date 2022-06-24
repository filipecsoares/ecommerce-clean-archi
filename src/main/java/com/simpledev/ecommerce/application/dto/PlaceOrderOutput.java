package com.simpledev.ecommerce.application.dto;

import java.math.BigDecimal;

public class PlaceOrderOutput {

	private BigDecimal total;

	public PlaceOrderOutput(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTotal() {
		return total;
	}
}
