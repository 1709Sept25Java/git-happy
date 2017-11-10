package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.dao.VenueDaoImpl;
import com.revature.domain.Venue;

public class VenueController {
	@RequestMapping(value="/Venue/{name}", method=RequestMethod.GET)
	public ResponseEntity<Venue> getVenueByName(@PathVariable("name") String name){
		return new ResponseEntity<Venue>(null); //returns venue info
	}
	
	@RequestMapping(value="/Suggestion", method=RequestMethod.POST)
	public String addVenueSuggestion(@RequestParam("venueName") String venueName, @RequestParam("venueAddress") String address, @RequestParam("venuephone") String phone, Model m) {
		VenueDaoImpl vdi = new VenueDaoImpl();
		int suggestion = vdi.addVenueSuggestions(new Venue(venueName, address, phone));
		m.addAttribute("venueName", venueName);
		m.addAttribute("venueAddress",address);
		m.addAttribute("venuePhone", phone);
		return "Home";
	}
}