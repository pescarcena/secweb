package com.jmark.dao.impl;


import org.springframework.stereotype.Repository;

import com.jmark.dao.UserDao;
import com.jmark.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User,Integer> implements UserDao {
	
	public User getUserByName(String username) {
		String hql = "from User user where user.username = ?";
		String[] param = {username};
		return (User)find(hql, param).get(0);
	}

	
}
