package hr.tvz.java.godisnjak.web;
import hr.tvz.java.godisnjak.entity.AcademicYear;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/academicyears")
@Controller
@RooWebScaffold(path = "academicyears", formBackingObject = AcademicYear.class)
public class AcademicYearController {
}
