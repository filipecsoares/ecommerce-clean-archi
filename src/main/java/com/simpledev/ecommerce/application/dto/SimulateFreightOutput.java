package com.simpledev.ecommerce.application.dto;

import java.math.BigDecimal;

public class SimulateFreightOutput {

	private BigDecimal total;

	public SimulateFreightOutput(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTotal() {
		return total;
	}

}
