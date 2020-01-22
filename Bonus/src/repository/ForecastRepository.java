package repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import model.Forecast;


public interface ForecastRepository extends PagingAndSortingRepository<Forecast, Long>{
	
	public List<Forecast> findAll();
	
	public List<Forecast> findByWeather(ForecastType Weather);
	
	public List<Forecast> findByRainyAndOrderByPerimeter();
	
	public Forecast findByDay(int day);
}
