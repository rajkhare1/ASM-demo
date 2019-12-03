package com.raj.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HelloController {
	
	@RequestMapping("/basic")
	public String hello() {
		return "<h1 style='color:green;text-align:center;font-family:Helvetica;'>hello</h1>";
	}
	
	@RequestMapping("/proper")
	public String sayProperHello() {
		return "<h1 style='color:green;text-align:center;font-family:Helvetica;'>Hello there, how are you?</h1>";
	}
	
	@RequestMapping("/user_entry")
	public String userForm() {
		return "<form action=\"/greeting/user_greeting\" method=\"POST\">\r\n" + 
				"  First name:<br>\r\n" + 
				"  <input type=\"text\" name=\"firstname\">\r\n" + 
				"  <br>\r\n" + 
				"  Last name:<br>\r\n" + 
				"  <input type=\"text\" name=\"lastname\">\r\n" + 
				"  <br><br>\r\n" + 
				"  <input type=\"submit\" value=\"Submit\">\r\n" + 
				"</form> ";
	}
	
	@RequestMapping(value="/user_greeting", method= RequestMethod.POST)
	public String printUserGreeting(@RequestParam String firstname,@RequestParam String lastname) {
		return "<h1 style='color:green;text-align:center;font-family:Helvetica;'>Hello there, "+ firstname+" "+lastname+" </h1>";
	}
	
	@RequestMapping(value="/orders/{id}", method=RequestMethod.GET)
	public String getOrder(@PathVariable String id) {
		return "<h3 style='color:blue;text-align:left;font-family:Helvetica;'>Order Id: "+ id+" </h3>";
	}

}
