package com.simpledev.ecommerce.domain.entity;

public class Dimension {

	private double width;
	private double height;
	private double length;

	public Dimension(double width, double height, double length) {
		if (width < 0 || height < 0 || length < 0) {
			throw new IllegalArgumentException("Invalid dimension");
		}
		this.width = width;
		this.height = height;
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getLength() {
		return length;
	}

	public double getVolume() {
		return (this.width / 100) * (this.height / 100) * (this.length / 100);
	}

}
