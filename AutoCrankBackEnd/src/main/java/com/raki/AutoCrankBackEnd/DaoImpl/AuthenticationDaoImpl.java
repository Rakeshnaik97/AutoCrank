package com.raki.AutoCrankBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.raki.AutoCrankBackEnd.Dao.AuthenticationDao;
import com.raki.AutoCrankBackEnd.Model.Authentication;

@Transactional
@Repository("authenticationDao")
@EnableTransactionManagement
public class AuthenticationDaoImpl implements AuthenticationDao {

	@Autowired
	SessionFactory sessionFactory;

	public AuthenticationDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveorupdateAuthentication(Authentication authentication) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		return true;
	}

	@Override
	public boolean deleteAuthentication(Authentication authentication) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(authentication);
		return true;
	}

	@Override
	public Authentication getAuthentication(String roleId) {
		// TODO Auto-generated method stub
		String s = "From Authentication Where roleId='" + roleId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<Authentication> list = (List<Authentication>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("Aunthetication list Not Found");
			return null;
		} else {
			System.out.println("Aunthetication list");
			return list.get(0);
		}
	}

	@Override
	public List<Authentication> list() {
		// TODO Auto-generated method stub
		List<Authentication> authentication = (List<Authentication>) sessionFactory.getCurrentSession()
				.createCriteria(Authentication.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return authentication;
	}

}
