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

import hr.tvz.java.godisnjak.entity.Place;

@RestController
@RequestMapping("/api/places")
public class PlaceRestController {

	@GetMapping
	public List<Place> getAll() {
		return Place.findAllPlaces();
	}
	
	@GetMapping(value="/{id}")
	public Place getById(@PathVariable("id") Long id) {
		return Place.findPlace(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Place place) {
		place.persist();
	}
	
	@PutMapping
	public Place update(@RequestBody Place place) {
		return place.merge();
	}
	
}
