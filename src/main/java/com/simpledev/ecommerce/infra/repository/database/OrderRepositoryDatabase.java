package com.simpledev.ecommerce.infra.repository.database;

import org.springframework.beans.factory.annotation.Autowired;

import com.simpledev.ecommerce.domain.entity.Order;
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

}
