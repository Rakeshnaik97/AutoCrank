package com.raki.AutoCrankBackEnd.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raki.AutoCrankBackEnd.Dao.AuthenticationDao;
import com.raki.AutoCrankBackEnd.Model.Authentication;

public class AuthenticationTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.raki.*");
		context.refresh();
		Authentication auth = (Authentication) context.getBean("authentication");
		AuthenticationDao authDao = (AuthenticationDao) context.getBean("authenticationDao");

		auth.setRoleId("A101");
		auth.setRoleName("Administrator");
		auth.setUserName("RakeshNaik");
		authDao.saveorupdateAuthentication(auth);
		if (authDao.saveorupdateAuthentication(auth) == true) {
			System.out.println("Authentication is Added Succesfully");
		} else {
			System.out.println("Authentication not Added ");
		}

		auth.setRoleId("A102");
		auth.setRoleName("Administrator");
		auth.setUserName("RakeshNaik");
		authDao.saveorupdateAuthentication(auth);
		if (authDao.saveorupdateAuthentication(auth) == true) {
			System.out.println("Authentication is Added Succesfully");
		} else {
			System.out.println("Authentication not Added ");
		}

		auth = authDao.getAuthentication("A102");
		if (authDao.deleteAuthentication(auth) == true) {

			System.out.println("Authentication Deleted Succesfully");
		} else {
			System.out.println("Authentication Not Deleted");
		}

		auth = authDao.getAuthentication("A101");
		if (auth == null) {
			System.out.println("Authentical Is Empty");
		} else {
			System.out.println("Authentication Info:");
			System.out.println(auth.getRoleId());
			System.out.println(auth.getRoleName());
			System.out.println(auth.getUserName());
		}

		List<Authentication> alist = authDao.list();
		for (Authentication a : alist) {
			System.out.println(a.getRoleId());
			System.out.println(a.getRoleName());
			System.out.println(a.getUserName());
		}

	}
}
