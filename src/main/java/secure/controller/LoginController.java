package secure.controller;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import secure.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import secure.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	private UserService userService;

	@Autowired(required=true)
	@Qualifier(value="userService")

	public void setUserService(UserService ps){
		this.userService = ps;
	}
 
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Authentication authentication) {

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String name = authentication.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Hello user");
		GrantedAuthority roleU  = new SimpleGrantedAuthority("ROLE_USER");
		GrantedAuthority roleT  = new SimpleGrantedAuthority("ROLE_T");
		GrantedAuthority roleS  = new SimpleGrantedAuthority("ROLE_S");
		GrantedAuthority roleA  = new SimpleGrantedAuthority("ROLE_A");
		if(userDetails.getAuthorities().contains(roleU)){
			return "hello";
		}else if(userDetails.getAuthorities().contains(roleT)){
			return "helloT";
		}else if(userDetails.getAuthorities().contains(roleA)){
			return "helloA";
		}else if(userDetails.getAuthorities().contains(roleS)){
			model.addAttribute("user", new User());
			model.addAttribute("listUser", this.userService.listUser());
			return "helloS";
		}

		return "login";
	}


	@RequestMapping(value= "/update", method = RequestMethod.POST)
	public String updatePerson(ModelMap model, HttpServletRequest request, @ModelAttribute("user") User user){
		if (request.getParameter("add") != null) {
			this.userService.addUser(user);
		} else if (request.getParameter("delete") != null) {
			this.userService.removeUser(user);
		}


		model.addAttribute("listUser", this.userService.listUser());
		return "helloS";

	}
//	@RequestMapping("/remove/{id}")
//	public String removePerson(@PathVariable("id") int id){
//
//		this.personService.removePerson(id);
//		return "redirect:/persons";
//	}


	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
 
		return "login";
 
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout() {
 
		return "login";
 
	}
	@RequestMapping(value="/*", method = RequestMethod.GET)
	public String home() {
 
		return "home";
 
	}
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String hello() {

		return "hello";
	}
	@RequestMapping(value="/helloA", method = RequestMethod.GET)
	public String helloA() {

		return "helloA";
	}
	@RequestMapping(value="/helloT", method = RequestMethod.GET)
	public String helloT() {

		return "helloT";
	}


}