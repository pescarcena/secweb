package com.jmark.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jmark.entity.Role;
import com.jmark.entity.User;
import com.jmark.service.UserService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
    private static final long serialVersionUID = 1L;
 
    @Resource
    private UserService UserService;
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    	System.out.println(username);
    	User user = UserService.getUserByName(username);  
    	
        if (null == user) {
            throw new UsernameNotFoundException("用户:" + username + "未找到");
        } 
        
        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        List<Role> roles = user.getRoles();
        for (int i = 0; i < roles.size(); i++) {
            auths.add(new GrantedAuthorityImpl(roles.get(i).getName()));
        }       
        user.setAuthorities(auths);
        
        return user;      
    }

}
