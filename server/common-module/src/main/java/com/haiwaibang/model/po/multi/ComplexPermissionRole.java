package com.haiwaibang.model.po.multi;

import com.haiwaibang.model.po.SysRole;

import java.util.List;

/**
 * Created by chenguifeng on 2019/2/14.
 */
public class ComplexPermissionRole {

	private Long id;
	private String name;
	private String url;
	private List<SysRole> sysRoles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<SysRole> getSysRoles() {
		return sysRoles;
	}

	public void setSysRoles(List<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}
}
