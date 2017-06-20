package hr.tvz.java.godisnjak.web;
import hr.tvz.java.godisnjak.entity.Student;
import hr.tvz.java.godisnjak.entity.repository.CourseRepository;
import hr.tvz.java.godisnjak.entity.repository.PlaceRepository;
import hr.tvz.java.godisnjak.entity.repository.StudentRepository;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

@RequestMapping("/students")
@Controller
public class StudentController {
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	PlaceRepository placeRepository;
	
	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Student student, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, student);
            return "students/create";
        }
        uiModel.asMap().clear();
        repository.save(student);
        return "redirect:/students/" + encodeUrlPathSegment(student.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Student());
        return "students/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("student", repository.findOne(id));
        uiModel.addAttribute("itemId", id);
        return "students/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
    	uiModel.addAttribute("students", repository.findAllByOrderByNameAsc());
        return "students/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Student student, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, student);
            return "students/update";
        }
        uiModel.asMap().clear();
        repository.save(student);
        return "redirect:/students/" + encodeUrlPathSegment(student.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, repository.findOne(id));
        return "students/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        repository.delete(id);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/students";
    }
    
    void populateEditForm(Model uiModel, Student student) {
        uiModel.addAttribute("student", student);
        uiModel.addAttribute("courses", courseRepository.findAllByOrderByNameAsc());
        uiModel.addAttribute("places", placeRepository.findAllByOrderByNameAsc());
    }
    
    String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
}
}
