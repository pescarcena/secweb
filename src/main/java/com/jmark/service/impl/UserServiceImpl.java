package com.jmark.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmark.dao.UserDao;
import com.jmark.entity.User;
import com.jmark.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource 
	private UserDao userDao;
	
	public User getUserByName(String username) {
		return userDao.getUserByName(username);
	}

}
