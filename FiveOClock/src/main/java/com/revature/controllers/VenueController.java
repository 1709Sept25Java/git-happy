package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.domain.Venue;

public class VenueController {
	
	@RequestMapping(value="/Venue/{name}", method=RequestMethod.GET)
	public ResponseEntity<Venue> getVenueByName(@PathVariable("name") String name){
		return new ResponseEntity<Venue>(null); //returns venue info
	}

}
