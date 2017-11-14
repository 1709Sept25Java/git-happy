package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.domain.User;
import com.revature.util.HibernateUtil;

//@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public int checkLogin(String email, String password) {
		Session s = HibernateUtil.getSession();
		int isUser= 0;
	    List<User> user=s.createCriteria(User.class).add(Restrictions.eq("email", email)).add(Restrictions.eq("password", password)).list();
	    for(User u : user) {
			if(email.equals(email) && password.equals(password)) {
				if(u.isAdmin()) {
					isUser=2;
				} else {
					isUser=1;
				}
			} else {
				isUser=0;
			}
		}
		s.close();
		return isUser;
	}

}

