package com.revature.controllers;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.service.DealService;


@Controller
public class DealController {

	@RequestMapping(value = "/deals", method=RequestMethod.GET)
	@ResponseBody
	public String JSONDeals() throws JsonProcessingException {
		String dealsJSON = DealService.getDeals();
		return dealsJSON;
	}
	
	@RequestMapping(value = "/home")
	public String home() {
		return "Home";
	}
	
	@RequestMapping(value = "/deal{num}")
	public String deal() {
		return "Deal";
	}
	
	@RequestMapping(value = "/suggest")
	public String suggest() {
		return "Suggest";
	}
	
	@RequestMapping(value = "/submit", method=RequestMethod.POST) //type post //will be used to submit a new request with post on form
	public String submit() { //will also redirect to a confirmation page
		return "ThankYou";
	}
	
	@RequestMapping(value = "/addDeal", method=RequestMethod.POST) //type post
	public void add() {
		//use method that gets venue by ID and creates a venue object
		//deal constructor, uses venue object as one of its args
		//no end point
	}
}
