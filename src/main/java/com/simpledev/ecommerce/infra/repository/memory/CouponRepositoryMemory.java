package com.simpledev.ecommerce.infra.repository.memory;

import java.util.ArrayList;
import java.util.List;

import com.simpledev.ecommerce.domain.entity.Coupon;
import com.simpledev.ecommerce.domain.repository.CouponRepository;

public class CouponRepositoryMemory implements CouponRepository {

	private List<Coupon> coupons;

	public CouponRepositoryMemory() {
		this.coupons = new ArrayList<>();
	}

	@Override
	public Coupon get(String coupon) {
		return this.coupons.stream().filter(c -> coupon.equals(c.getCode())).findFirst().orElseThrow();
	}

	@Override
	public void save(Coupon coupon) {
		this.coupons.add(coupon);
	}

}
