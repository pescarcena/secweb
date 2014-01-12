package com.jmark.service;

import java.util.List;

import com.jmark.entity.User;
import com.jmark.utils.Pager;

public interface UserService {
	public User getUserByName(String username);
	public List<User> findUserByPager(Pager pager);
}
