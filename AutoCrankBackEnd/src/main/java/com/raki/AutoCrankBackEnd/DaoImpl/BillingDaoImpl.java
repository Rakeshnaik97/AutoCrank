package com.raki.AutoCrankBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.raki.AutoCrankBackEnd.Dao.BillingDao;
import com.raki.AutoCrankBackEnd.Model.Billing;

@Transactional
@EnableTransactionManagement
@Repository("billingDao")
public class BillingDaoImpl implements BillingDao {

	@Autowired
	SessionFactory sessionFactory;

	public BillingDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveorupdateBilling(Billing billing) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(billing);
		return true;
	}

	@Override
	public boolean deleteBilling(Billing billing) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(billing);
		return true;
	}

	@Override
	public Billing getBilling(String billingId) {
		// TODO Auto-generated method stub
		String s = "From Billing Where billingId ='" + billingId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<Billing> list = (List<Billing>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("Billing List Not Found");
			return null;
		} else {
			System.out.println("Billing List");
			return list.get(0);
		}
	}

	@Override
	public List<Billing> list() {
		// TODO Auto-generated method stub
		List<Billing> billing = (List<Billing>) sessionFactory.getCurrentSession().createCriteria(Billing.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return billing;
	}

}
