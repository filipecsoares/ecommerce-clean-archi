package com.simpledev.ecommerce.infra.repository.database;

import org.springframework.beans.factory.annotation.Autowired;

import com.simpledev.ecommerce.domain.entity.Order;
import com.simpledev.ecommerce.domain.repository.OrderRepository;

public class OrderRepositoryDatabase implements OrderRepository {

	@Autowired
	private OrderJPARepository orderJPARepository;

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public long count() {
		return orderJPARepository.count();
	}

}
