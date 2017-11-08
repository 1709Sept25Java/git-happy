package com.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class DealController {

	@RequestMapping(value="/Search", method=RequestMethod.POST)
	public String search() {
		return "Home";
	}
}

