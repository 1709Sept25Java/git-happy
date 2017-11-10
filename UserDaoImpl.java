package com.revature.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
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
	     List<User> user=s.createCriteria(User.class).add(Restrictions.eq("email", email)).add(Restrictions.eq("password", password)).list();
		for(User u : user) {
			if(email.equals(email) && password.equals(password)) {
			System.out.println(u);
			isUser=1;
			}else {
				isUser=0;
			}
		}
			
		
		/*String hql = "from User where email=? and password=?";
		List result = s.createQuery(hql).setParameter(0, email).setParameter(1, password).list();
		while(result.iterator().hasNext()) {
			if(email.equals(email)) {
				isUser=true;
			}
		}*/
		/*Query query = s.createQuery(hql);
		query.setParameter(0, email);
		query.setParameter(1, password);
		List list = query.list();
		while(list.iterator().hasNext()) {
			if((list != null) && (list.size()>0)) {
				isUser=true;
			}
		}*/
		s.close();
		return isUser;
	}

}