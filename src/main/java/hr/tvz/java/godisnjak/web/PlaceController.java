package hr.tvz.java.godisnjak.web;
import hr.tvz.java.godisnjak.entity.Place;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/places")
@Controller
@RooWebScaffold(path = "places", formBackingObject = Place.class)
public class PlaceController {
}
