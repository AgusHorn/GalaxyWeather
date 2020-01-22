package model;

import utils.MathUtils;

public class Position {
	double x;
	double y;
	double radians;
	
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
