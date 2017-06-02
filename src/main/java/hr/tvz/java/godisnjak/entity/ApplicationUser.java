package hr.tvz.java.godisnjak.entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ApplicationUser {

    /**
     */
    private String username;

    /**
     */
    @NotNull
    private String password;

    /**
     */
    @ManyToOne
    private ApplicationUserType userRole;

    /**
     */
    private Boolean enabled;
    
    public void setPassword(String password) {
		String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);   		
        this.password = sha256hex;
    }
}
