package com.haiwaibang.config;

import com.haiwaibang.model.po.SysRole;
import com.haiwaibang.model.po.multi.ComplexUserRole;
import com.haiwaibang.model.service.user.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by chenguifeng on 2019/2/12.
 */
@Configuration
public class LocalUserServiceMock {

	@ConditionalOnMissingBean(UserService.class)
	//@ConditionalOnMissingClass()
	@Bean
	public UserService mockUserService(){
		UserService userService = mock(UserService.class);

		ComplexUserRole complexUserRole = mock(ComplexUserRole.class);
		when(complexUserRole.getUsername()).thenReturn("admin");
		when(complexUserRole.getPassword()).thenReturn("admin");

		SysRole sysRole = mock(SysRole.class);
		when(sysRole.getName()).thenReturn("ROLE_ADMIN");
		when(complexUserRole.getSysRoles()).thenReturn(Collections.singletonList(sysRole));

		when(userService.getUserByUserName("admin")).thenReturn(complexUserRole);
		return userService;
	}
}
