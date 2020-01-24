package com.galaxyWeather.utils;

import com.galaxyWeather.domain.Position;

public class MathUtils {
	
	public static double getTrianglePerimeter(Position posOne, Position posTwo, Position posThree) {
		double latterOne = MathUtils.getEuclideanDistance(posOne, posTwo);
		double latterTwo = MathUtils.getEuclideanDistance(posOne, posThree);
		double latterThree = MathUtils.getEuclideanDistance(posThree, posTwo);
		
		return latterOne + latterTwo + latterThree;
	}
	
	public static double round(double value) {
	    long factor = (long) Math.pow(10, 5);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	private static double getEuclideanDistance(Position posOne, Position posTwo) {
		double y = Math.abs(posOne.getY() - posTwo.getY());
		double x = Math.abs(posOne.getX() - posTwo.getX());
		double distance = Math.sqrt((y*y) + (x*x));
		return round(distance);
	}

}
