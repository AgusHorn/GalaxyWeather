package com.galaxyWeather.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxyWeather.domain.Forecast;
import com.galaxyWeather.repository.ForecastRepository;

import net.minidev.json.JSONObject;

@RestController
public class GalaxyWeatherController {
	
	@Autowired
	private ForecastRepository repository;
    
	
	/* Returns the weather of certain day number.
	 * @param: day number
	 */
    @RequestMapping(value = "/clima", method = RequestMethod.GET)
	public JSONObject getWeatherByDay(@RequestParam(value="dia")String day) {
		try{
           int dayNumber = Integer.valueOf(day).intValue();
           return repository.findByDay(dayNumber).getDayAndWeather();         
	    }catch (Exception e){
	       throw new RuntimeException("There is no valid forecast for that date or there was an internal error.");
	    }
	}
    
    /* 
	 * Returns the weather of all the days in 10 years.
	 */
    @RequestMapping(value ="/clima/allDays", method = RequestMethod.GET)
	public JSONObject getWeather() {
		try{
			JSONObject response = new JSONObject();
			List<Forecast> forecasts = repository.findAll();
			List<JSONObject> responses = new ArrayList();
			for (Forecast f : forecasts) {
				responses.add(f.getDayAndWeather());
			}
			response.appendField("", responses);
           return response;         
	    }catch (Exception e){
	       throw new RuntimeException("There was an internal error. Please reload the page or contact the administrator.");
	    }
	}
}