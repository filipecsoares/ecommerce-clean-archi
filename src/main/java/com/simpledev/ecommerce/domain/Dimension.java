package com.simpledev.ecommerce.domain;

public class Dimension {

	private double width;
	private double height;
	private double length;

	public Dimension(double width, double height, double length) {
		this.width = width;
		this.height = height;
		this.length = length;
	}

	public double getVolume() {
		return (this.width / 100) * (this.height / 100) * (this.length / 100);
	}

}
