package com.haiwaibang.model.service.user;

import com.haiwaibang.model.po.multi.ComplexUserRole;

import java.util.List;

/**
 * Created by chenguifeng on 2019/2/1.
 */
public interface UserService {
	List<ComplexUserRole> listComplexUserRole();
	ComplexUserRole getUserByUserId(int userId);
	ComplexUserRole getUserByUserName(String userName);

	int addUserAndRole(ComplexUserRole complexUserRole);
	int updateUserAndRole(ComplexUserRole complexUserRole);
	int deleteUserAndRole(int userId);
}
