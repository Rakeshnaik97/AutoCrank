package com.raki.AutoCrankBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.raki.AutoCrankBackEnd.Dao.SupplierDao;
import com.raki.AutoCrankBackEnd.Model.Supplier;

public class SupplierDaoImpl implements SupplierDao {

	public SupplierDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveorupdateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Supplier> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
