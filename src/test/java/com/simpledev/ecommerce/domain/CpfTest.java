package com.simpledev.ecommerce.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CpfTest {

	@Test
	void shouldValidateAValidCpf() {
		String cpf = "918.461.310-65";
		Cpf cpfValidated = new Cpf(cpf);
		assertEquals(cpf, cpfValidated.getValue());
	}

	@Test
	void shouldValidateAValidCpfOnlyNumbers() {
		String cpf = "91846131065";
		Cpf cpfValidated = new Cpf(cpf);
		assertEquals(cpf, cpfValidated.getValue());
	}

	@Test
	void shouldNotValidateAnInvalidCpfWithAllDigitsEqual() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Cpf("222.222.222-22");
		});

		String expectedMessage = "Invalid cpf";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void shouldNotValidateAnInvalidCpf() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Cpf("123.456.789-10");
		});

		String expectedMessage = "Invalid cpf";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void shouldNotValidateANullCpf() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Cpf(null);
		});

		String expectedMessage = "Invalid cpf";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void shouldNotValidateACpfWithWrongLength() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Cpf("123.456.789-1000");
		});

		String expectedMessage = "Invalid cpf";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

}
