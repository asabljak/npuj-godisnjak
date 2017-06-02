package hr.tvz.java.godisnjak.entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Student {

    /**
     */
    @NotNull
    @Size(max = 11)
    private String jmbag;

    /**
     */
    @NotNull
    private String name;

    /**
     */
    @NotNull
    private String surname;

    /**
     */
    @NotNull
    private String email;

    /**
     */
    private String address;

    /**
     */
    @ManyToOne
    private Place place;
    
    @ManyToMany
    private List<Course> courses;
}
