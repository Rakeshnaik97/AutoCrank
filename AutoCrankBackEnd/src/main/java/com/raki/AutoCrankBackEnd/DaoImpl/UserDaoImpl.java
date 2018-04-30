package com.raki.AutoCrankBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.raki.AutoCrankBackEnd.Dao.UserDao;
import com.raki.AutoCrankBackEnd.Model.User;


@Transactional
@Repository("userDao")
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	
	public boolean saveorupdateUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

	
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	
	public User getUser(String UserId) {
		// TODO Auto-generated method stub
		String s = "From User Where UserId ='" + UserId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<User> list = (List<User>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("User List Not Found");
			return null;
		} else {
			System.out.println("User list");
			return list.get(0);
		}
	}

	
	public List<User> list() {
		// TODO Auto-generated method stub
		List<User> user = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return user;
	}

}
