package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;

@Controller
public class LoginController {
	@Autowired
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "Login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAttempt(@RequestParam("username") String userInput,@RequestParam("password") String passwordInput) {
		UserDaoImpl udi = new UserDaoImpl();
		int isValid = udi.checkLogin(userInput, passwordInput);
		switch (isValid) {
		case 0:
			System.out.println("loginAttempt method called, login unsuccessful");
			return "Login";// Login/incorrectPass
		case 1:
			System.out.println("loginAttempt method called, login successful");
			return "Home";// Home
		default:
			System.out.println("loginAttempt method called, login unsuccessful");
			return "Login"; // Login/unsuccessful}
		}
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchPage() {
		return "Search";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchForm(@RequestParam("input") String location, Model m) {
		m.addAttribute("location", location);
		return "Home";
	}
}