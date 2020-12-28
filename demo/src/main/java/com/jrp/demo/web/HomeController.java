package com.jrp.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jrp.demo.model.User;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("formData", new User());
		return "index";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String processFormData(User user, RedirectAttributes attr) {
		attr.addFlashAttribute("user", user);
		return "redirect:/display";
	}
	
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public String displayFormData(User user) {
		return "result";
	}
	
	@RequestMapping(value="/create1", method=RequestMethod.POST)
	public String processFormData1(User user, RedirectAttributes attr) {
		return "redirect:/display";
	}
	
	@RequestMapping(value="/display1", method=RequestMethod.GET)
	public String displayFormData1(User user) {
		return "result";
	}

}
