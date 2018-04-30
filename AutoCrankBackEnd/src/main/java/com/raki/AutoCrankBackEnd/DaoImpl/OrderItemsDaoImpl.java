package com.raki.AutoCrankBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.raki.AutoCrankBackEnd.Dao.OrderItemsDao;
import com.raki.AutoCrankBackEnd.Model.OrderItems;
@EnableTransactionManagement
@Transactional
@Repository("orderItemsDao")
public class OrderItemsDaoImpl implements OrderItemsDao {

	@Autowired
	SessionFactory sessionFactory;

	public OrderItemsDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveorupdateOrderItems(OrderItems orderItems) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(orderItems);
		return true;

	}

	@Override
	public boolean deleteOrderItems(OrderItems orderItems) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(orderItems);
		return true;
	}

	@Override
	public OrderItems getOrderItems(String orderItemsId) {
		// TODO Auto-generated method stub
		String s = "From OrderItems where orderItemsId='" + orderItemsId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<OrderItems> list = (List<OrderItems>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("OrderItems Is Empty");
			return null;
		} else {
			System.out.println("OrderItems Info:");
			return list.get(0);
		}
	}

	@Override
	public List<OrderItems> list() {
		// TODO Auto-generated method stub
		List<OrderItems> list = (List<OrderItems>) sessionFactory.getCurrentSession().createCriteria(OrderItems.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

}
