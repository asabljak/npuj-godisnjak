package hr.tvz.java.godisnjak.entity.repository;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import hr.tvz.java.godisnjak.entity.ApplicationUserType;

@ContextConfiguration(locations = {"file:src/main/resources/META-INF/spring/applicationContext.xml"} )
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationUserTypeRepositoryTest {

	@Autowired
	ApplicationUserTypeRepository repository;
	
	@Test
	public void testfindAll(){
		List<ApplicationUserType> applicationUserTypes = 
				repository.findAllByOrderByNameAsc();
			assertNotNull(applicationUserTypes);
		
	}
	
	
}
