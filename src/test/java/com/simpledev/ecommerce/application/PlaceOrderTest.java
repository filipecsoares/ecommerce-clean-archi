package com.simpledev.ecommerce.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.simpledev.ecommerce.application.dto.OrderItemInput;
import com.simpledev.ecommerce.application.dto.PlaceOrderInput;
import com.simpledev.ecommerce.application.dto.PlaceOrderOutput;
import com.simpledev.ecommerce.application.dto.StockOutput;
import com.simpledev.ecommerce.domain.entity.Coupon;
import com.simpledev.ecommerce.domain.entity.Dimension;
import com.simpledev.ecommerce.domain.entity.Item;
import com.simpledev.ecommerce.domain.factory.RepositoryFactory;
import com.simpledev.ecommerce.domain.repository.CouponRepository;
import com.simpledev.ecommerce.domain.repository.ItemRepository;
import com.simpledev.ecommerce.infra.controller.StockController;
import com.simpledev.ecommerce.infra.factory.MemoryRepositoryFactory;
import com.simpledev.ecommerce.infra.queue.MemoryQueueAdapter;
import com.simpledev.ecommerce.infra.queue.Queue;

class PlaceOrderTest {

	private RepositoryFactory repositoryFactory;
	private ItemRepository itemRepository;
	private CouponRepository couponRepository;
	private Queue queue;

	@BeforeEach
	void setup() {
		this.repositoryFactory = new MemoryRepositoryFactory();
		this.itemRepository = repositoryFactory.createItemRepository();
		this.couponRepository = repositoryFactory.createCouponRepository();
		this.queue = new MemoryQueueAdapter();
	}

	@Test
	void shouldPlaceAnOrder() {
		itemRepository.save(new Item(1L, "Guitarra", BigDecimal.valueOf(1000), new Dimension(100, 30, 10), 3));
		itemRepository.save(new Item(2L, "Amplificador", BigDecimal.valueOf(5000), new Dimension(50, 50, 50), 20));
		itemRepository.save(new Item(3L, "Cabo", BigDecimal.valueOf(30), new Dimension(10, 10, 10), 1));
		PlaceOrder placeOrder = new PlaceOrder(repositoryFactory, queue);
		OrderItemInput item1 = new OrderItemInput(1L, 1);
		OrderItemInput item2 = new OrderItemInput(2L, 1);
		OrderItemInput item3 = new OrderItemInput(3L, 3);
		List<OrderItemInput> orderItems = Arrays.asList(item1, item2, item3);
		PlaceOrderInput input = new PlaceOrderInput("918.461.310-65", orderItems, LocalDateTime.of(2022, 3, 10, 1, 0));

		PlaceOrderOutput output = placeOrder.execute(input);

		assertEquals(BigDecimal.valueOf(6350.0), output.getTotal());
	}

	@Test
	void shouldPlaceAnOrderAndGenerateOrderCode() {
		itemRepository.save(new Item(1L, "Guitarra", BigDecimal.valueOf(1000), new Dimension(100, 30, 10), 3));
		itemRepository.save(new Item(2L, "Amplificador", BigDecimal.valueOf(5000), new Dimension(50, 50, 50), 20));
		itemRepository.save(new Item(3L, "Cabo", BigDecimal.valueOf(30), new Dimension(10, 10, 10), 1));
		PlaceOrder placeOrder = new PlaceOrder(repositoryFactory, queue);
		OrderItemInput item1 = new OrderItemInput(1L, 1);
		OrderItemInput item2 = new OrderItemInput(2L, 1);
		OrderItemInput item3 = new OrderItemInput(3L, 3);
		List<OrderItemInput> orderItems = Arrays.asList(item1, item2, item3);
		PlaceOrderInput input = new PlaceOrderInput("918.461.310-65", orderItems, LocalDateTime.of(2022, 3, 10, 1, 0));

		PlaceOrderOutput output = placeOrder.execute(input);

		assertEquals(BigDecimal.valueOf(6350.0), output.getTotal());
		assertEquals("202200000001", output.getCode());
	}

	@Test
	void shouldPlaceAnOrderWithDiscountCoupon() {
		itemRepository.save(new Item(1L, "Guitarra", BigDecimal.valueOf(1000), new Dimension(100, 30, 10), 3));
		itemRepository.save(new Item(2L, "Amplificador", BigDecimal.valueOf(5000), new Dimension(50, 50, 50), 20));
		itemRepository.save(new Item(3L, "Cabo", BigDecimal.valueOf(30), new Dimension(10, 10, 10), 1));
		couponRepository.save(new Coupon("VALE20", 20));
		PlaceOrder placeOrder = new PlaceOrder(repositoryFactory, queue);
		OrderItemInput item1 = new OrderItemInput(1L, 1);
		OrderItemInput item2 = new OrderItemInput(2L, 1);
		OrderItemInput item3 = new OrderItemInput(3L, 3);
		List<OrderItemInput> orderItems = Arrays.asList(item1, item2, item3);
		PlaceOrderInput input = new PlaceOrderInput("918.461.310-65", orderItems, "VALE20",
				LocalDateTime.of(2022, 3, 10, 1, 0));

		PlaceOrderOutput output = placeOrder.execute(input);

		assertEquals(BigDecimal.valueOf(5132.0), output.getTotal());
	}

	@Test
	void shouldPlaceAnOrderAndUpdateStock() {
		new StockController(queue, repositoryFactory);
		itemRepository.save(new Item(1L, "Guitarra", BigDecimal.valueOf(1000), new Dimension(100, 30, 10), 3));
		itemRepository.save(new Item(2L, "Amplificador", BigDecimal.valueOf(5000), new Dimension(50, 50, 50), 20));
		itemRepository.save(new Item(3L, "Cabo", BigDecimal.valueOf(30), new Dimension(10, 10, 10), 1));
		PlaceOrder placeOrder = new PlaceOrder(repositoryFactory, queue);
		OrderItemInput item1 = new OrderItemInput(1L, 1);
		OrderItemInput item2 = new OrderItemInput(2L, 1);
		OrderItemInput item3 = new OrderItemInput(3L, 3);
		List<OrderItemInput> orderItems = Arrays.asList(item1, item2, item3);
		PlaceOrderInput input = new PlaceOrderInput("918.461.310-65", orderItems, LocalDateTime.of(2022, 3, 10, 1, 0));

		placeOrder.execute(input);
		GetStock getStock = new GetStock(repositoryFactory);
		StockOutput output = getStock.execute(3L);

		assertEquals(-3, output.getTotal());
	}
}
