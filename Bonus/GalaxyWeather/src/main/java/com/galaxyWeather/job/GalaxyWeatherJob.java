package com.galaxyWeather.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.galaxyWeather.domain.Forecast;
import com.galaxyWeather.domain.ForecastPredictor;
import com.galaxyWeather.domain.Planet;
import com.galaxyWeather.repository.ForecastRepository;
import com.galaxyWeather.repository.ForecastType;

@Service("galaxyWeatherJob")
public class GalaxyWeatherJob {
	
	@Autowired
	ForecastRepository repository;
	
	private Planet vulcano;
	private Planet ferengi;
	private Planet betasoide;
		
	private int DAYS_IN_YEAR = 365;
	private int YEARS_TO_PREDICT = 10;
	
	/*
	 * This method is the one who creates all the data of the weather for each day
	 * and saves it inside the repository.
	 */
	public void run(ForecastRepository repository) {
		
		this.ferengi = new Planet("Ferengi", 500, 1);
		this.betasoide = new Planet("Betasoide", 2000, 3);
		this.vulcano = new Planet("Vulcano", 1000, -5);
		
		int totalDays = DAYS_IN_YEAR * YEARS_TO_PREDICT;
		ForecastPredictor predictor = new ForecastPredictor(this.ferengi, this.betasoide, this.vulcano);
		
		for(int i = 0; i < totalDays; i++) {
			repository.save(predictor.getForecast(i));
		}
		
		double maxPerimeterTriangle = predictor.getMaxPerimeter();
		
		this.checkMaximumRain(repository, maxPerimeterTriangle);
		return;
    }

	private void checkMaximumRain(ForecastRepository repository, double maxPerimeterTriangle) {
		List<Forecast> rainyDays = repository.findByWeather(ForecastType.RAINY);
		for (Forecast f: rainyDays) {
			double perimeter = f.getTrianglePerimieter();
			if (maxPerimeterTriangle == perimeter) {
				f.setWeather(ForecastType.MAXIMUM_RAINY);
				repository.save(f);
			}
		}
		return;
	}
}
