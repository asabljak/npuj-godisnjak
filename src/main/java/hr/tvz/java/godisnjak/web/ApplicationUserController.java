package hr.tvz.java.godisnjak.web;
import hr.tvz.java.godisnjak.entity.ApplicationUser;
import hr.tvz.java.godisnjak.entity.ApplicationUserType;
import hr.tvz.java.godisnjak.entity.repository.ApplicationUserRepository;
import hr.tvz.java.godisnjak.entity.repository.ApplicationUserTypeRepository;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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

@RequestMapping("/applicationusers")
@Controller
public class ApplicationUserController {
	
	@Autowired
	ApplicationUserRepository repository;
	
	@Autowired
	ApplicationUserTypeRepository typeRepository;
	
	 @RequestMapping(method = RequestMethod.POST, produces = "text/html")
	    public String create(@Valid ApplicationUser applicationUser, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateEditForm(uiModel, applicationUser);
	            return "applicationusers/create";
	        }
	        uiModel.asMap().clear();
	        repository.save(applicationUser);
	        return "redirect:/applicationusers/" + encodeUrlPathSegment(applicationUser.getId().toString(), httpServletRequest);
	    }
	    
	    @RequestMapping(params = "form", produces = "text/html")
	    public String createForm(Model uiModel) {
	        populateEditForm(uiModel, new ApplicationUser());
	        return "applicationusers/create";
	    }
	    
	    @RequestMapping(value = "/{id}", produces = "text/html")
	    public String show(@PathVariable("id") Long id, Model uiModel) {
	        uiModel.addAttribute("applicationuser", repository.findOne(id));
	        uiModel.addAttribute("itemId", id);
	        return "applicationusers/show";
	    }
	    
	    @RequestMapping(produces = "text/html")
	    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
	        
	        uiModel.addAttribute(repository.findAllByOrderByUsernameAsc());
	        
	        return "applicationusers/list";
	    }
	    
	    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
	    public String update(@Valid ApplicationUser applicationUser, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateEditForm(uiModel, applicationUser);
	            return "applicationusers/update";
	        }
	        uiModel.asMap().clear();
	        repository.save(applicationUser);
	        return "redirect:/applicationusers/" + encodeUrlPathSegment(applicationUser.getId().toString(), httpServletRequest);
	    }
	    
	    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
	    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
	        populateEditForm(uiModel, repository.findOne(id));
	        return "applicationusers/update";
	    }
	    
	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	        repository.delete(id);
	        uiModel.asMap().clear();
	        return "redirect:/applicationusers";
	    }
	    
	    void populateEditForm(Model uiModel, ApplicationUser applicationUser) {
	    		        
	    	uiModel.addAttribute("applicationUser", applicationUser);
	        uiModel.addAttribute("applicationusertypes", typeRepository.findAllByOrderByNameAsc());
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
