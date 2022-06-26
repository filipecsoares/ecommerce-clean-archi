package com.simpledev.ecommerce.domain.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class OrderCodeTest {

	@Test
	void shouldGenerateAnOrderCode() {
		OrderCode code = new OrderCode(LocalDateTime.of(2022, 3, 10, 1, 0), 1);
		assertEquals("202200000001", code.getValue());
	}

}
