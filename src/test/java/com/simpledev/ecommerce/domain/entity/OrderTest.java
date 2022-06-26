package com.simpledev.ecommerce.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class OrderTest {

	@Test
	void shouldNotCreateAnOrderWithInvalidCpf() {
		String invalidCpf = "111.111.111-11";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Order(invalidCpf);
		});

		String expectedMessage = "Invalid cpf";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void shouldCreateAnOrderWithThreeItems() {
		Order order = new Order("918.461.310-65");
		order.addItem(new Item(1L, "Guitar", BigDecimal.valueOf(1000)), 1);
		order.addItem(new Item(2L, "Book I", BigDecimal.valueOf(25.5)), 2);
		order.addItem(new Item(3L, "TV", BigDecimal.valueOf(1500.0)), 1);

		assertEquals(BigDecimal.valueOf(2551.0), order.getTotal());
	}

	@Test
	void shouldCreateAnOrderWithDiscountCoupon() {
		Order order = new Order("918.461.310-65");
		order.addItem(new Item(1L, "Guitar", BigDecimal.valueOf(500)), 1);
		order.addItem(new Item(2L, "Book I", BigDecimal.valueOf(100)), 2);
		order.addItem(new Item(3L, "TV", BigDecimal.valueOf(1300.0)), 1);

		order.addCoupon(new Coupon("VALE20", 20));

		assertEquals(BigDecimal.valueOf(1600.0), order.getTotal());
	}

	@Test
	void shouldCreateAnOrderWithExpiredDiscountCoupon() {
		Order order = new Order("918.461.310-65", LocalDateTime.of(2022, 2, 5, 1, 1), 1);
		order.addItem(new Item(1L, "Guitar", BigDecimal.valueOf(500)), 1);
		order.addItem(new Item(2L, "Book I", BigDecimal.valueOf(100)), 2);
		order.addItem(new Item(3L, "TV", BigDecimal.valueOf(1300.0)), 1);

		order.addCoupon(new Coupon("VALE20", 20, LocalDateTime.of(2022, 2, 2, 1, 1)));

		assertEquals(BigDecimal.valueOf(2000.0), order.getTotal());
	}

	@Test
	void shouldCreateAnOrderWithThreeItemsAndCalculateFreight() {
		Order order = new Order("918.461.310-65");
		order.addItem(new Item(1L, "Guitarra", BigDecimal.valueOf(1000), new Dimension(100, 30, 10), 3), 1);
		order.addItem(new Item(2L, "Amplificador", BigDecimal.valueOf(5000), new Dimension(50, 50, 50), 20), 1);
		order.addItem(new Item(3L, "Cabo", BigDecimal.valueOf(30), new Dimension(10, 10, 10), 1), 3);

		BigDecimal freight = order.getFreight();
		BigDecimal total = order.getTotal();

		assertEquals(BigDecimal.valueOf(260.0), freight);
		assertEquals(BigDecimal.valueOf(6350.0), total);
	}

	@Test
	void shouldCreateAnOrderWithThreeItemsAndGenerateCode() {
		Order order = new Order("918.461.310-65");
		order.addItem(new Item(1L, "Guitar", BigDecimal.valueOf(1000)), 1);
		order.addItem(new Item(2L, "Book I", BigDecimal.valueOf(25.5)), 2);
		order.addItem(new Item(3L, "TV", BigDecimal.valueOf(1500.0)), 1);

		assertEquals(BigDecimal.valueOf(2551.0), order.getTotal());
		assertEquals("202200000001", order.getCode());
	}
}
