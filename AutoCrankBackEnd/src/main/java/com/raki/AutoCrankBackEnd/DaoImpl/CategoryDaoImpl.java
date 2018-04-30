package com.raki.AutoCrankBackEnd.DaoImpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.raki.AutoCrankBackEnd.Dao.CategoryDao;
import com.raki.AutoCrankBackEnd.Model.Category;

@Transactional
@Repository("categoryDao")
@EnableTransactionManagement
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdateCategory(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;

	}

	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(category);
		return true;
	}

	public Category getCategory(String catId) {
		// TODO Auto-generated method stub
		String s = "From Category Where catId='" + catId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<Category> list = (List<Category>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("Category List Not Found");
			return null;
		} else {
			System.out.println("Category list");
			return list.get(0);
		}
	}

	public List<Category> list() {
		// TODO Auto-generated method stub
		List<Category> category = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return category;

	}

}
