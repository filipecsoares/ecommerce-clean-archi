package com.simpledev.ecommerce.application;

import java.math.BigDecimal;

import com.simpledev.ecommerce.application.dto.OrderItemInput;
import com.simpledev.ecommerce.application.dto.PlaceOrderInput;
import com.simpledev.ecommerce.application.dto.PlaceOrderOutput;
import com.simpledev.ecommerce.domain.entity.Item;
import com.simpledev.ecommerce.domain.entity.Order;
import com.simpledev.ecommerce.domain.repository.ItemRepository;
import com.simpledev.ecommerce.domain.repository.OrderRepository;

public class PlaceOrder {

	private final ItemRepository itemRepository;
	private final OrderRepository orderRepository;

	public PlaceOrder(ItemRepository itemRepository, OrderRepository orderRepository) {
		this.itemRepository = itemRepository;
		this.orderRepository = orderRepository;
	}

	public PlaceOrderOutput execute(PlaceOrderInput input) {
		Order order = new Order(input.getCpf());
		for (OrderItemInput ordemItem : input.getOrdemItems()) {
			Item item = this.itemRepository.get(ordemItem.getIdItem());
			order.addItem(item, ordemItem.getQuantity());
		}
		this.orderRepository.save(order);
		BigDecimal total = order.getTotal();
		return new PlaceOrderOutput(total);
	}

}
