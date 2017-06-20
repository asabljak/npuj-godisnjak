package hr.tvz.java.godisnjak.entity;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class AcademicYear {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
   
    @NotNull
    private String name;
    
    @Version
    @Column(name = "version")
    private Integer version;
    
    public AcademicYear() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
