package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "/deals", method = RequestMethod.GET)
	@ResponseBody
	public String JSONDeals() throws JsonProcessingException {
		String dealsJSON = DealService.getDeals();
		return dealsJSON;
	}

	@RequestMapping(value = "/resolvers", method = RequestMethod.GET)
	@ResponseBody
	public String JSONPendings() throws JsonProcessingException {
		String pendingsJSON = DealService.viewPendingDeals();
		return pendingsJSON;
	}

	@RequestMapping(value = "/resolver", method = RequestMethod.GET)
	public String Resolving() {
		return "Resolver";
	}

	@RequestMapping(value = "/resolver", method = RequestMethod.POST, params = "approve")
	public String ResolvingA(HttpServletRequest req, @RequestParam("dealId") int deal) {
		DealDaoImpl ddi = new DealDaoImpl();
		// int id = Integer.parseInt(req.getParameter("dealId"));
		if (!req.getParameter("approve").toString().equals(null)) {
			int approve = ddi.approveSuggestion(deal);
		}
		return "Resolver";
	}

	@RequestMapping(value = "/resolver", method = RequestMethod.POST, params = "deny")
	public String ResolvingD(HttpServletRequest req, @RequestParam("deal") int deal) {
		DealDaoImpl ddi = new DealDaoImpl();
		// int id = Integer.parseInt(req.getParameter("deal"));
		if (!req.getParameter("deny").toString().equals(null)) {
			int deny = ddi.denySuggestion(deal);
		}
		return "Resolver";
	}

	@RequestMapping(value = "/home")
	public String home() {
		return "Home";
	}

	@RequestMapping(value = "/deal{num}")
	public String deal() {
		return "Deal";
	}

	@RequestMapping(value = "/suggest", method = RequestMethod.GET)
	public String suggest() {
		return "Suggest";
	}

	@RequestMapping(value = "/suggest", method = RequestMethod.POST)
	public String suggest(@RequestParam("venueName") String name, @RequestParam("venueAddress") String address,
			@RequestParam("venuephone") String phone, @RequestParam("dealType1") String type,
			@RequestParam("description1") String description, @RequestParam("price1") double price,
			@RequestParam("startTime1") int start_time, @RequestParam("endTime1") int end_time,
			@RequestParam("venue") Venue venue, @RequestParam("dealType2") String type2,
			@RequestParam("description2") String description2, @RequestParam("price2") double price2,
			@RequestParam("startTime2") int start_time2, @RequestParam("endTime2") int end_time2,
			@RequestParam("dealType3") String type3, @RequestParam("description3") String description3,
			@RequestParam("price3") double price3, @RequestParam("startTime3") int start_time3,
			@RequestParam("endTime3") int end_time3) {
		Venue newVenue = new Venue(name, address, phone);
		VenueDaoImpl vdi = new VenueDaoImpl();
		int suggestion = vdi.addVenueSuggestions(new Venue(name, address, phone));
		// m.addAttribute("venueName", name);
		// m.addAttribute("venueAddress", address);
		// m.addAttribute("venuePhone", phone);
		DealDaoImpl ddi = new DealDaoImpl();
		int dealSuggestion = ddi.addDealSuggestion(new Deal(type, description, price, start_time, end_time, newVenue));
		if (description2.length() != 0) {
			int dealSuggestion2 = ddi
					.addDealSuggestion(new Deal(type2, description2, price2, start_time2, end_time2, newVenue));
		}
		if (description3.length() != 0) {
			int dealSuggestion3 = ddi
					.addDealSuggestion(new Deal(type3, description3, price3, start_time3, end_time3, newVenue));
		}
		/*
		 * for (int i = 1; i <= 3; i++) { m.addAttribute("dealType", type);
		 * m.addAttribute("description", description); m.addAttribute("price", price);
		 * m.addAttribute("startTime", start_time); m.addAttribute("endTime", end_time);
		 * m.addAttribute("venueName", name); }
		 */
		return "ThankYou";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST) // type post //will be used to submit a new request
																	// with post on form
	public String submit() { // will also redirect to a confirmation page
		return "ThankYou";
	}

	@RequestMapping(value = "/addDeal", method = RequestMethod.POST) // type post
	public void add() {
		// use method that gets venue by ID and creates a venue object
		// deal constructor, uses venue object as one of its args
		// no end point
	}
}