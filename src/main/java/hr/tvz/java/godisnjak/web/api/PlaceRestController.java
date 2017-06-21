package hr.tvz.java.godisnjak.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.java.godisnjak.entity.Place;
import hr.tvz.java.godisnjak.entity.repository.PlaceRepository;

@RestController
@RequestMapping("/api/places")
@Secured("ROLE_ADMIN")
public class PlaceRestController {

	@Autowired
	PlaceRepository repository;
	
	@GetMapping
	public List<Place> getAll() {		
		return repository.findAllByOrderByNameAsc();
	}
	
	@GetMapping(value="/{id}")
	public Place getById(@PathVariable("id") Long id) {
		return repository.findOne(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Place create(@RequestBody Place place) {
		return repository.save(place);
	}
	
	@PutMapping
	public Place update(@RequestBody Place place) {
		return repository.save(place);
	}
	
	 @DeleteMapping( value = "/{id}")
	 @ResponseStatus( HttpStatus.OK )
	 public void delete( @PathVariable( "id" ) Long id ){
	    repository.delete(id);
	 }
	
}
