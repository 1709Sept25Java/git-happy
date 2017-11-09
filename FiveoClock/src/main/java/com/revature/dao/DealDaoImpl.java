package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Deal;
import com.revature.util.HibernateUtil;

@Repository("dealDao")
public class DealDaoImpl implements DealDao {

	@Override
	public String getDealsJSON() throws JsonProcessingException {
		Session s = HibernateUtil.getSession();
		List<Deal> deals = s.createCriteria(Deal.class).addOrder(Order.asc("price")).list();
		for (Deal d : deals) {

			d.getVenue().setDeals(null);
		}
		ObjectMapper om = new ObjectMapper();
		String dealJSON = om.writeValueAsString(deals);
		System.out.println(dealJSON);

		return dealJSON;
	}

}
