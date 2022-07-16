package com.simpledev.ecommerce.infra.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.simpledev.ecommerce.domain.event.DomainEvent;

public class MemoryQueueAdapter implements Queue {
	private List<ConsumerQueue> consumers;

	public MemoryQueueAdapter() {
		this.consumers = new ArrayList<>();
	}

	@Override
	public void consume(String eventName, Consumer<DomainEvent> callback) {
		this.consumers.add(new ConsumerQueue(eventName, callback));

	}

	@Override
	public void publish(DomainEvent domainEvent) {
		for (ConsumerQueue consumer : consumers) {
			if (consumer.getEventName().equals(domainEvent.getName())) {
				consumer.getCallback().accept(domainEvent);
			}
		}
	}

}
