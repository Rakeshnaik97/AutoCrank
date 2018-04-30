package com.raki.AutoCrankBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.raki.AutoCrankBackEnd.Dao.CartDao;
import com.raki.AutoCrankBackEnd.Model.Cart;

@Repository("cartDao")
@Transactional
@EnableTransactionManagement

public class CartDaoimpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;

	public CartDaoimpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveorupdateCart(Cart cart) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	@Override
	public boolean deleteCart(Cart cart) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(cart);
		return true;
	}

	@Override
	public Cart getCart(String cartId) {
		// TODO Auto-generated method stub
		String s = "From Cart where cartId='" + cartId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<Cart> list = (List<Cart>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("Cart Not Found");
			return null;
		} else {
			System.out.println("Cart List");
			return list.get(0);
		}
	}

	@Override
	public List<Cart> list() {
		// TODO Auto-generated method stub
		List<Cart> list = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

}
