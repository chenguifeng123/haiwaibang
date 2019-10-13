package com.haiwaibang.server.dao.multi;

import com.haiwaibang.model.po.multi.ComplexPermissionRole;
import com.haiwaibang.model.po.multi.ComplexRolePermission;
import java.util.List;

/**
 * Created by chenguifeng on 2019/2/2.
 */
public interface ComplexRolePermissionMapper {

	List<ComplexRolePermission> listComplexRolePermission();
	List<ComplexRolePermission> getPermissionByRoleId(int roleId);
	List<ComplexRolePermission> getPermissionByRoleName(String roleName);
	List<ComplexRolePermission> getRolePermissionByUrl(String url);

	List<ComplexPermissionRole> listComplexPermissionRole();
	List<ComplexPermissionRole> getPermissionRoleByUrl(String url);
}
