package com.jmark.dao;

import java.util.List;

import com.jmark.entity.Module;

public interface RoleDao {
	public List<Module> findModulesByRoleName(String rolename);
}
