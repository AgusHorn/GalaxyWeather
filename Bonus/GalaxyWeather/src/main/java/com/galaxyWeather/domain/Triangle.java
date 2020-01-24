package com.galaxyWeather.domain;

public class Triangle {
	
	private Position posOne;
	private Position posTwo;
	private Position posThree;	
	
	public Triangle(Position posOne, Position posTwo, Position posThree) {
		this.posOne = posOne;
		this.posTwo = posTwo;
		this.posThree = posThree;
	}
		
	public double getArea() {
		double xOne = this.posOne.getX();
		double yOne = this.posOne.getY();
		double xTwo = this.posTwo.getX();
		double yTwo = this.posTwo.getY();
		double xThree = this.posThree.getX();
		double yThree = this.posThree.getY();
		
		return Math.abs((xOne*(yTwo - yThree) + xTwo*(yThree - yOne) + xThree*(yOne - yTwo))/2.0);
	}
	
	/*
	 * To know if a point is inside the triangle, you need to create three triangles replacing the 
	 * point in the three vertices of the triangle, one per triangle. If the area of these triangles is
	 * same as the original, then the point belongs or is inside the triangle.
	 */
	public boolean isPointInside(Position pos) {
		Triangle firstTriangle = new Triangle(pos, this.posTwo, this.posThree);
		Triangle secondTriangle = new Triangle(this.posOne, pos, this.posThree);
		Triangle thirdTriangle = new Triangle(this.posOne, this.posTwo, pos);
		
		return (this.getArea() == (firstTriangle.getArea() + secondTriangle.getArea() + thirdTriangle.getArea()));
	}
	
	

}
