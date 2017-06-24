package hr.tvz.java.godisnjak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath:/META-INF/spring/applicationContext.xml","classpath:/META-INF/spring/applicationContext-security.xml", "classpath:/META-INF/webmvc-config.xml"})
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class GodisnjakBootApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GodisnjakBootApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(GodisnjakBootApplication.class, args);
	}
}
