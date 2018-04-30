package com.raki.AutoCrankBackEnd.Dao;

import java.util.List;

import com.raki.AutoCrankBackEnd.Model.Billing;

public interface BillingDao {
	public boolean saveorupdateBilling(Billing billing);

	public boolean deleteBilling(Billing billing);

	public Billing getBilling(String billingId);

	public List<Billing> list();
}
