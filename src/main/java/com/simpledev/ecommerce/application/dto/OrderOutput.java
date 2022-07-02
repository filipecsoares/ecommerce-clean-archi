package com.simpledev.ecommerce.application.dto;

import java.math.BigDecimal;

public class OrderOutput {

	private String code;
	private BigDecimal total;

	public OrderOutput(String code, BigDecimal total) {
		this.code = code;
		this.total = total;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
