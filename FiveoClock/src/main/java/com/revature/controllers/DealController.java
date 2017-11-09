package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.service.DealService;

@Controller
public class DealController {

	@RequestMapping(value="/home", method=RequestMethod.GET) //this WAS a POST
	public String search() {
		return "Home";
	}
	@RequestMapping(value="/deals", method=RequestMethod.GET)
	public String JSONDeals() throws JsonProcessingException {
		String dealsJSON = DealService.getDeals();
		return dealsJSON;
	}
}

