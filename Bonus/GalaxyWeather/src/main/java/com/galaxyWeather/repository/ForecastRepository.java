package com.galaxyWeather.repository;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.galaxyWeather.domain.Forecast;

@RepositoryRestResource
public interface ForecastRepository extends JpaRepository<Forecast, Integer>{
	
	public List<Forecast> findAll();
	
	public List<Forecast> findByWeather(ForecastType Weather);
	
	public Forecast findByDay(int day);
}
