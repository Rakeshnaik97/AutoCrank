package com.raki.AutoCrankBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.raki.AutoCrankBackEnd.Dao.UserDao;
import com.raki.AutoCrankBackEnd.Model.User;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveorupdateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
