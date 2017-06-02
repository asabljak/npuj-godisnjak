// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package hr.tvz.java.godisnjak.web;

import hr.tvz.java.godisnjak.entity.ApplicationUser;
import hr.tvz.java.godisnjak.entity.ApplicationUserType;
import hr.tvz.java.godisnjak.web.ApplicationConversionServiceFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    public Converter<ApplicationUser, String> ApplicationConversionServiceFactoryBean.getApplicationUserToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<hr.tvz.java.godisnjak.entity.ApplicationUser, java.lang.String>() {
            public String convert(ApplicationUser applicationUser) {
                return new StringBuilder().append(applicationUser.getUsername()).append(' ').append(applicationUser.getPassword()).toString();
            }
        };
    }
    
    public Converter<Long, ApplicationUser> ApplicationConversionServiceFactoryBean.getIdToApplicationUserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, hr.tvz.java.godisnjak.entity.ApplicationUser>() {
            public hr.tvz.java.godisnjak.entity.ApplicationUser convert(java.lang.Long id) {
                return ApplicationUser.findApplicationUser(id);
            }
        };
    }
    
    public Converter<String, ApplicationUser> ApplicationConversionServiceFactoryBean.getStringToApplicationUserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, hr.tvz.java.godisnjak.entity.ApplicationUser>() {
            public hr.tvz.java.godisnjak.entity.ApplicationUser convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ApplicationUser.class);
            }
        };
    }
    
    public Converter<ApplicationUserType, String> ApplicationConversionServiceFactoryBean.getApplicationUserTypeToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<hr.tvz.java.godisnjak.entity.ApplicationUserType, java.lang.String>() {
            public String convert(ApplicationUserType applicationUserType) {
                return new StringBuilder().append(applicationUserType.getName()).append(' ').append(applicationUserType.getDescription()).toString();
            }
        };
    }
    
    public Converter<Long, ApplicationUserType> ApplicationConversionServiceFactoryBean.getIdToApplicationUserTypeConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, hr.tvz.java.godisnjak.entity.ApplicationUserType>() {
            public hr.tvz.java.godisnjak.entity.ApplicationUserType convert(java.lang.Long id) {
                return ApplicationUserType.findApplicationUserType(id);
            }
        };
    }
    
    public Converter<String, ApplicationUserType> ApplicationConversionServiceFactoryBean.getStringToApplicationUserTypeConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, hr.tvz.java.godisnjak.entity.ApplicationUserType>() {
            public hr.tvz.java.godisnjak.entity.ApplicationUserType convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ApplicationUserType.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getApplicationUserToStringConverter());
        registry.addConverter(getIdToApplicationUserConverter());
        registry.addConverter(getStringToApplicationUserConverter());
        registry.addConverter(getApplicationUserTypeToStringConverter());
        registry.addConverter(getIdToApplicationUserTypeConverter());
        registry.addConverter(getStringToApplicationUserTypeConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
