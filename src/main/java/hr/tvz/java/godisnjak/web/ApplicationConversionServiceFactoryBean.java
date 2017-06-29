package hr.tvz.java.godisnjak.web;

import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;

import hr.tvz.java.godisnjak.entity.AcademicYear;
import hr.tvz.java.godisnjak.entity.ApplicationUser;
import hr.tvz.java.godisnjak.entity.ApplicationUserType;
import hr.tvz.java.godisnjak.entity.City;
import hr.tvz.java.godisnjak.entity.Course;
import hr.tvz.java.godisnjak.entity.Place;
import hr.tvz.java.godisnjak.entity.Student;

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
	
	public Converter<ApplicationUser, String> getApplicationUserToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<hr.tvz.java.godisnjak.entity.ApplicationUser, java.lang.String>() {
            public String convert(ApplicationUser applicationUser) {
                return new StringBuilder().append(applicationUser.getUsername()).append(' ').append(applicationUser.getPassword()).toString();
            }
        };
    }
    
    public Converter<String, ApplicationUser> getStringToApplicationUserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, hr.tvz.java.godisnjak.entity.ApplicationUser>() {
            public hr.tvz.java.godisnjak.entity.ApplicationUser convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ApplicationUser.class);
            }
        };
    }
    
    public Converter<ApplicationUserType, String> getApplicationUserTypeToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<hr.tvz.java.godisnjak.entity.ApplicationUserType, java.lang.String>() {
            public String convert(ApplicationUserType applicationUserType) {
                return new StringBuilder().append(applicationUserType.getName()).append(' ').append(applicationUserType.getDescription()).toString();
            }
        };
    }
    
    public Converter<String, ApplicationUserType> getStringToApplicationUserTypeConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, hr.tvz.java.godisnjak.entity.ApplicationUserType>() {
            public hr.tvz.java.godisnjak.entity.ApplicationUserType convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ApplicationUserType.class);
            }
        };
    }
    
    public Converter<String, City> getStringToCity() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, hr.tvz.java.godisnjak.entity.City>() {
            public hr.tvz.java.godisnjak.entity.City convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), City.class);
            }
        };
    }

    
    public Converter<AcademicYear, String> getAcademicYearToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<hr.tvz.java.godisnjak.entity.AcademicYear, java.lang.String>() {
            public String convert(AcademicYear academicYear) {
                return new StringBuilder().append(academicYear.getName()).toString();
            }
        };
    }

    public Converter<String, AcademicYear> getStringToAcademicYear() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, hr.tvz.java.godisnjak.entity.AcademicYear>() {
            public hr.tvz.java.godisnjak.entity.AcademicYear convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), AcademicYear.class);
            }
        };
    }

    
    public Converter<City, String> getCityToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<hr.tvz.java.godisnjak.entity.City, java.lang.String>() {
            public String convert(City city) {
                return new StringBuilder().append(city.getName()).toString();
            }
        };
    }

    
    public Converter<Course, String> getCourseToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<hr.tvz.java.godisnjak.entity.Course, java.lang.String>() {
            public String convert(Course course) {
                return new StringBuilder().append(course.getName()).append(' ').append(course.getDescription()).toString();
            }
        };
    }
    
    public Converter<String, Course> getStringToCourseConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, hr.tvz.java.godisnjak.entity.Course>() {
            public hr.tvz.java.godisnjak.entity.Course convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Course.class);
            }
        };
    }
    
    public Converter<Place, String> getPlaceToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<hr.tvz.java.godisnjak.entity.Place, java.lang.String>() {
            public String convert(Place place) {
                return new StringBuilder().append(place.getName()).append(' ').append(place.getPostalCode()).toString();
            }
        };
    }
    
    public Converter<String, Place> getStringToPlaceConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, hr.tvz.java.godisnjak.entity.Place>() {
            public hr.tvz.java.godisnjak.entity.Place convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Place.class);
            }
        };
    }
    
    public Converter<Student, String> getStudentToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<hr.tvz.java.godisnjak.entity.Student, java.lang.String>() {
            public String convert(Student student) {
                return new StringBuilder().append(student.getJmbag()).append(' ').append(student.getName()).append(' ').append(student.getSurname()).append(' ').append(student.getEmail()).toString();
            }
        };
    }
    
    public Converter<String, Student> getStringToStudentConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, hr.tvz.java.godisnjak.entity.Student>() {
            public hr.tvz.java.godisnjak.entity.Student convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Student.class);
            }
        };
    }
    
    public void installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getApplicationUserToStringConverter());
        registry.addConverter(getStringToApplicationUserConverter());
        registry.addConverter(getApplicationUserTypeToStringConverter());
        registry.addConverter(getStringToApplicationUserTypeConverter());
        registry.addConverter(getCourseToStringConverter());
        registry.addConverter(getStringToCourseConverter());
        registry.addConverter(getPlaceToStringConverter());
        registry.addConverter(getStringToPlaceConverter());
        registry.addConverter(getStudentToStringConverter());
        registry.addConverter(getStringToStudentConverter());
        registry.addConverter(getCityToStringConverter());
        registry.addConverter(getStringToCity());
        registry.addConverter(getAcademicYearToStringConverter());
        registry.addConverter(getStringToAcademicYear());
    }
    
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
}
