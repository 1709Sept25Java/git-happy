package com.revature.dao;

import com.revature.domain.Venue;

public interface VenueDao {

	public int addVenueSuggestions(Venue v);
	public Venue getVenueById(int id);
	public Venue getVenueByName(String venueName);
	
}