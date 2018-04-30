package com.raki.AutoCrankBackEnd.Dao;

import java.util.List;

import com.raki.AutoCrankBackEnd.Model.Shipping;

public interface ShippingDao {

	public boolean saveorupdateShipping(Shipping shipping);

	public boolean deleteShipping(Shipping shipping);

	public Shipping getShipping(String shippingId);

	public List<Shipping> list();
}
