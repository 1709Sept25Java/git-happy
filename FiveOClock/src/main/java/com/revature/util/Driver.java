package com.revature.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.*;


public class Driver {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
//		User s1 = new User("admin@gmail.com", "pass", true);
//		User s2 = new User("user1@gmail.com","pass123");
//		Venue v1 = new Venue("Cool Bar", "500 Broadway");
//		Deal d1 = new Deal("Beer","$3 pbr cans",3.00,500,700,v1);
//		s.save(s1);
//		s.save(s2);
//		s.save(v1);
//		s.save(d1);
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(v1);
//		System.out.println(d1);

		tx.commit();
		s.close();
		
		
	}

}
