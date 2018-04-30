package com.raki.AutoCrankBackEnd.Dao;

import java.util.List;

import com.raki.AutoCrankBackEnd.Model.Authentication;

public interface AuthenticationDao {
	public boolean saveorupdateAuthentication(Authentication authentication);

	public boolean deleteAuthentication(Authentication authentication);

	public Authentication getAuthentication(String authenticationId);

	public List<Authentication> list();
}
