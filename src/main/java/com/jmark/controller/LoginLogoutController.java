package com.jmark.controller;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jmark.entity.Module;
import com.jmark.entity.User;
import com.jmark.service.RoleService;

@Controller
public class LoginLogoutController extends BaseController {
	
	@Resource private RoleService roleService;
	@RequestMapping(method=RequestMethod.GET,value="/login.do")
	public void login() {
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/index.do")
	public void index(ModelMap map) {
		Set<Module> set = new HashSet<Module>(); 
		User userDetails = (User) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		
		for(GrantedAuthority ga : userDetails.getAuthorities()) {
			System.out.println(ga.getAuthority());
			set.addAll(roleService.findModulesByRoleName(ga.getAuthority()));
		}
		map.put("list", set);
//		System.out.println(set);
//		for(Module m : set) {
//			System.out.println(m.getParent().getId());
//		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/home.do")
	public void home() {
		
	}
}
