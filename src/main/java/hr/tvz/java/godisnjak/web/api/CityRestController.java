package hr.tvz.java.godisnjak.web.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.java.godisnjak.entity.City;
import hr.tvz.java.godisnjak.entity.repository.CityRepository;

@RestController
@RequestMapping("/api/citys")
public class CityRestController {
	
	@Autowired
	CityRepository repository;

	@GetMapping
	public List<City> getAll() {
		return repository.findAllByOrderByNameAsc();
	}
	
	@GetMapping(value="/{id}")
	public City getById(@PathVariable("id") Long id) {
		return repository.findOne(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public City create(@RequestBody City city) {
		return repository.save(city);
	}
	
	@PutMapping
	public City update(@RequestBody City city) {
		return repository.save(city);
	}
	
	 @DeleteMapping( value = "/{id}")
	 @ResponseStatus( HttpStatus.OK )
	 public void delete( @PathVariable( "id" ) Long id ){
	    repository.delete(id);
	 }

}
