package hr.tvz.java.godisnjak.java.web;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hr.tvz.java.godisnjak.entity.repository.CityRepository;

@Configuration
public class ContextConfig {
	
	@Bean
	public CityRepository cityRepository() {
		return Mockito.mock(CityRepository.class);
	}

}
