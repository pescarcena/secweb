package com.jmark.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmark.dao.RoleDao;
import com.jmark.entity.Module;
import com.jmark.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Resource private RoleDao roleDao;
	public List<Module> findModulesByRoleName(String rolename) {
		// TODO Auto-generated method stub		
		return roleDao.findModulesByRoleName(rolename);
	}

}
