package com.raki.AutoCrankBackEnd.DaoImpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.raki.AutoCrankBackEnd.Dao.ProductDao;
import com.raki.AutoCrankBackEnd.Model.Product;

@Transactional
@Repository("productDao")
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	
	public boolean saveorupdateProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;

	}

	
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}

	
	public Product getProduct(String ProductId) {
		// TODO Auto-generated method stub
		String s = "From Product Where productId ='" + ProductId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<Product> list = (List<Product>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("Product List Not Found");
			return null;
		} else {
			System.out.println("Product list");
			return list.get(0);
		}
	}

	
	public List<Product> list() {
		// TODO Auto-generated method stub
		List<Product> product = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return product;
	}

}
