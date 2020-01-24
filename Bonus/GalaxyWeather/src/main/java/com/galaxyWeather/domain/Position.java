package com.galaxyWeather.domain;

import com.galaxyWeather.utils.MathUtils;

public class Position {
	double x;
	double y;
	
	/*
	 * The positions are rounded up to five decimals.
	 */
	public Position(double x, double y) {
		this.x = MathUtils.round(x);
		this.y = MathUtils.round(y);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
			
}
