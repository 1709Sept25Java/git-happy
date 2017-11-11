package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.domain.Venue;

@Controller
@RequestMapping(value="/venue")
public class VenueController {
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getVenue(@PathVariable String id, Model m){
		m.addAttribute("venueId", id);
		return "Venue"; //returns venue info
	}

}
