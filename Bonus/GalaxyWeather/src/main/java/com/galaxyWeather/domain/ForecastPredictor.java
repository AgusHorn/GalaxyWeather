package com.galaxyWeather.domain;

import com.galaxyWeather.repository.ForecastType;
import com.galaxyWeather.utils.MathUtils;
import com.galaxyWeather.utils.Utils;

public class ForecastPredictor {
	
	private Planet ferengi;
	private Planet betasoide;
	private Planet vulcano;
	private double maxPerimeter;

	public ForecastPredictor(Planet ferengi, Planet betasoide, Planet vulcano) {
		this.ferengi = ferengi;
		this.betasoide = betasoide;
		this.vulcano = vulcano;
	}

	/*
	 * Generates the Forecasts.
	 */
	public Forecast getForecast(int day) {
		Forecast forecast = new Forecast();
		
		Position posOne = ferengi.getPosition(day);
		Position posTwo = betasoide.getPosition(day);
		Position posThree = vulcano.getPosition(day);
		
		forecast.setDay(day);
		if (Utils.arePlanetsInLineWithSun(ferengi, betasoide, vulcano, day)) {
			forecast.setWeather(ForecastType.DROUGHT);
		} else if (Utils.arePlanetsInLine(ferengi, betasoide, vulcano, day)) {
			forecast.setWeather(ForecastType.OPTIMUM_TEMP_AND_PRESSURE);
		} else if (Utils.isSunInTriangle(ferengi.getPosition(day), betasoide.getPosition(day), vulcano.getPosition(day))) {
			forecast.setWeather(ForecastType.RAINY);
			double perimeter = MathUtils.getTrianglePerimeter(posOne, posTwo, posThree);
			forecast.setTrianglePerimeter(perimeter);
			this.isMaxPerimeter(perimeter);
		} else {
			forecast.setWeather(ForecastType.UNKNOWN);
		}
		return forecast;
	}
	
	public double getMaxPerimeter() {
		return this.maxPerimeter;
	}

	private void isMaxPerimeter(double perimeter) {
		if (perimeter >= this.maxPerimeter) {
			this.maxPerimeter = perimeter;
		}
	}

}
