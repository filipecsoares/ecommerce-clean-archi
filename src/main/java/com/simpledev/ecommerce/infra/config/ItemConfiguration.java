package com.simpledev.ecommerce.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simpledev.ecommerce.domain.repository.ItemRepository;
import com.simpledev.ecommerce.infra.repository.database.ItemRepositoryDatabase;

@Configuration
public class ItemConfiguration {

	@Bean
	public ItemRepository createItemRepository() {
		return new ItemRepositoryDatabase();
	}
}
