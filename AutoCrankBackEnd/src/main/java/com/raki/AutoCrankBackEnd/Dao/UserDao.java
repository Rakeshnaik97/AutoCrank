package com.raki.AutoCrankBackEnd.Dao;

import java.util.List;

import com.raki.AutoCrankBackEnd.Model.User;

public interface UserDao {
	public boolean saveorupdateUser(User user);

	public boolean deleteUser(User user);

	public boolean getUser(User user);

	public List<User> list();
}
