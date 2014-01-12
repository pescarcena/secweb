package com.jmark.dao.impl;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.jmark.dao.UserDao;
import com.jmark.entity.User;
import com.jmark.utils.Pager;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User,Integer> implements UserDao {
	

	public User getUserByName(String username) {
		String hql = "from User user where user.username = ?";
		String[] param = {username};
		return (User)find(hql, param).get(0);
	}

	@SuppressWarnings("unchecked")
	public List<User> findUserByPager(Pager pager) {
		 DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		 int firstResult = pager.getCurrentPage()*pager.getPageSize();
		 int maxResults = firstResult + pager.getCurrentPage();
		 return (List<User>)findByCriteria(criteria, firstResult, maxResults);
	}

	
}
