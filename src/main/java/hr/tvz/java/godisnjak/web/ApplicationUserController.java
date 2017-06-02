package hr.tvz.java.godisnjak.web;
import hr.tvz.java.godisnjak.entity.ApplicationUser;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/applicationusers")
@Controller
@RooWebScaffold(path = "applicationusers", formBackingObject = ApplicationUser.class)
public class ApplicationUserController {
}
