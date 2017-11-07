package com.revature.dao;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.domain.Deal;

public interface DealDao {
	public String getDealsJSON()throws JsonProcessingException;
	
}
