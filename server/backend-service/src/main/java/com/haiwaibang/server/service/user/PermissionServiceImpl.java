package com.haiwaibang.server.service.user;

import com.haiwaibang.model.po.*;
import com.haiwaibang.model.po.multi.ComplexPermissionRole;
import com.haiwaibang.model.po.multi.ComplexRolePermission;
import com.haiwaibang.model.service.user.PermissionService;
import com.haiwaibang.server.dao.SysPermissionRoleMapper;
import com.haiwaibang.server.dao.SysRoleMapper;
import com.haiwaibang.server.dao.multi.ComplexRolePermissionMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenguifeng on 2019/2/14.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	SysRoleMapper sysRoleMapper;

	@Autowired
	SysPermissionRoleMapper sysPermissionRoleMapper;

	@Autowired
	ComplexRolePermissionMapper complexRolePermissionMapper;

	private SysRole getSysRole(ComplexRolePermission complexRolePermission){
		SysRole sysRole = new SysRole();
		BeanUtils.copyProperties(complexRolePermission, sysRole);
		return sysRole;
	}

	private int addSysRolePermission(ComplexRolePermission complexRolePermission){
		for(SysPermission sysPermission : complexRolePermission.getSysPermissions()){
			SysPermissionRole sysPermissionRole = new SysPermissionRole();
			sysPermissionRole.setRoleId(complexRolePermission.getId());
			sysPermissionRole.setPermissionId((long)sysPermissionRole.getId());
			sysPermissionRoleMapper.insert(sysPermissionRole);
		}
		return 1;
	}

	private int deleteSysRolePermission(long roleId){
		SysPermissionRoleExample sysPermissionRoleExample = new SysPermissionRoleExample();
		SysPermissionRoleExample.Criteria criteria = sysPermissionRoleExample.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		return sysPermissionRoleMapper.deleteByExample(sysPermissionRoleExample);
	}

	public List<ComplexRolePermission> listComplexRolePermission() {
		return complexRolePermissionMapper.listComplexRolePermission();
	}

	public List<ComplexRolePermission> getPermissionByRoleId(int roleId) {
		return complexRolePermissionMapper.getPermissionByRoleId(roleId);
	}

	public List<ComplexRolePermission> getPermissionByRoleName(String roleName) {
		return complexRolePermissionMapper.getPermissionByRoleName(roleName);
	}

	public List<ComplexRolePermission> getRolePermissionByUrl(String url) {
		return complexRolePermissionMapper.getRolePermissionByUrl(url);
	}

	public List<ComplexPermissionRole> listComplexPermissionRole() {
		return complexRolePermissionMapper.listComplexPermissionRole();
	}

	public List<ComplexPermissionRole> getPermissionRoleByUrl(String url) {
		return complexRolePermissionMapper.getPermissionRoleByUrl(url);
	}

	public int addRolePermission(ComplexRolePermission complexRolePermission) {
		SysRole sysRole = getSysRole(complexRolePermission);
		complexRolePermission.setId((long)sysRoleMapper.insert(sysRole));
		return addSysRolePermission(complexRolePermission);
	}

	public int updateRolePermission(ComplexRolePermission complexRolePermission) {
		SysRole sysRole = getSysRole(complexRolePermission);
		sysRoleMapper.updateByPrimaryKey(sysRole);
		deleteSysRolePermission(complexRolePermission.getId());
		return addSysRolePermission(complexRolePermission);
	}

	public int deleteRolePermission(int roleId) {
		return deleteSysRolePermission(roleId);
	}
}
