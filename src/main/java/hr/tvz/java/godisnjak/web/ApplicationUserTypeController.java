package hr.tvz.java.godisnjak.web;
import hr.tvz.java.godisnjak.entity.ApplicationUserType;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/applicationusertypes")
@Controller
@RooWebScaffold(path = "applicationusertypes", formBackingObject = ApplicationUserType.class)
public class ApplicationUserTypeController {
}
