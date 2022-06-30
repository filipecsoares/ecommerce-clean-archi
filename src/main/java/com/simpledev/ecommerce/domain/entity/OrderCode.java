package com.simpledev.ecommerce.domain.entity;

import java.time.LocalDateTime;

public class OrderCode {

	private String value;

	public OrderCode(LocalDateTime date, Long sequence) {
		this.value = generateCode(date, sequence);
	}

	public String getValue() {
		return value;
	}

	private String generateCode(LocalDateTime date, Long sequence) {
		String formatedSequence = String.format("%1$" + 8 + "s", sequence).replace(' ', '0');
		return date.getYear() + formatedSequence;
	}
}
