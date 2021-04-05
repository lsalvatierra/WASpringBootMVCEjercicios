package edu.pe.idat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.pe.idat.model.LoginForm;

@Controller
public class LoginController {

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("loginform", new LoginForm());
		modelView.addObject("visualizar", false);
		return modelView;
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("loginform") LoginForm loginform, 
			Model model) {
		if(loginform.getUsuario().equals("d18159") 
				&& loginform.getPassword().equals("123456")) {
			model.addAttribute("mensaje", "Bienvenido "+loginform.getUsuario());
			model.addAttribute("titulo", "Home");
			return "home";
		}
		model.addAttribute("visualizar", true);
		model.addAttribute("mensajeerror", "Usuario o password incorrecto.");
		return "login";
	}	
}
