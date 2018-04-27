package com.raki.AutoCrankBackEnd.Dao;

import java.util.List;

import com.raki.AutoCrankBackEnd.Model.Supplier;

public interface SupplierDao {
	public boolean saveorupdateSupplier(Supplier supplier);

	public boolean deleteSupplier(Supplier supplier);

	public boolean getSupplier(Supplier supplier);

	public List<Supplier> list();
}
