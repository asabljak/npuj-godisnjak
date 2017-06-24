package hr.tvz.java.godisnjak.web;
import hr.tvz.java.godisnjak.entity.ApplicationUserType;
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

@RequestMapping("/applicationusertypes")
@Controller
public class ApplicationUserTypeController {
	
	@Autowired
	ApplicationUserTypeRepository repository;
	
	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid ApplicationUserType applicationUserType, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, applicationUserType);
            return "applicationusertypes/create";
        }
        uiModel.asMap().clear();
        repository.save(applicationUserType);
        return "redirect:/applicationusertypes/" + encodeUrlPathSegment(applicationUserType.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new ApplicationUserType());
        return "applicationusertypes/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("applicationusertype", repository.findOne(id));
        uiModel.addAttribute("itemId", id);
        return "applicationusertypes/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
    	
        uiModel.addAttribute("applicationusertypes", repository.findAllByOrderByNameAsc());

        return "applicationusertypes/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid ApplicationUserType applicationUserType, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, applicationUserType);
            return "applicationusertypes/update";
        }
        uiModel.asMap().clear();
        repository.save(applicationUserType);
        return "redirect:/applicationusertypes/" + encodeUrlPathSegment(applicationUserType.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, repository.findOne(id));
        return "applicationusertypes/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        repository.delete(id);
    	uiModel.asMap().clear();
        return "redirect:/applicationusertypes";
    }
    
    void populateEditForm(Model uiModel, ApplicationUserType applicationUserType) {
        uiModel.addAttribute("applicationUserType", applicationUserType);
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
