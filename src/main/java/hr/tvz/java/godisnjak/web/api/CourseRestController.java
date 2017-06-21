package hr.tvz.java.godisnjak.web.api;

import java.util.ArrayList;
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

import hr.tvz.java.godisnjak.entity.Course;
import hr.tvz.java.godisnjak.entity.repository.CourseRepository;

@RestController
@RequestMapping("/api/courses")
@Secured("ROLE_ADMIN")
public class CourseRestController {
	
	@Autowired
	CourseRepository repository;
	
	@GetMapping
	public List<Course> getAll() {
		return repository.findAllByOrderByNameAsc();
	}
	
	@GetMapping(value="/{id}")
	public Course getById(@PathVariable("id") Long id) {
		return repository.findOne(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Course create(@RequestBody Course course) {
		return repository.save(course);
	}
	
	@PutMapping
	public Course update(@RequestBody Course course) {
		return repository.save(course);
	}
	
	 @DeleteMapping( value = "/{id}")
	 @ResponseStatus( HttpStatus.OK )
	 public void delete( @PathVariable( "id" ) Long id ){
	    repository.delete(id);
	 }
}
