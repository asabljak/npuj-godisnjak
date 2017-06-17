package hr.tvz.java.godisnjak.web.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.java.godisnjak.entity.City;

@RestController
@RequestMapping("/api/citys")
public class CityRestController {
	
	@GetMapping
	public List<City> getAll() {
		return City.findAllCitys();
	}
	
	@GetMapping(value="/{id}")
	public City getById(@PathVariable("id") Long id) {
		return City.findCity(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody City city) {
		city.persist();
	}
	
	@PutMapping
	public City update(@RequestBody City city) {
		return city.merge();
	}

}
