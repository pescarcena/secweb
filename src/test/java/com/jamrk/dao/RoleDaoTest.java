package com.jamrk.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmark.dao.RoleDao;
import com.jmark.entity.Module;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/resources/application-resources.xml")
//@ContextConfiguration(locations = {"classpath:application-resources.xml","classpath:application-security.xml"})
public class RoleDaoTest {

	@Resource RoleDao roleDao;
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void findModulesByRoleName() {
//		for(Module m : roleDao.findModulesByRoleName("ROLE_SUPERADMIN")) {
//			System.out.println(m.getParent());
//		}	
		List<Module> admin = roleDao.findModulesByRoleName("ROLE_SUPERADMIN");
		List<Module> user = roleDao.findModulesByRoleName("ROLE_USER");
		Set<Module> set = new HashSet<Module>();
		set.addAll(admin);
		set.addAll(user);
		for(Module m : admin) {
			System.out.println(m.getName());
		}
		System.out.println("+++++++");
		for(Module m : user) {
			System.out.println(m.getName());
		}
		System.out.println("+++++++");
		for(Module m : set) {
			System.out.println(m.getName());
		}
	}

	
}
