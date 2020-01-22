package model;

import repository.ForecastType;
import utils.Utils;

public class ForecastPredictor {
	
	private Planet ferengi;
	private Planet betasoide;
	private Planet vulcano;

	public ForecastPredictor(Planet ferengi, Planet betasoide, Planet vulcano) {
		this.ferengi = ferengi;
		this.betasoide = betasoide;
		this.vulcano = vulcano;
	}

	public Forecast getForecast(int day) {
		Forecast forecast = new Forecast(day);
		if (Utils.arePlanetsInLineWithSun(ferengi, betasoide, vulcano, day)) {
			forecast.setWeather(ForecastType.DROUGHT);
		} else if (Utils.arePlanetsInLine(ferengi, betasoide, vulcano, day)) {
			forecast.setWeather(ForecastType.OPTIMUM_TEMP_AND_PRESSURE);
		} else if (Utils.isSunInTriangle(ferengi.getPosition(day), betasoide.getPosition(day), vulcano.getPosition(day))) {
			forecast.setWeather(ForecastType.RAINY);
			//forecast.setTrianglePerimeter(perimeter); //TODO TRIANGLE PERIMETER
		} else {
			forecast.setWeather(ForecastType.UNKNOWN);
		}
		return forecast;
	}

}
