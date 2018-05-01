package com.raki.AutoCrankBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.raki.AutoCrankBackEnd.Dao.OrderDao;
import com.raki.AutoCrankBackEnd.Model.Order;

@Transactional
@EnableTransactionManagement
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

	@Autowired
	SessionFactory sessionFactory;

	public OrderDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveorupdateOrder(Order order) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return true;
	}

	@Override
	public boolean deleteOrder(Order order) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(order);
		return true;
	}

	@Override
	public Order getOrder(String orderId) {
		// TODO Auto-generated method stub
		String s = "From Order Where orderId='" + orderId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<Order> list = (List<Order>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("Order is Empty");
			return null;
		} else {
			System.out.println("Order list:");
			return list.get(0);
		}

	}

	@Override
	public List<Order> list() {
		// TODO Auto-generated method stub

		List<Order> list = (List<Order>) sessionFactory.getCurrentSession().createCriteria(Order.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

}
