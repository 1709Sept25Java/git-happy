package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Deal;
import com.revature.util.HibernateUtil;

public class DealDaoImpl implements DealDao{

	@Override
	public String getDealsJSON() throws JsonProcessingException {
		Session s = HibernateUtil.getSession();
		List<Deal> deals = s.createCriteria(Deal.class).addOrder(Order.asc("price")).list();
		for (Deal d : deals) {
			System.out.println(d);
		}
	/*	ObjectMapper om = new ObjectMapper();
			String dealJSON = om.writeValueAsString(deals);
			System.out.println(dealJSON);*/
		
		return dealJSON;
	}

}
