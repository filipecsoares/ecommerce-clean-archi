package com.simpledev.ecommerce.domain;

import java.util.Arrays;

public class Cpf {

	private static final int SECOND_DIGIT_FACTOR = 11;
	private static final int FIRST_DIGIT_FACTOR = 10;
	private String value;

	public Cpf(String value) {
		if (!this.validate(value)) {
			throw new IllegalArgumentException("Invalid cpf");
		}
		this.value = value;
	}

	private boolean validate(String value) {
		if (value == null) {
			return false;
		}
		String cpf = cleanCpf(value);
		if (!isValidLength(cpf)) {
			return false;
		}
		if (isAllSameCharacter(cpf)) {
			return false;
		}
		int calculatedCheckDigit1 = calculateCheckDigit(cpf, FIRST_DIGIT_FACTOR);
		int calculatedCheckDigit2 = calculateCheckDigit(cpf, SECOND_DIGIT_FACTOR);
		String checkDigit = extractCheckDigit(cpf);
		String calculatedCheckDigit = calculatedCheckDigit1 + "" + calculatedCheckDigit2;
		return checkDigit.equals(calculatedCheckDigit);
	}

	private String extractCheckDigit(String cpf) {
		return cpf.substring(cpf.length() - 2, cpf.length());
	}

	private int calculateCheckDigit(String cpf, int factor) {
		int total = 0;
		for (String digit : cpf.split("")) {
			if (factor > 1) {
				total += Integer.parseInt(digit) * factor--;
			}
		}
		int rest = total % 11;
		return (rest < 2) ? 0 : 11 - rest;
	}

	private boolean isValidLength(final String cpf) {
		return cpf.length() == 11;
	}

	private boolean isAllSameCharacter(final String cpf) {
		String firstCharacter = cpf.substring(0, 1);
		return Arrays.asList(cpf.split("")).stream().allMatch(s -> s.equals(firstCharacter));
	}

	private String cleanCpf(final String cpf) {
		return cpf.replaceAll("[.-]", "");
	}

	public String getValue() {
		return this.value;
	}
}
