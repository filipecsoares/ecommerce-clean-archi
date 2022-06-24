package com.simpledev.ecommerce.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.simpledev.ecommerce.domain.entity.OrderItem;

class OrderItemTest {

	@Test
	void shouldCreateAnOrderItem() {
		OrderItem item = new OrderItem(1L, BigDecimal.valueOf(100), 2);
		assertEquals(BigDecimal.valueOf(200), item.getTotal());
	}

}
