package hr.tvz.java.godisnjak.web;
import hr.tvz.java.godisnjak.entity.Course;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/courses")
@Controller
@RooWebScaffold(path = "courses", formBackingObject = Course.class)
public class CourseController {
}
