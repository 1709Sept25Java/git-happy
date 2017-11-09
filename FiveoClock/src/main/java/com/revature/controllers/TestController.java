package com.revature.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.domain.Deal;

@RestController
public class TestController {
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public Deal getDeal() {
		return new Deal();
	}

}
