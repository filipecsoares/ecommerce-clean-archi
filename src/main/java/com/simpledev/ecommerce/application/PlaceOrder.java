package com.simpledev.ecommerce.application;

import java.math.BigDecimal;

import com.simpledev.ecommerce.application.dto.OrderItemInput;
import com.simpledev.ecommerce.application.dto.PlaceOrderInput;
import com.simpledev.ecommerce.application.dto.PlaceOrderOutput;
import com.simpledev.ecommerce.domain.entity.Coupon;
import com.simpledev.ecommerce.domain.entity.Item;
import com.simpledev.ecommerce.domain.entity.Order;
import com.simpledev.ecommerce.domain.event.OrderPlaced;
import com.simpledev.ecommerce.domain.factory.RepositoryFactory;
import com.simpledev.ecommerce.domain.repository.CouponRepository;
import com.simpledev.ecommerce.domain.repository.ItemRepository;
import com.simpledev.ecommerce.domain.repository.OrderRepository;
import com.simpledev.ecommerce.infra.queue.Queue;

public class PlaceOrder {

	private final ItemRepository itemRepository;
	private final OrderRepository orderRepository;
	private final CouponRepository couponRepository;
	private final Queue queue;

	public PlaceOrder(RepositoryFactory repositoryFactory, Queue queue) {
		this.itemRepository = repositoryFactory.createItemRepository();
		this.orderRepository = repositoryFactory.createOrderRepository();
		this.couponRepository = repositoryFactory.createCouponRepository();
		this.queue = queue;
	}

	public PlaceOrderOutput execute(PlaceOrderInput input) {
		Long sequence = this.orderRepository.count() + 1;
		Order order = new Order(input.getCpf(), input.getCreatedAt(), sequence);
		for (OrderItemInput ordemItem : input.getOrdemItems()) {
			Item item = this.itemRepository.get(ordemItem.getIdItem());
			order.addItem(item, ordemItem.getQuantity());
		}
		if (input.getCoupon() != null) {
			Coupon coupon = this.couponRepository.get(input.getCoupon());
			order.addCoupon(coupon);
		}
		this.orderRepository.save(order);
		OrderPlaced orderPlaced = new OrderPlaced(order.getCode(), order.getItems());
		queue.publish(orderPlaced);
		BigDecimal total = order.getTotal();
		return new PlaceOrderOutput(total, order.getCode());
	}

}
