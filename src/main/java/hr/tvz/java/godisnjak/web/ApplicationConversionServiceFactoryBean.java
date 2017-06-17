package hr.tvz.java.godisnjak.web;

import java.util.Set;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;

/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	public void setFormatterRegistrars(Set<FormatterRegistrar> formatterRegistrars) {
		// TODO Auto-generated method stub
		super.setFormatterRegistrars(formatterRegistrars);
	}
}
