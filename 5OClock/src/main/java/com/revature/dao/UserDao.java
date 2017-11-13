package com.revature.dao;

public interface UserDao {
	public int checkLogin(String email, String password);
	public int checkAdmin(String email,String password);
}
