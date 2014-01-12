package com.jmark.service;

import java.util.List;

import com.jmark.entity.Module;

public interface RoleService {
	public List<Module> findModulesByRoleName(String rolename);
}
