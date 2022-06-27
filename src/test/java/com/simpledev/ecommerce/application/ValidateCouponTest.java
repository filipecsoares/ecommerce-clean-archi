package com.simpledev.ecommerce.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.simpledev.ecommerce.application.dto.ValidateCouponInput;
import com.simpledev.ecommerce.application.dto.ValidateCouponOutput;
import com.simpledev.ecommerce.domain.entity.Coupon;
import com.simpledev.ecommerce.domain.repository.CouponRepository;
import com.simpledev.ecommerce.infra.repository.memory.CouponRepositoryMemory;

class ValidateCouponTest {

	@Test
	void shouldValidateADiscountCouponExpired() {
		CouponRepository couponRepository = new CouponRepositoryMemory();
		couponRepository.save(new Coupon("VALE20", 20, LocalDateTime.of(2022, 2, 2, 1, 0)));
		ValidateCoupon validateCoupon = new ValidateCoupon(couponRepository);
		ValidateCouponInput input = new ValidateCouponInput("VALE20", LocalDateTime.of(2022, 2, 10, 1, 0));
		ValidateCouponOutput output = validateCoupon.execute(input);
		assertEquals(true, output.isExpired());
	}

	@Test
	void shouldValidateADiscountCouponValid() {
		CouponRepository couponRepository = new CouponRepositoryMemory();
		couponRepository.save(new Coupon("VALE20", 20, LocalDateTime.of(2022, 2, 11, 1, 0)));
		ValidateCoupon validateCoupon = new ValidateCoupon(couponRepository);
		ValidateCouponInput input = new ValidateCouponInput("VALE20", LocalDateTime.of(2022, 2, 10, 1, 0));
		ValidateCouponOutput output = validateCoupon.execute(input);
		assertEquals(false, output.isExpired());
	}

}
