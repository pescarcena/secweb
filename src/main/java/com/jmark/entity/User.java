package com.jmark.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name="tb_user")
public class User implements UserDetails,Serializable{
	
	private static final long serialVersionUID = -2400769758495080278L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	// ===========以下属性为安全架构属性==================  //
	@Column(name="username")
	private String username; 						//帐号 
	@Column(name="password")
	private String password;  						//密码
	@Column(name="enabled")
	private boolean enabled = true;         		// 是否可用
	@Transient
	private boolean accountNonExpired = true; 		// 账号是否过期
	@Transient
	private boolean accountNonLocked = true; 		// 账号是否锁定
	@Transient
	private boolean credentialsNonExpired = true; 	//  帐号凭证是否过期
	@Transient
	private Collection<GrantedAuthority> authorities; 	// UserDetails的角色名属性集合
	// =============================================  //
	
	@Column(name="remark")
	private String remark;                                //备注
	@ManyToMany(targetEntity=com.jmark.entity.Role.class,fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tb_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })	
	private List<Role> roles = new ArrayList<Role>();        //角色

	
	
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

	
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAuthorities(
			Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	
}

