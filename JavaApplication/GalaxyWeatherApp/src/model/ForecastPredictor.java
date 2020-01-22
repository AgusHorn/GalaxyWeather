package model;

import utils.MathUtils;
import utils.Utils;

public class ForecastPredictor {
	
	private Planet ferengi;
	private Planet betasoide;
	private Planet vulcano;
	private double maxPerimeter = 0;

	public ForecastPredictor(Planet ferengi, Planet betasoide, Planet vulcano) {
		this.ferengi = ferengi;
		this.betasoide = betasoide;
		this.vulcano = vulcano;
	}

	/*
	 * Generates the Forecasts.
	 */
	public Forecast getForecast(int day) {
		Forecast forecast = new Forecast(day);
		
		Position posOne = ferengi.getPosition(day);
		Position posTwo = betasoide.getPosition(day);
		Position posThree = vulcano.getPosition(day);
						
		if (Utils.arePlanetsInLineWithSun(ferengi, betasoide, vulcano, day)) {
			forecast.setWeather(ForecastType.DROUGHT);
		} else if (Utils.arePlanetsInLine(ferengi, betasoide, vulcano, day)) {
			forecast.setWeather(ForecastType.OPTIMUM_TEMP_AND_PRESSURE);
		} else if (Utils.isSunInTriangle(posOne, posTwo, posThree)) {
			forecast.setWeather(ForecastType.RAINY);
			double perimeter = MathUtils.getTrianglePerimeter(posOne, posTwo, posThree);
			forecast.setPerimeter(perimeter);
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
