package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String loginPage() {
		return "Login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST) 
	public String loginAttempt() {
		//int isValid = UserDaoImpl.checkCredentials(userInput, passwordInput);
		//switch(isValid){
		//case 0:
		//return Login/incorrectPass
		//case 1: 
		//return Home
		//default:
		//return Login/unsuccessful}
		
		return "Home"; //return Login/failure
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String searchPage() {
		return "Search";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchForm(@RequestParam("input") String location, Model m) {
		m.addAttribute("location",location);
		return "Home";
	}
}
