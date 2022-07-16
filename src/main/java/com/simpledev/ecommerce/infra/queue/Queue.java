package com.simpledev.ecommerce.infra.queue;

import java.util.function.Consumer;

import com.simpledev.ecommerce.domain.event.DomainEvent;

public interface Queue {

	void consume(String eventName, Consumer<DomainEvent> callback);

	void publish(DomainEvent domainEvent);
}
