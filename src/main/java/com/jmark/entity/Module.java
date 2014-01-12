package com.jmark.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="tb_module")
public class Module implements Serializable{
	private static final long serialVersionUID = -2400769758495080278L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@ManyToOne(targetEntity=com.jmark.entity.Module.class)
	@JoinColumn(name="parentid")
	private Module parent;              //父结点	
	@Column(name="name")
	private String name;                  //资源名
	@Column(name="type")
	private String type;				  //资源类型：0（目录） 1 （菜单） 2 （按钮）
	@Column(name="priority")
	private Integer priority;			  //排列优先级
	@Column(name="level")
	private Integer level;                //资源层次
	@Column(name="action")
	private String action;                //资源地址
	@Column(name="remark")
	private String remark;				  //备注
	@Column(name="enabled")                
	private Integer enabled;			   //是否可用
	
	@ManyToMany(targetEntity=com.jmark.entity.Role.class,fetch = FetchType.EAGER, mappedBy = "modules")
	private List<Role> roles;
	
	

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Module getParent() {
		return parent;
	}

	public void setParent(Module parent) {
		this.parent = parent;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Role> getRoles() {
		return roles;
	}


	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 	this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Module) {
			Module m = (Module)obj;
			if(m.getId() == this.id) {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}

	
	
}
