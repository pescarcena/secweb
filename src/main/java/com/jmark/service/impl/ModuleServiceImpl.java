package com.jmark.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmark.dao.ModuleDao;
import com.jmark.entity.Module;
import com.jmark.service.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {
	@Resource 
	private ModuleDao moduleDao;
	public List<Module> getAllModules() {
		// TODO Auto-generated method stub
		return moduleDao.getAllModules();
	}

}
