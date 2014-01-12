package com.jmark.security;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//权限拦截器
@Service("customFilterSecurityInterceptor")
@SuppressWarnings("restriction")
public class CustomFilterSecurityInterceptor  extends AbstractSecurityInterceptor implements Filter {

	//资源权限加载
	@Resource
    @Qualifier("customInvocationSecurityMetadataSource")
    private FilterInvocationSecurityMetadataSource securityMetadataSource;
    
	//权限决策器
    @Resource
    @Qualifier("customAccessDecisionManager")
    public void setAccessDecisionManager(
            AccessDecisionManager accessDecisionManager) {
        // TODO Auto-generated method stub
        super.setAccessDecisionManager(accessDecisionManager);
    }

    @Resource
    @Qualifier("authenticationManager")
    public void setAuthenticationManager(AuthenticationManager newManager) {
        super.setAuthenticationManager(newManager);
    }
    
    
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        infoke(fi);

    }

    private void infoke(FilterInvocation fi) throws IOException, ServletException {
        InterceptorStatusToken token = super.beforeInvocation(fi);
        
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
        
    }

	@Override
	public Class<? extends Object> getSecureObjectClass() {
		// TODO Auto-generated method stub
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		// TODO Auto-generated method stub
		return this.securityMetadataSource;
	}

   

  
}
