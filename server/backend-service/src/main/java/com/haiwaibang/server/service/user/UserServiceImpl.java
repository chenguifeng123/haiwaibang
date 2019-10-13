package com.haiwaibang.server.service.user;

import com.haiwaibang.model.po.SysRole;
import com.haiwaibang.model.po.SysRoleUser;
import com.haiwaibang.model.po.SysRoleUserExample;
import com.haiwaibang.model.po.SysUser;
import com.haiwaibang.model.po.multi.ComplexUserRole;
import com.haiwaibang.model.service.user.UserService;
import com.haiwaibang.server.dao.SysRoleUserMapper;
import com.haiwaibang.server.dao.SysUserMapper;
import com.haiwaibang.server.dao.multi.ComplexUserRoleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenguifeng on 2019/2/1.
 */
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	SysUserMapper sysUserMapper;

	@Autowired
	SysRoleUserMapper sysRoleUserMapper;

	@Autowired
	ComplexUserRoleMapper complexUserRoleMapper;

	private SysUser getSysUser(ComplexUserRole complexUserRole){
		SysUser sysUser = new SysUser();
		BeanUtils.copyProperties(complexUserRole, sysUser);
		return sysUser;
	}

	private int addSysRoleUser(ComplexUserRole complexUserRole){
		for(SysRole sysRole : complexUserRole.getSysRoles()){
			SysRoleUser sysRoleUser = new SysRoleUser();
			sysRoleUser.setSysRoleId(sysRole.getId());
			sysRoleUser.setSysUserId((long)complexUserRole.getId());
			sysRoleUserMapper.insert(sysRoleUser);
		}
		return 1;
	}

	private int deleteSysRoleUser(int userId){
		SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
		SysRoleUserExample.Criteria criteria = sysRoleUserExample.createCriteria();
		criteria.andSysUserIdEqualTo((long)userId);
		return sysRoleUserMapper.deleteByExample(sysRoleUserExample);
	}

	public List<ComplexUserRole> listComplexUserRole() {
		return complexUserRoleMapper.listComplexUserRole();
	}

	public ComplexUserRole getUserByUserId(int userId) {
		return complexUserRoleMapper.getUserByUserId(userId);
	}

	public ComplexUserRole getUserByUserName(String userName) {
		return complexUserRoleMapper.getUserByUserName(userName);
	}

	public int addUserAndRole(ComplexUserRole complexUserRole) {
		SysUser sysUser = getSysUser(complexUserRole);
		complexUserRole.setId(sysUserMapper.insert(sysUser));
		return addSysRoleUser(complexUserRole);
	}

	public int updateUserAndRole(ComplexUserRole complexUserRole) {
		SysUser sysUser = getSysUser(complexUserRole);
		sysUserMapper.updateByPrimaryKey(sysUser);
		deleteSysRoleUser(complexUserRole.getId());
		return addSysRoleUser(complexUserRole);
	}

	public int deleteUserAndRole(int userId) {
		return deleteSysRoleUser(userId);
	}
}
