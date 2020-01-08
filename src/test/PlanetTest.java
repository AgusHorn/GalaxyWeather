package test;
import model.Position;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Planet;

class PlanetTest {
	
	private Planet ferengi = new Planet("Ferengi", 500, 1);
	private Planet betasoide = new Planet("Betasoide", 2000, 3);
	private Planet vulcano = new Planet("Vulcano", 1000, -5);

	@Test
	void getPlanetNameTest() {
		assertEquals("Ferengi", this.ferengi.getName());
		assertEquals("Betasoide", this.betasoide.getName());
		assertEquals("Vulcano", this.vulcano.getName());
	}
	
	@Test
	void getPlanetDistanceTest() {
		assertEquals(500, this.ferengi.getDistance());
		assertEquals(2000, this.betasoide.getDistance());
		assertEquals(1000, this.vulcano.getDistance());
	}
	
	@Test
	void getPlanetAngularVelocityTest() {
		assertEquals(1, this.ferengi.getAngularVelocity());
		assertEquals(3, this.betasoide.getAngularVelocity());
		assertEquals(-5, this.vulcano.getAngularVelocity());
	}
	
	@Test
	void getPlanetPositionInGradesTest() {
		assertEquals(0, this.ferengi.getPositionInGrades(0));
		assertEquals(0, this.betasoide.getPositionInGrades(0));
		assertEquals(0, this.vulcano.getPositionInGrades(0));
		
		assertEquals(45, this.ferengi.getPositionInGrades(45));
		assertEquals(45, this.betasoide.getPositionInGrades(15));
		assertEquals(-45, this.vulcano.getPositionInGrades(9));
	}
	
	@Test
	void getPlanetPositionTest() {
		Position ferengiOtherPos = new Position(0, 500);
		Position betasoideOtherPos = new Position(0, 2000);
		Position vulcanoOtherPos = new Position(0, 1000);
		
		Position ferengiPos = this.ferengi.getPosition(0);
		Position betasoidePos = this.betasoide.getPosition(0);
		Position vulcanoPos = this.vulcano.getPosition(0);
		
		assertEquals(ferengiOtherPos.getX(), ferengiPos.getX());
		assertEquals(ferengiOtherPos.getY(), ferengiPos.getY());
		assertEquals(betasoideOtherPos.getX(), betasoidePos.getX());
		assertEquals(betasoideOtherPos.getY(), betasoidePos.getY());
		assertEquals(vulcanoOtherPos.getX(), vulcanoPos.getX());
		assertEquals(vulcanoOtherPos.getY(), vulcanoPos.getY());
		
		ferengiOtherPos = new Position(500,0);
		betasoideOtherPos = new Position(2000,0);
		vulcanoOtherPos = new Position(-1000,0);
		
		ferengiPos = this.ferengi.getPosition(90);
		betasoidePos = this.betasoide.getPosition(30);
		vulcanoPos = this.vulcano.getPosition(18);
		
		assertEquals(ferengiOtherPos.getX(), ferengiPos.getX());
		assertEquals(ferengiOtherPos.getY(), Math.round(ferengiPos.getY()));
		assertEquals(betasoideOtherPos.getX(), betasoidePos.getX());
		assertEquals(betasoideOtherPos.getY(), Math.round(betasoidePos.getY()));
		assertEquals(vulcanoOtherPos.getX(), vulcanoPos.getX());
		assertEquals(vulcanoOtherPos.getY(), Math.round(vulcanoPos.getY()));
	}

}
