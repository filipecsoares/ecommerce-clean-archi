package com.simpledev.ecommerce.infra.queue;

import java.util.function.Consumer;

import com.simpledev.ecommerce.domain.event.DomainEvent;

public class ConsumerQueue {

	private String eventName;
	private Consumer<DomainEvent> callback;

	public ConsumerQueue(String eventName, Consumer<DomainEvent> callback) {
		this.eventName = eventName;
		this.callback = callback;
	}

	public String getEventName() {
		return eventName;
	}

	public Consumer<DomainEvent> getCallback() {
		return callback;
	}
}
