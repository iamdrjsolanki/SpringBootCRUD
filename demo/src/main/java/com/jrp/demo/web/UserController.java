package com.jrp.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jrp.demo.model.Product;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String displayUser(@PathVariable int userId) {
		return "User found: "+userId;
	}
	
	@RequestMapping(value = "/{userId}/invoices", method = RequestMethod.GET)
	public String userInvoices(@PathVariable int userId, @RequestParam(value="date", required=false) Date dateOrNull) {
		return "Invoice found for user "+userId+" of the date "+dateOrNull;
	}
	
	@RequestMapping(value = "/{userId}/items")
	public List<Product> userItems(@PathVariable int userId) {
		return Arrays.asList(new Product(1, "Shirts", 500), 
				new Product(1, "TShirts", 300), 
				new Product(1, "Jeans", 1200), 
				new Product(1, "Shoes", 1000)
			);
	}

}
