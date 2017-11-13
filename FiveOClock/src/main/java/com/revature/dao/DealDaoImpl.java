package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
			dealJSON = dealJSON + "\""+d.getDealId() +"\" : { \"type\" : \"" + d.getType()+ "\" , \"description\" : \""+d.getDescription() + "\" ,\"price\" : \""+d.getPrice()+"\", \"startTime\" : \""+d.getStartTime()+"\", \"endTime\" : \""+d.getEndTime()+ "\", \"status\" : \""+d.getStatus()+ "\", \"venue\" : { \"venueId\" : \""+d.getVenue().getVenueId()+"\", \"venueName\" : \""+d.getVenue().getVenueName()+"\", \"address\" : \""+d.getVenue().getAddress()+"\" } }";
		}
		//{"dealId":31,"type":"Beer","description":"PBR","price":3.0,"startTime":1500,"endTime":2000,"venue":{"venueId":10,"venueName":"Bar Matchless","address":"557 Manhattan Ave Brooklyn, NY 11222","deals":null}},{"dealId":34,"type":"Wells","description":"shots of wells","price":3.0,"startTime":1100,"endTime":2000,"venue":{"venueId":11,"venueName":"Black Swan","address":"1048 Bedford Ave New York, NY 11205","deals":null}}
		return dealJSON+" }";
	}
	
	@Override
	public String viewPendingDealsJSON() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		List<Deal> pendingList = s.createCriteria(Deal.class).add(Restrictions.eq("status", "pending")).list();
		String pendingListJSON = "{";
		int count = 0;
		for(Deal d : pendingList) {
		
			if(count>0) {
				pendingListJSON=pendingListJSON+",";
			}
			count++;
			pendingListJSON = pendingListJSON +"\" { \"dealId\" : \"" +d.getDealId() +"\"  \"type\" : \"" + d.getType()+ "\" , \"description\" : \""+d.getDescription() + "\" ,\"price\" : \""+d.getPrice()+"\", \"startTime\" : \""+d.getStartTime()+"\", \"endTime\" : \""+d.getEndTime()+"\",\"status\":\""+d.getStatus()+ "\", \"venue\" : { \"venueId\" : \""+d.getVenue().getVenueId()+"\", \"venueName\" : \""+d.getVenue().getVenueName()+"\", \"address\" : \""+d.getVenue().getAddress()+"\" } }";
		}
		return pendingListJSON +"}";
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
	@Override
	public int approveSuggestion(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx=s.beginTransaction();
		int result =1;
		String hql= "update Deal set status = 'published' where dealId =?";
		Query query=s.createQuery(hql);
		query.setParameter(0, id);
		int res = query.executeUpdate();
		System.out.println(res);
		tx.commit();
		result =2;
		s.close();
		return result;
	}
	@Override
	public int denySuggestion(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx=s.beginTransaction();
		int result =1;
		String hql= "delete Deal where dealId =?";
		Query query=s.createQuery(hql);
		query.setParameter(0, id);
		int rest= query.executeUpdate();
		tx.commit();
		result =0;
		s.close();
		return result;
	}

}
