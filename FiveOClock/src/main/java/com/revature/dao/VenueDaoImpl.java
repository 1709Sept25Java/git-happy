package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.domain.Venue;
import com.revature.util.HibernateUtil;

public class VenueDaoImpl implements VenueDao {


	@Override
	public int addVenueSuggestions(Venue v) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = 0;
		s.saveOrUpdate(v);
		tx.commit();
		s.close();
		
		return result;
	}

	@Override
	public Venue getVenueById(int id) {
		Session s = HibernateUtil.getSession();
		Venue v = (Venue) s.get(Venue.class, id);
		s.close();
		return v;
	}

	@Override
	public Venue getVenueByName(String venueName) {
		Session s = HibernateUtil.getSession();
		List<Venue> v = s.createCriteria(Venue.class).add(Restrictions.eq("venueName", venueName)).list();
		//Venue venue=(Venue) s.get(Venue.class, venueName);//s.createCriteria(Venue.class).add(Restrictions.eq("venueName", venueName)).list();
		/*for (Venue ven : v) {
			System.out.println(ven);
		}*/
		s.close();
		return v.get(0);
	}
}
