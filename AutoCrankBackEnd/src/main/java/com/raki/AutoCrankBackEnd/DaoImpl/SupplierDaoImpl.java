package com.raki.AutoCrankBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.raki.AutoCrankBackEnd.Dao.SupplierDao;
import com.raki.AutoCrankBackEnd.Model.Supplier;

@Transactional
@Repository("supplierDao")
@EnableTransactionManagement
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionFactory;

	public SupplierDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
	}

	public boolean deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	}

	public Supplier getSupplier(String SupplierId) {
		// TODO Auto-generated method stub
		String s = "From Supplier Where SupplierId='" + SupplierId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<Supplier> list = (List<Supplier>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("Supplier List Not Found");
			return null;
		} else {
			System.out.println("Supplier list");
			return list.get(0);
		}
	}

	public List<Supplier> list() {
		// TODO Auto-generated method stub
		List<Supplier> supplier = (List<Supplier>) sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return supplier;

	}

}
