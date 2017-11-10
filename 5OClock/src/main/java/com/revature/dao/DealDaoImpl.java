package com.revature.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;



import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.domain.Deal;

import com.revature.util.HibernateUtil;

public class DealDaoImpl implements DealDao{

	public String getDealsJSON(Session s) throws JsonProcessingException {
		List<Deal> dealList = s.createCriteria(Deal.class).addOrder(Order.desc("price")).list();
		String dealJSON = "{ ";
		int count = 0;
		for (Deal d : dealList) {
			if(count>0) {
				dealJSON = dealJSON + " , ";
			}
			count++;
			d.getVenue().setDeals(null);
			dealJSON = dealJSON + "\""+d.getDealId() +"\" : { \"type\" : \"" + d.getType()+ "\" , \"description\" : \""+d.getDescription() + "\" ,\"price\" : \""+d.getPrice()+"\", \"startTime\" : \""+d.getStartTime()+"\", \"endTime\" : \""+d.getEndTime()+ "\", \"venue\" : { \"venueId\" : \""+d.getVenue().getVenueId()+"\", \"venueName\" : \""+d.getVenue().getVenueName()+"\", \"address\" : \""+d.getVenue().getAddress()+"\" } }";
		}
		//{"dealId":31,"type":"Beer","description":"PBR","price":3.0,"startTime":1500,"endTime":2000,"venue":{"venueId":10,"venueName":"Bar Matchless","address":"557 Manhattan Ave Brooklyn, NY 11222","deals":null}},{"dealId":34,"type":"Wells","description":"shots of wells","price":3.0,"startTime":1100,"endTime":2000,"venue":{"venueId":11,"venueName":"Black Swan","address":"1048 Bedford Ave New York, NY 11205","deals":null}}
		return dealJSON+" }";
	}

	@Override
	public int addDealSuggestion(Deal d) {
		Session s = HibernateUtil.getSession();
		Transaction tx  = s.beginTransaction();
		int result = 1;
		s.saveOrUpdate(d);
		tx.commit();
		result=2;
		s.close();
		return result;
	}
}