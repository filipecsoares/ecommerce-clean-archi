package com.simpledev.ecommerce.application;

import com.simpledev.ecommerce.application.dto.ValidateCouponInput;
import com.simpledev.ecommerce.application.dto.ValidateCouponOutput;
import com.simpledev.ecommerce.domain.entity.Coupon;
import com.simpledev.ecommerce.domain.repository.CouponRepository;

public class ValidateCoupon {

	private final CouponRepository couponRepository;

	public ValidateCoupon(CouponRepository couponRepository) {
		this.couponRepository = couponRepository;
	}

	public ValidateCouponOutput execute(ValidateCouponInput input) {
		Coupon coupon = this.couponRepository.get(input.getCode());
		return new ValidateCouponOutput(coupon.isExpired(input.getDate()));
	}
}
