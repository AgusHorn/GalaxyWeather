package model;

public class Position {
	double x;
	double y;
	double radians;
	
	public Position(double x, double y) {
		this.x = Utils.round(x);
		this.y = Utils.round(y);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
			
}
