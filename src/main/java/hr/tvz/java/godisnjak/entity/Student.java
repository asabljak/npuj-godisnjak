package hr.tvz.java.godisnjak.entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
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
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Course> courses;
    
    @Version
    @Column(name = "version")
    private Integer version;
    
    public Student() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJmbag() {
		return jmbag;
	}

	public void setJmbag(String jmbag) {
		this.jmbag = jmbag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
    
}
