package com.haiwaibang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by chenguifeng on 2019/1/29.
 * 如果不提供，默认是 DaoAuthenticationProvider
 */
@Service
public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		UserDetails user = userDetailsService.loadUserByUsername(username);
		if(user.getPassword().equals(password)) {
			return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}
}
