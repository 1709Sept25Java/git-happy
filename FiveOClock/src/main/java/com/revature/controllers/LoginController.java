package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.dao.UserDaoImpl;


@Controller
public class LoginController {
	@Autowired
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "Login";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAttempt(@RequestParam("username") String userInput,@RequestParam("password") String passwordInput, HttpServletRequest req, Model m) {
		HttpSession session = req.getSession();
		/*userInput=req.getParameter("username");
		session.setAttribute("username", userInput);*/
	
		UserDaoImpl udi = new UserDaoImpl();
		int isValid = udi.checkLogin(userInput, passwordInput);
		String username;
		switch (isValid) {
		case 0:
			System.out.println("loginAttempt method called, login unsuccessful");
			m.addAttribute("message", "Incorrect credentials. Please try again.");
			return "Login";// Login/incorrectPass
		case 1: // is not an admin
			System.out.println("loginAttempt method called, login successful");
			username=req.getParameter("username");
			session.setAttribute("username", username);
			session.setAttribute("isAdmin", false);
			return "Search";// Home
		case 2: // is admin
			System.out.println("loginAttempt method called, login successful");
			username=req.getParameter("username");
			session.setAttribute("isAdmin", true);
			return "Search";// Home
		default:
			System.out.println("loginAttempt method called, login unsuccessful");
			m.addAttribute("message", "Incorrect credentials. Please try again.");
			return "Login"; // Login/unsuccessful}
		}
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchPage() {
		return "Search";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchForm(@RequestParam("input") String location, HttpServletRequest req, Model m) {
		m.addAttribute("location", location);
		HttpSession session = req.getSession();
		boolean isAdmin = (boolean) session.getAttribute("isAdmin");
		if (isAdmin) {
			m.addAttribute("resolverLink", "<a href=\"resolver\">Resolver <span id=\"submitGlyph\" class=\"glyphicon glyphicon-ok-sign\"></span></a>");
			return "Home";
		} else {
			return "Home";	
		}
	}
}