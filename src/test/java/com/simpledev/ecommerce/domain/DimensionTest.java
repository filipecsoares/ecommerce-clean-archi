package com.simpledev.ecommerce.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DimensionTest {

	@Test
	void shouldCreateDimension() {
		Dimension dimension = new Dimension(100, 30, 10);
		double volume = dimension.getVolume();
		assertEquals(0.03, volume);
	}

}
