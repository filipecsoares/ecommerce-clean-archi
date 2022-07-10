package com.simpledev.ecommerce.infra.repository.database;

import org.springframework.beans.factory.annotation.Autowired;

import com.simpledev.ecommerce.domain.entity.Coupon;
import com.simpledev.ecommerce.domain.repository.CouponRepository;
import com.simpledev.ecommerce.infra.repository.database.jparepositories.CouponJPARepository;
import com.simpledev.ecommerce.infra.repository.database.models.CouponModel;

public class CouponRepositoryDatabase implements CouponRepository {

	@Autowired
	private CouponJPARepository couponJPARepository;

	@Override
	public Coupon get(String coupon) {
		CouponModel couponModel = this.couponJPARepository.findById(coupon).orElseThrow();
		return new Coupon(couponModel.getCode(), couponModel.getPercentage(), couponModel.getExpireDate());
	}

	@Override
	public void save(Coupon coupon) {
		this.couponJPARepository.save(new CouponModel(coupon.getCode(), coupon.getPercentage(), coupon.getExpiredAt()));
	}

}
