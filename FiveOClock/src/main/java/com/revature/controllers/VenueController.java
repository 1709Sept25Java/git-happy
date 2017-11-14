package com.revature.controllers;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.hibernate.collection.internal.PersistentBag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.dao.VenueDaoImpl;
import com.revature.domain.Deal;
import com.revature.domain.Venue;

import antlr.collections.List;

@Controller
@RequestMapping(value="/venue")
public class VenueController {
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getVenue(@PathVariable String id, Model m){
		m.addAttribute("venueId", id);
		VenueDaoImpl vdi = new VenueDaoImpl();
		Venue venue = vdi.getVenueById(Integer.parseInt(id));
		m.addAttribute("venueName", venue.getVenueName());
		m.addAttribute("venueAddress", venue.getAddress());
		String phone = venue.getPhone();
		phone = "("+phone.subSequence(0, 3)+") " +phone.subSequence(3, 6)+" "+phone.subSequence(6, 10);
		m.addAttribute("venuePhone", phone );
		PersistentBag deals = (PersistentBag) venue.getDeals();
		
		Deal deal = (Deal) deals.get(0);
		String startTime = Integer.toString(deal.getStartTime());
		startTime = startTime.substring(0, 2)+":"+startTime.substring(3)+"0";
		String endTime = Integer.toString(deal.getEndTime());
		endTime = endTime.substring(0, 2)+":"+endTime.substring(3)+"0";
		String timeString = "Deals begin at "+startTime+" and end at "+endTime;
		
		String dealHTML= "<table id=\"dealsTable\" class=\"table table-hover\"  style = \"text-align: center;\" >";
		for(int i = 0; i<deals.size(); i++) {
			Deal d = (Deal) deals.get(i);
			dealHTML = dealHTML + "<tr><td class=\"type-cell\">"+d.getType()+"<td><td class=\"price-cell\"> $"+d.getPrice()+"0 </td><td class=\"description-cell\">"+d.getDescription()+"</td></tr>";
		}
		dealHTML = dealHTML+"</table>";
		m.addAttribute("deals", dealHTML);
		m.addAttribute("dealTimes", timeString);
		return "Venue"; 
	}

}
