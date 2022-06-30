package com.simpledev.ecommerce.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class OrderCouponTest {

	@Test
	void shouldCalculateDiscount() {
		OrderCoupon coupon = new OrderCoupon("VALE10", 10);
		assertEquals(BigDecimal.valueOf(20), coupon.calculateDiscount(BigDecimal.valueOf(200)));
	}
}
