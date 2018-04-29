package com.raki.AutoCrankBackEnd.DaoImpl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("shippingDao")
public class ShippingDaoImpl implements ShippingDao {
	@Autowired
	SessionFactory sessionFactory;

	public ShippingDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveorupdateShipping(Shipping shipping) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		return true;
	}

	@Override
	public boolean deleteShipping(Shipping shipping) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(shipping);
		return true;
	}

	@Override
	public Shipping getShipping(String shippingId) {
		// TODO Auto-generated method stub
		String s = "From Shipping Where shippingId='" + shippingId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<Shipping> list = (List<Shipping>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("Shipping list is Empty");
			return null;
		} else {
			System.out.println("Shipping list:");
			return list.get(0);
		}
	}

	@Override
	public List<Shipping> list() {
		// TODO Auto-generated method stub
		List<Shipping> list = (List<Shipping>) sessionFactory.getCurrentSession().createCriteria(Shipping.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

}
