package hr.tvz.java.godisnjak.entity.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import hr.tvz.java.godisnjak.entity.repository.StudentRepository;

import static org.junit.Assert.*;

@ContextConfiguration(locations = { "file:src/main/resources/META-INF/spring/applicationContext.xml" })
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

	@Autowired
	StudentRepository repository;

	@Test
	public void testFindAll() {
		assertNotNull(repository.findAllByOrderByNameAsc());
	}
	
	@Test
	public void testFindById() {
		assertNotNull(repository.findOne(12L));
	}
	
	
}
