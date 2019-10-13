package com.haiwaibang.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.haiwaibang.model.po.SysRole;
import com.haiwaibang.model.po.multi.ComplexUserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by chenguifeng on 2019/1/28.
 */
public class JwtUser implements UserDetails{
	private String username;

	private String password;

	private Integer state;

	private Collection<? extends GrantedAuthority> authorities;

	public JwtUser() {
	}

	public JwtUser(String username, String password, Integer state, Collection<? extends GrantedAuthority> authorities) {
		this.username = username;
		this.password = password;
		this.state = state;
		this.authorities = authorities;
	}

	public JwtUser(ComplexUserRole complexUserRole){
		this(complexUserRole.getUsername(), complexUserRole.getPassword(),
				(int)complexUserRole.getStatus(), null);
		List<GrantedAuthority> authorityList = new ArrayList<>();
		List<SysRole> sysRoles = complexUserRole.getSysRoles();
		if(sysRoles != null){
			sysRoles.forEach(sysRole -> {
				authorityList.add(new SimpleGrantedAuthority(sysRole.getName()));
			});
		}
		this.authorities = authorityList;
	}


	@Override
	public String getUsername() {
		return username;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return state == 1;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}
}
