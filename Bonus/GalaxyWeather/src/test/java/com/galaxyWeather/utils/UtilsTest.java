package com.galaxyWeather.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.galaxyWeather.domain.*;
import com.galaxyWeather.utils.*;

class UtilsTest {

	@Test
	void testPlanetsInLineWithSun() {
		Planet ferengi = new Planet("Ferengi", 500, 1);
		Planet betasoide = new Planet("Betasoide", 2000, 3);
		Planet vulcano = new Planet("Vulcano", 1000, -5);
		
		assertEquals(true,Utils.arePlanetsInLineWithSun(ferengi, betasoide,vulcano,0));
		assertEquals(true,Utils.arePlanetsInLineWithSun(ferengi, betasoide,vulcano,90));	
	}

	@Test
	void testPlanetsInLine() {
		Planet ferengi = new Planet("Ferengi", 500, 1);
		Planet betasoide = new Planet("Betasoide", 2000, 3);
		Planet vulcano = new Planet("Vulcano", 1000, -5);
		
		assertEquals(true,Utils.arePlanetsInLine(ferengi, betasoide,vulcano,180));
		assertEquals(true,Utils.arePlanetsInLine(ferengi, betasoide,vulcano,270));	
	}
	
	@Test
	void testIsSunInTriangle() {
		Planet ferengi = new Planet("Ferengi", 500, 1);
		Planet betasoide = new Planet("Betasoide", 2000, 3);
		Planet vulcano = new Planet("Vulcano", 1000, -5);
				
		assertEquals(true,Utils.isSunInTriangle(ferengi.getPosition(25), betasoide.getPosition(25), vulcano.getPosition(25)));
		assertEquals(true,Utils.isSunInTriangle(ferengi.getPosition(30), betasoide.getPosition(30), vulcano.getPosition(30)));	
	}
}
