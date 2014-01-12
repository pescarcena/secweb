package com.jmark.security;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmark.entity.Module;
import com.jmark.entity.Role;
import com.jmark.service.ModuleService;
import com.jmark.service.RoleService;



@Transactional
@Service("customInvocationSecurityMetadataSource")
public class CustomInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	 	@Resource
	    private ModuleService resourceService;	    
	    private HashMap<String, Collection<ConfigAttribute>> resourceMap = null;

	    
	    //加入Spring容器时,执行该方法,Load全部的资源与权限的映射信息
	    @PostConstruct
	    public void init() {
	        loadResourceDefine();
	    }

	    //加载全部的资源与权限的映射信息
	    private void loadResourceDefine() {
	    	resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
	    	List<Module> allModules = resourceService.getAllModules();
	        
	    	for(Module module : allModules) {
	    		Collection<ConfigAttribute> attrs = new ArrayList<ConfigAttribute>();
	    		for(Role role : module.getRoles()) {
	    			ConfigAttribute roleConfig = new SecurityConfig(role.getName());
	    			attrs.add(roleConfig);	    			
	    		}
	    		resourceMap.put(module.getAction(), attrs);
	    	}
	    }

	    
	    //返回所请求资源所映射的权限集合
		public Collection<ConfigAttribute> getAttributes(Object object)
				throws IllegalArgumentException {
			// TODO Auto-generated method stub
			   String requestUrl = ((FilterInvocation) object).getRequestUrl();  
		        System.out.println("requestUrl is " + requestUrl);  
		        if(resourceMap == null) {  
		            loadResourceDefine();  
		        }  
		        return resourceMap.get(requestUrl);  
		}
	    
	    
	    public boolean supports(Class<?> arg0) {
	        // TODO Auto-generated method stub
	        return true;
	    }
	 

		public Collection<ConfigAttribute> getAllConfigAttributes() {
			// TODO Auto-generated method stub
			return null;
		}

   
}

