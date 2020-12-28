package com.jrp.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greeting")
public class HelloController {
	
	@RequestMapping(value = "/basic", method = RequestMethod.GET)
	public String sayHello() {
		return "<h1>hello</h1>";
	}
	
	@RequestMapping("/proper")		//default is Get Action
	public String sayProperHello() {
		return "<h1>Hello there how are you?</h1>";
	}
	
	@RequestMapping(value = "/user-entry")
	public String userForm() {
		return "<form action=\"/greeting/user-greeting\" method=\"POST\">\r\n"
				+ "  <label for=\"fname\">First name:</label><br>\r\n"
				+ "  <input type=\"text\" id=\"fname\" name=\"fname\"><br>\r\n"
				+ "  <label for=\"lname\">Last name:</label><br>\r\n"
				+ "  <input type=\"text\" id=\"lname\" name=\"lname\"><br><br>\r\n"
				+ "  <input type=\"submit\" value=\"Submit\">\r\n"
				+ "</form> ";
	}
	
	@RequestMapping(value = "/user-greeting", method = RequestMethod.POST)
	public String userGreeting(@RequestParam String fname, @RequestParam String lname) {
		return "<h1>Hello "+fname+" "+lname+" how are you?</h1>";
	}
	
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public String getOrder(@PathVariable String id) {
		return "Order Id "+id;
	}

}
