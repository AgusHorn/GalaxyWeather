package com.galaxyWeather.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.galaxyWeather.domain.Forecast;
import com.galaxyWeather.repository.ForecastRepository;

@SpringBootApplication
@EntityScan("com.galaxyWeather.domain")
@ComponentScan("com.galaxyWeather.controller")
@EnableJpaRepositories("com.galaxyWeather.repository")
public class GalaxyWeatherApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(GalaxyWeatherApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GalaxyWeatherApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(ForecastRepository repository) {
		return (args) -> {
			GalaxyWeatherJob galaxyService = new GalaxyWeatherJob();
			galaxyService.run(repository);
			//On console you can see the forecasts predictions per day.
			System.out.println("");
			repository.findAll().forEach((f)->{
				System.out.format("Día: %s , Clima: %s \n", f.getDay(), f.getWeather());			
			});
			
			this.logger.info("Forecast prediction was loaded.");
		};
	}

}
