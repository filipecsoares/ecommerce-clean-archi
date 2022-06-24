package com.simpledev.ecommerce.domain.entity;

import java.math.BigDecimal;

public class Freight {

	private final int DISTANCE = 1000;
	private final int FACTOR = 100;
	private final BigDecimal MIN_FREIGHT = BigDecimal.valueOf(10);

	private BigDecimal total;

	public Freight() {
		this.total = BigDecimal.ZERO;
	}

	public void addItem(Item item, int quantity) {
		double freight = item.getVolume() * this.DISTANCE * (item.getDensity() / this.FACTOR);
		this.total = this.total.add(BigDecimal.valueOf(freight * quantity));
	}

	public BigDecimal getTotal() {
		return (this.total.doubleValue() > 0 && this.total.doubleValue() < this.MIN_FREIGHT.doubleValue())
				? this.MIN_FREIGHT
				: this.total;
	}

}
