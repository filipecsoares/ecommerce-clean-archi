package com.simpledev.ecommerce.domain.repository;

import com.simpledev.ecommerce.domain.entity.Coupon;

public interface CouponRepository {

	Coupon get(String coupon);
	void save(Coupon coupon);

}
