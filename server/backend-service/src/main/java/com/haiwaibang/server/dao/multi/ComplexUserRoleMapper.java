package com.haiwaibang.server.dao.multi;

import com.haiwaibang.model.po.multi.ComplexUserRole;

import java.util.List;

/**
 * Created by chenguifeng on 2019/2/2.
 */
public interface ComplexUserRoleMapper {

	List<ComplexUserRole> listComplexUserRole();
	ComplexUserRole getUserByUserId(int userId);
	ComplexUserRole getUserByUserName(String userName);
}
