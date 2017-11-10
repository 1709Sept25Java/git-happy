package com.revature.controllers;

import org.hibernate.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import com.fasterxml.jackson.core.JsonProcessingException;

import com.revature.dao.DealDaoImpl;

import com.revature.dao.Sessions;
import com.revature.dao.VenueDaoImpl;
import com.revature.domain.Deal;
import com.revature.domain.Venue;
import com.revature.service.DealService;

import com.revature.util.HibernateUtil;

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
	@RequestMapping(value = "/suggest", method=RequestMethod.GET)
	public String suggest() {
		return "Suggest";
	}
	@RequestMapping(value = "/suggest", method = RequestMethod.POST)
	public String suggest(@RequestParam("venueName") String venueName, @RequestParam("venueAddress") String address, @RequestParam("venuephone") String phone, @RequestParam("dealType") String type, @RequestParam("description") String description, @RequestParam("price") double price, @RequestParam("startTime") int start_time, @RequestParam("endTime") int end_time, @RequestParam("venue") Venue venue,Model m) {
		VenueDaoImpl vdi = new VenueDaoImpl();
		int suggestion = vdi.addVenueSuggestions(new Venue(venueName, address, phone));
		m.addAttribute("venueName", venueName);
		m.addAttribute("venueAddress",address);
		m.addAttribute("venuePhone", phone);
		DealDaoImpl ddi = new DealDaoImpl();
		int dealSuggestion = ddi.addDealSuggestion(new Deal(type,description,price,start_time,end_time,venue));
		m.addAttribute("dealType",type);
		m.addAttribute("description",description);
		m.addAttribute("price",price);
		m.addAttribute("startTime",start_time);
		m.addAttribute("endTime",end_time);
		return "ThankYou";
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