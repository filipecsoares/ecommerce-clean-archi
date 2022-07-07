package com.simpledev.ecommerce.infra.repository.database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.simpledev.ecommerce.domain.entity.Order;
import com.simpledev.ecommerce.domain.entity.OrderCoupon;
import com.simpledev.ecommerce.domain.entity.OrderItem;
import com.simpledev.ecommerce.domain.repository.OrderRepository;
import com.simpledev.ecommerce.infra.repository.database.jparepositories.OrderItemJPARepository;
import com.simpledev.ecommerce.infra.repository.database.jparepositories.OrderJPARepository;
import com.simpledev.ecommerce.infra.repository.database.models.OrderItemModel;
import com.simpledev.ecommerce.infra.repository.database.models.OrderModel;

public class OrderRepositoryDatabase implements OrderRepository {

	@Autowired
	private OrderJPARepository orderJPARepository;
	@Autowired
	private OrderItemJPARepository orderItemJPARepository;

	@Override
	public void save(Order order) {
		OrderModel orderModel;
		if (order.getCoupon() == null) {
			orderModel = OrderModel.builder().code(order.getCode()).cpf(order.getCpf().getValue())
					.issueDate(order.getCreatedAt()).freight(order.getFreight()).sequence(order.getSequence())
					.total(order.getTotal()).build();
		} else {
			orderModel = OrderModel.builder().code(order.getCode()).couponCode(order.getCoupon().getCode())
					.couponPercentage(order.getCoupon().getPercentage()).cpf(order.getCpf().getValue())
					.issueDate(order.getCreatedAt()).freight(order.getFreight()).sequence(order.getSequence())
					.total(order.getTotal()).build();
		}
		OrderModel savedOrder = this.orderJPARepository.save(orderModel);
		for (OrderItem orderItem : order.getItems()) {
			OrderItemModel orderItemModel = OrderItemModel.builder().idOrder(savedOrder.getId())
					.idItem(orderItem.getIdItem()).price(orderItem.getPrice()).quantity(orderItem.getQuantity())
					.build();
			this.orderItemJPARepository.save(orderItemModel);
		}

	}

	@Override
	public long count() {
		return orderJPARepository.count();
	}

	@Override
	public Order get(String code) {
		OrderModel orderModel = orderJPARepository.findByCode(code).stream().findFirst().orElseThrow();
		Order order = new Order(orderModel.getCpf(), orderModel.getIssueDate(), orderModel.getSequence());
		List<OrderItemModel> items = orderItemJPARepository.findByIdOrder(orderModel.getId());
		order.setItems(items.stream().map(item -> new OrderItem(item.getIdItem(), item.getPrice(), item.getQuantity()))
				.collect(Collectors.toList()));
		if (orderModel.getCouponCode() != null) {
			order.setCoupon(new OrderCoupon(orderModel.getCouponCode(), orderModel.getCouponPercentage()));
		}
		return order;

	}

	@Override
	public List<Order> list() {
		List<Order> orders = new ArrayList<>();
		List<String> codes = orderJPARepository.findCodes();
		for (String code : codes) {
			orders.add(get(code));
		}
		return orders;
	}
}
