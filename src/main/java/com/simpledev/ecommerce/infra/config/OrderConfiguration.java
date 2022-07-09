package com.simpledev.ecommerce.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simpledev.ecommerce.domain.repository.OrderRepository;
import com.simpledev.ecommerce.infra.repository.database.OrderRepositoryDatabase;

@Configuration
public class OrderConfiguration {

	@Bean
	public OrderRepository createOrderRepository() {
		return new OrderRepositoryDatabase();
	}
}
