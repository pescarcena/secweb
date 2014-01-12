package com.jmark.dao;


import java.util.List;

import com.jmark.entity.User;
import com.jmark.utils.Pager;

public interface UserDao {
	public User getUserByName(String username);
	public List<User> findUserByPager(Pager pager);
}
