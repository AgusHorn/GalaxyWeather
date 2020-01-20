import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import repository.ForecastRepository;

@SpringBootApplication
public class GalaxyWeatherApplication {
	
	private static final Logger log = LoggerFactory.getLogger(GalaxyWeatherApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GalaxyWeatherApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(ForecastRepository repository) {
		return (args) -> {
			
		};
	}

}
