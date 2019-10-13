package com.haiwaibang.service;

import com.haiwaibang.dto.JwtUser;
import com.haiwaibang.model.po.multi.ComplexUserRole;
import com.haiwaibang.model.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by chenguifeng on 2019/1/28.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserService userService;

	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		ComplexUserRole complexUserRole = userService.getUserByUserName(s);
		if(complexUserRole == null) throw new UsernameNotFoundException(
				String.format("用户名%s不存在", s));
		//return new JwtUser("aaa","bbb", 1, new ArrayList<>());
		return new JwtUser(complexUserRole);
	}
}
