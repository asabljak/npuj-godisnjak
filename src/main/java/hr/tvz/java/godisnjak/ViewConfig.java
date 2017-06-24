//package hr.tvz.java.godisnjak;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//@Configuration
//@ComponentScan
//@EnableWebMvc
//public class ViewConfig extends WebMvcConfigurerAdapter {
//  
//	@Bean
//    public InternalResourceViewResolver resolver() {
//        InternalResourceViewResolver vr = new InternalResourceViewResolver();
//        vr.setPrefix("/WEB-INF/views/");
////        vr.setPrefix("/");
//        vr.setSuffix(".jsp");
//        return vr;
//    }
//	
//	@Override
//    public void configureDefaultServletHandling(
//        DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//}