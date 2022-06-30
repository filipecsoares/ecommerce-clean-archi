package com.simpledev.ecommerce.domain.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class CouponTest {

	@Test
	void shouldCreateAnExpiredCoupon() {
		Coupon coupon = new Coupon("VALE10", 10, LocalDateTime.of(2022, 2, 2, 1, 1));
		assertTrue(coupon.isExpired(LocalDateTime.of(2022, 2, 3, 1, 1)));
	}

}
