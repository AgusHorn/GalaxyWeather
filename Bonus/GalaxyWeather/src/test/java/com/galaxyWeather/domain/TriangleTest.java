package com.galaxyWeather.domain;

import static org.junit.jupiter.api.Assertions.*;
import com.galaxyWeather.domain.*;
import org.junit.jupiter.api.Test;

class TriangleTest {
	
	private Position posOne = new Position(0, 0);
	private Position posTwo = new Position(5, 0);
	private Position posThree = new Position(-5, -5);
	
	private Triangle triangle = new Triangle(this.posOne, this.posTwo, this.posThree);

	@Test
	void getAreaTest() {
		double expectedArea = 25/2.0;
		assertEquals(expectedArea, this.triangle.getArea());
	}
	
	@Test
	void pointInsideTriangleTest() {
		Position positionInside = new Position(-2, -3);
		assertEquals(true, this.triangle.isPointInside(positionInside));
	}
	
	@Test
	void pointOutsideTriangleTest() {
		Position positionInside = new Position(10, 10);
		assertEquals(false, this.triangle.isPointInside(positionInside));
	}

}
