package com.simpledev.ecommerce.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.simpledev.ecommerce.domain.entity.Coupon;

class CouponTest {

	@Test
	void shouldCalculateDiscount() {
		Coupon coupon = new Coupon("VALE10", 10);
		assertEquals(BigDecimal.valueOf(20), coupon.calculateDiscount(BigDecimal.valueOf(200)));
	}

	@Test
	void shouldCreateAnExpiredCoupon() {
		Coupon coupon = new Coupon("VALE10", 10, LocalDateTime.of(2022, 2, 2, 1, 1));
		assertTrue(coupon.isExpired(LocalDateTime.of(2022, 2, 3, 1, 1)));
	}

}
