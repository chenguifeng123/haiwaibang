package com.haiwaibang.model.po.multi;

import com.haiwaibang.model.po.SysPermission;
import java.util.List;

/**
 * Created by chenguifeng on 2019/2/2.
 */
public class ComplexRolePermission {

	private Long id;
	private String roleName;
	private List<SysPermission> sysPermissions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<SysPermission> getSysPermissions() {
		return sysPermissions;
	}

	public void setSysPermissions(List<SysPermission> sysPermissions) {
		this.sysPermissions = sysPermissions;
	}
}
