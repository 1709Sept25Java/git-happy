package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Deal;
import com.revature.util.HibernateUtil;

public class DealDaoImpl implements DealDao{

	public String getDealsJSON(Session s) throws JsonProcessingException {
		List<Deal> dealList = s.createCriteria(Deal.class).addOrder(Order.asc("price")).list();
		for (Deal d : dealList) {
			d.getVenue().setDeals(null);
		}
		ObjectMapper om = new ObjectMapper();
		String dealJSON = om.writeValueAsString(dealList);
		return dealJSON;
	}

}
