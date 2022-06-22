package com.simpledev.ecommerce.domain;

import java.math.BigDecimal;

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
