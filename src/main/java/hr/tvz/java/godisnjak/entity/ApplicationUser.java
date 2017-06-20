package hr.tvz.java.godisnjak.entity;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class ApplicationUser {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
     
    private String username;

    
    @NotNull
    private String password;
 
    @ManyToOne
    private ApplicationUserType userRole;

    private Boolean enabled;
    
    @Version
    @Column(name = "version")
    private Integer version;

	public ApplicationUser() {

    }
    
    public void setPassword(String password) {
		String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);   		
        this.password = sha256hex;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ApplicationUserType getUserRole() {
		return userRole;
	}

	public void setUserRole(ApplicationUserType userRole) {
		this.userRole = userRole;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}
    
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
    
}
