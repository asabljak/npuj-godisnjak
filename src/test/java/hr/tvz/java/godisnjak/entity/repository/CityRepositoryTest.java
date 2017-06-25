package hr.tvz.java.godisnjak.entity.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hr.tvz.java.godisnjak.entity.AcademicYear;
import hr.tvz.java.godisnjak.entity.City;
import hr.tvz.java.godisnjak.entity.Course;
import hr.tvz.java.godisnjak.entity.Place;
import hr.tvz.java.godisnjak.entity.Student;
import hr.tvz.java.godisnjak.entity.repository.CityRepository;
import hr.tvz.java.godisnjak.entity.repository.StudentRepository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.After;
import org.junit.Before;
import org.springframework.test.context.junit4.SpringRunner;


@ContextConfiguration(locations = { "file:src/main/resources/META-INF/spring/applicationContext.xml" })
@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CityRepositoryTest {

	@Autowired
	CityRepository repository;

	private SessionFactory sessionFactory;
	private Session session= null;
	
	@SuppressWarnings("deprecation")
	@Before
	public void before() {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(City.class);
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false");
		configuration.setProperty("hibernate.hbm2ddl.auto", "create");
		sessionFactory = configuration.buildSessionFactory();
		session= sessionFactory.openSession();	
	}
	
//	@Test
//	public void testCreate() {
//		City city = new City();
//		
//		city.setId(1L);
//		city.setName("Zagreb");
//		city.setVersion(1);	
//		//session.save(city);
//		repository.save(city);
//		
////		city.setId(2L);
////		city.setName("Sisak");
////		city.setVersion(1);
//		//session.save(city);
//		
//	}
	
	@Test
	public void testFindAll() {
		List<City> cities;
		cities = repository.findAllByOrderByNameAsc();
		assertNotNull(cities);
	}
	
	@Test
	public void testFindById() {
		City grad1 = repository.getOne(1L);
		assertNotNull(grad1);
	}
	
	@After
	public void after() {
		session.close();
		sessionFactory.close();
	}
	
	
}
