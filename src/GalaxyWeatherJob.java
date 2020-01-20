import org.springframework.beans.factory.annotation.Autowired;

import model.ForecastPredictor;
import model.Planet;
import repository.ForecastRepository;

public class GalaxyWeatherJob {
	
	private Planet vulcano;
	private Planet ferengi;
	private Planet betasoide;
	
	@Autowired
	ForecastRepository repository;
	
	private int DAYS_IN_YEAR = 360;
	private int YEARS_TO_PREDICT = 10;
	
	public void init(ForecastRepository repository) {
		this.ferengi = new Planet("Ferengi", 500, 1);
		this.betasoide = new Planet("Betasoide", 2000, 3);
		this.vulcano = new Planet("Vulcano", 1000, -5);
		
		this.predictForecasts();
	}

	private void predictForecasts() {
		int totalDays = DAYS_IN_YEAR * YEARS_TO_PREDICT;
		ForecastPredictor predictor = new ForecastPredictor(this.ferengi, this.betasoide, this.vulcano);
		
		for(int i = 0; i < totalDays; i++) {
			repository.save(predictor.getForecast(i));
		}
	}
}
