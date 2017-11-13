package com.revature.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.revature.domain.User;
import com.revature.util.HibernateUtil;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public int checkLogin(String email, String password) {

		Session s = HibernateUtil.getSession();
		int isUser= 0;
		//int isadmin=0;
	     List<User> user=s.createCriteria(User.class).add(Restrictions.eq("email", email)).add(Restrictions.eq("password", password)).list();
		for(User u : user) {
			if(email.equals(email) && password.equals(password)) {
				/*if(!u.isAdmin()) {
					isadmin= 0;
				}else {
					isadmin= 1;
				}*/
			System.out.println(u);
			isUser=1;
			}else {
				isUser=0;
				//return 0;
			}
		}
		s.close();
		//return isadmin;
		return isUser;
	}

	@Override
	public int checkAdmin(String email, String password) {
		Session s = HibernateUtil.getSession();
		int isadmin=0;
	     List<User> user=s.createCriteria(User.class).add(Restrictions.eq("email", email)).add(Restrictions.eq("password", password)).list();
		for(User u : user) {
			if(email.equals(email) && password.equals(password)) {
				if(!u.isAdmin()) {
					isadmin= 0;
				}else {
					isadmin= 1;
				}
			System.out.println(u);
			
			}else {
				isadmin=0;
				//isUser=0;
				//return 0;
			}
		}
		s.close();
		return isadmin;
	}

	

}