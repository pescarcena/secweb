package com.jmark.dao;


import com.jmark.entity.User;

public interface UserDao {
	public User getUserByName(String username);
	
}
