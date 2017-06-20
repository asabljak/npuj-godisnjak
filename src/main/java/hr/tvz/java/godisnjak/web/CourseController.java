//package hr.tvz.java.godisnjak.web;
//import hr.tvz.java.godisnjak.entity.Course;
//import hr.tvz.java.godisnjak.entity.repository.AcademicYearRepository;
//import hr.tvz.java.godisnjak.entity.repository.CourseRepository;
//
//import java.io.UnsupportedEncodingException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.util.UriUtils;
//import org.springframework.web.util.WebUtils;
//
//@RequestMapping("/courses")
//@Controller
//public class CourseController {
//
//	@Autowired
//	CourseRepository repository;
//	
//	@Autowired
//	AcademicYearRepository academicYearRepository;
//	
//	 @RequestMapping(method = RequestMethod.POST, produces = "text/html")
//	    public String create(@Valid Course course, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
//	        if (bindingResult.hasErrors()) {
//	            populateEditForm(uiModel, course);
//	            return "courses/create";
//	        }
//	        uiModel.asMap().clear();
//	        repository.save(course);
//	        return "redirect:/courses/" + encodeUrlPathSegment(course.getId().toString(), httpServletRequest);
//	    }
//	    
//	    @RequestMapping(params = "form", produces = "text/html")
//	    public String createForm(Model uiModel) {
//	        populateEditForm(uiModel, new Course());
//	        return "courses/create";
//	    }
//	    
//	    @RequestMapping(value = "/{id}", produces = "text/html")
//	    public String show(@PathVariable("id") Long id, Model uiModel) {
//	        uiModel.addAttribute("course", repository.findOne(id));
//	        uiModel.addAttribute("itemId", id);
//	        return "courses/show";
//	    }
//	    
//	    @RequestMapping(produces = "text/html")
//	    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
//	    	uiModel.addAttribute("courses", repository.findAllByOrderByNameAsc());
//	        return "courses/list";
//	    }
//	    
//	    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
//	    public String update(@Valid Course course, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
//	        if (bindingResult.hasErrors()) {
//	            populateEditForm(uiModel, course);
//	            return "courses/update";
//	        }
//	        uiModel.asMap().clear();
//	        repository.save(course);
//	        return "redirect:/courses/" + encodeUrlPathSegment(course.getId().toString(), httpServletRequest);
//	    }
//	    
//	    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
//	    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
//	        populateEditForm(uiModel, repository.findOne(id));
//	        return "courses/update";
//	    }
//	    
//	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
//	    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
//	        repository.delete(id);
//	        uiModel.asMap().clear();
//	        return "redirect:/courses";
//	    }
//	    
//	    void populateEditForm(Model uiModel, Course course) {
//	        uiModel.addAttribute("course", course);
//	        uiModel.addAttribute("academicyears", academicYearRepository.findAllByOrderByNameAsc());
//	    }
//	    
//	    String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
//	        String enc = httpServletRequest.getCharacterEncoding();
//	        if (enc == null) {
//	            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
//	        }
//	        try {
//	            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
//	        } catch (UnsupportedEncodingException uee) {}
//	        return pathSegment;
//	}
//}
