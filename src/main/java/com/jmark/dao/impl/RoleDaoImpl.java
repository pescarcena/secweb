package com.jmark.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jmark.dao.RoleDao;
import com.jmark.entity.Module;
import com.jmark.entity.Role;
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role,Integer> implements RoleDao {

	public List<Module> findModulesByRoleName(String rolename) {
		// TODO Auto-generated method stub
		String hql = "select role.modules from Role role where role.name = '"+rolename+"'";
		return find(hql);
	}

	
}
