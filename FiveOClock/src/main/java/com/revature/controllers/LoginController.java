package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
		
		return "Login"; //return Login/failure
	}
}
