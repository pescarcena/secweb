package com.jmark.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.jmark.dao.ModuleDao;
import com.jmark.entity.Module;
import com.jmark.entity.Role;
@Repository
public class ModuleDaoImpl extends BaseDaoImpl<Module,Integer> implements ModuleDao {



	public List<Module> getAllModules() {
		// TODO Auto-generated method stub
		return loadAll();
	}

	

}
