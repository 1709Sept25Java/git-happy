package com.revature.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.util.HibernateUtil;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Resource(name="sessionFactory")
	@Override
	public boolean checkLogin(String email, String password) {

		Session s = HibernateUtil.getSession();
		boolean isUser= false;
		String hql = "from Users where email=? and password=?";
		Query query = s.createQuery(hql);
		query.setParameter(0, email);
		query.setParameter(1, password);
		List list = query.list();
		while(list.iterator().hasNext()) {
			if((list != null) && (list.size()>0)) {
				isUser=true;
			}
		}
		s.close();
		return isUser;
	}

}
