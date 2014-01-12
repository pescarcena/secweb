package com.jmark.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmark.dao.UserDao;
import com.jmark.entity.User;
import com.jmark.service.UserService;
import com.jmark.utils.Pager;

@Service
public class UserServiceImpl implements UserService {
	@Resource 
	private UserDao userDao;
	
	public User getUserByName(String username) {
		return userDao.getUserByName(username);
	}

	public List<User> findUserByPager(Pager pager) {
		// TODO Auto-generated method stub
		return userDao.findUserByPager(pager);
	}

}
