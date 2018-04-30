package com.raki.AutoCrankBackEnd.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raki.AutoCrankBackEnd.Dao.SupplierDao;
import com.raki.AutoCrankBackEnd.Model.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.raki.*");
		ctx.refresh();
		Supplier sup = ((Supplier) ctx.getBean("supplier"));
		SupplierDao supDao = ((SupplierDao) ctx.getBean("supplierDao"));

		sup.setSupplierId("S101");
		sup.setSupplierName("Rakesh");
		sup.setSupplierPh_no("9738620777");
		sup.setSupplierAddress("supplierAddress");
		if (supDao.saveorupdateSupplier(sup) == true) {
			System.out.println("Supplier Added Successfully");
		} else {
			System.out.println("Supplier Not Added");
		}

		sup.setSupplierId("S102");
		sup.setSupplierName("supplierName");
		sup.setSupplierPh_no("08026998367");
		sup.setSupplierAddress("supplierAddress");
		if (supDao.saveorupdateSupplier(sup) == true) {
			System.out.println("Supplier Added Successfully");
		} else {
			System.out.println("Supplier Not Added ");
		}

		sup = supDao.getSupplier("S102");
		if (supDao.deleteSupplier(sup) == true) {
			System.out.println("Supplier Deleted Succesfully");
		} else {
			System.out.println("Supplier Not Deleted");
		}

		sup = supDao.getSupplier("S101");
		if (sup == null) {
			System.out.println("Supplier iS Empty");
		} else {
			System.out.println("Supplier Info:");
			System.out.println(sup.getSupplierId());
			System.out.println(sup.getSupplierName());
			System.out.println(sup.getSupplierPh_no());
			System.out.println(sup.getSupplierAddress());
		}

		List<Supplier> slist = supDao.list();
		for (Supplier s : slist) {
			System.out.println(s.getSupplierId());
			System.out.println(s.getSupplierName());
			System.out.println(s.getSupplierPh_no());
			System.out.println(s.getSupplierAddress());

		}
	}
}
