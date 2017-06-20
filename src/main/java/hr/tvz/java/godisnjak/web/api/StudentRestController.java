package hr.tvz.java.godisnjak.web.api;

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

import hr.tvz.java.godisnjak.entity.Student;
import hr.tvz.java.godisnjak.entity.repository.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

	@Autowired
	StudentRepository repository;
	
	@GetMapping
	public List<Student> getAll() {
		return repository.findAllByOrderByNameAsc();
	}
	
	@GetMapping(value="/{id}")
	public Student getById(@PathVariable("id") Long id) {
		return repository.findOne(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Student create(@RequestBody Student student) {
		return repository.save(student);
	}
	
	@PutMapping
	public Student update(@RequestBody Student student) {
		return repository.save(student);
	}
	
	 @DeleteMapping( value = "/{id}")
	 @ResponseStatus( HttpStatus.OK )
	 public void delete( @PathVariable( "id" ) Long id ){
	    repository.delete(id);
	 }
	
}
