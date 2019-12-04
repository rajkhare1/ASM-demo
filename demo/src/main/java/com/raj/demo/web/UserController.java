package com.raj.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raj.demo.domain.Product;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/{userId}")
	public String displayUser(@PathVariable int userId) {
		return "User Found: " + userId;
	}

	@RequestMapping("/{id}/invoices")
	public String displayUserInvoices(@PathVariable(value="id") int userId, 
			@RequestParam(value="date",required = false) Date dateOrNull) {
		return "invoice found for the user: " + userId + " on the date: " + dateOrNull;
	}
	
	@RequestMapping("/{userId}/items")
	public List<String> displayStringJson(){
		return Arrays.asList("shoes","laptop","button");
	}
	
	@RequestMapping("/{userId}/products_as_json")
	public Product displayProductsJson(){
		return new Product(1, "shoes", 42.99);
	}
}
