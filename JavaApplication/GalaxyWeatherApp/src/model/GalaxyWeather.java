package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import utils.Utils;

public class GalaxyWeather {
	
	private static int DAYS_IN_YEAR = 360;
	private static int YEARS_TO_PREDICT = 1;
	
	private List<String> forecasts;
	
	private static List<Forecast> getForecasts(Planet ferengi, Planet betasoide, Planet vulcano, ForecastPredictor predictor) {
		int totalDays = DAYS_IN_YEAR * YEARS_TO_PREDICT;
		List<Forecast> forecasts = new ArrayList();
		for(int i = 0; i < totalDays; i++) {
			forecasts.add(predictor.getForecast(i));
		}
		return forecasts;
	}
	
	private static void getDroughtDays(List<Forecast> forecasts) {
		System.out.println("");
		Predicate<Forecast> byDrought = forecast -> forecast.getWeather() == ForecastType.DROUGHT;
		List<Forecast> droughtDays = forecasts.stream()
							 		.filter(byDrought)
					  				.collect(Collectors.toList());
		System.out.println(droughtDays);
		System.out.println("");
	}
	
	private static void getOptimumConditionsDays(List<Forecast> forecasts) {
		System.out.println("");
		Predicate<Forecast> byOptimumCond = forecast -> forecast.getWeather() == ForecastType.OPTIMUM_TEMP_AND_PRESSURE;
		List<Forecast> optimumCondDays = forecasts.stream()
							 		.filter(byOptimumCond)
					  				.collect(Collectors.toList());
		System.out.println(optimumCondDays);
		System.out.println("");
	}
	
	private static void getRainyDays(List<Forecast> forecasts, ForecastPredictor predictor) {
		System.out.println("");
		Predicate<Forecast> byRainy = forecast -> forecast.getWeather() == ForecastType.RAINY;
		List<Forecast> rainyDays = forecasts.stream()
							 		.filter(byRainy)
					  				.collect(Collectors.toList());
		
		double maxPerimeter = predictor.getMaxPerimeter();
		for(Forecast forecast : rainyDays) {
			if (forecast.getPerimeter() == maxPerimeter) {
				forecast.setWeather(ForecastType.MAX_RAINY);
			}
		}
		System.out.println(rainyDays);
		System.out.println("");
		
	}
	
	public static void main(String args[]) {
		Planet ferengi = new Planet("Ferengi", 500, 1);
		Planet betasoide = new Planet("Betasoide", 2000, 3);
		Planet vulcano = new Planet("Vulcano", 1000, -5);
		ForecastPredictor predictor = new ForecastPredictor(ferengi, betasoide, vulcano);
		
		List<Forecast> forecasts = getForecasts(ferengi, betasoide, vulcano, predictor);
		System.out.println(forecasts);
		System.out.println("");
		getDroughtDays(forecasts);
		
		getRainyDays(forecasts, predictor);
		
		getOptimumConditionsDays(forecasts);		
	}
}
