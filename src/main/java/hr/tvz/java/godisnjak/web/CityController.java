package hr.tvz.java.godisnjak.web;
import hr.tvz.java.godisnjak.entity.City;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/citys")
@Controller
@RooWebScaffold(path = "citys", formBackingObject = City.class)
public class CityController {
}
