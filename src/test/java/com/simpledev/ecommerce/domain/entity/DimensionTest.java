package com.simpledev.ecommerce.domain.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.simpledev.ecommerce.domain.entity.Dimension;

class DimensionTest {

	@Test
	void shouldCreateDimension() {
		Dimension dimension = new Dimension(100, 30, 10);
		double volume = dimension.getVolume();
		assertEquals(0.03, volume);
	}

}
