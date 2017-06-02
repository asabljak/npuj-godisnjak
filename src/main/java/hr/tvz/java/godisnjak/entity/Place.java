package hr.tvz.java.godisnjak.entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Place {

    /**
     */
    @NotNull
    private String name;

    /**
     */
    private int postalCode;

    /**
     */
    @ManyToOne
    private City city;
}
