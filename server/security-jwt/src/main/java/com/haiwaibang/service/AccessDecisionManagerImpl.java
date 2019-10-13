package com.haiwaibang.service;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by chenguifeng on 2019/2/13.
 */
@Service
public class AccessDecisionManagerImpl implements AccessDecisionManager {

	/**
	 * 判定是否拥有权限的决策方法
	 * @param authentication UserService中添加到 GrantedAuthority 对象中的权限信息集合
	 * @param o 客户端发起的请求的requset信息，可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
	 * @param configAttributes 为 InvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，
	 *                         此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。
	 *                         如果不在权限表中则放行。
	 * @throws AccessDeniedException
	 * @throws InsufficientAuthenticationException
	 */
	public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if(null == configAttributes || configAttributes.size() <= 0) {
			return;
		}
/*		HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
		// 如果是默认用户
		if ("anonymousUser".equals(authentication.getPrincipal())){
		}*/
		for(Iterator<ConfigAttribute> iterator = configAttributes.iterator(); iterator.hasNext(); ) {
			ConfigAttribute c = iterator.next();
			String needRole = c.getAttribute();
			for(GrantedAuthority ga : authentication.getAuthorities()) {//authentication 为在注释1 中循环添加到 GrantedAuthority 对象中的权限信息集合
				if(needRole.trim().equals(ga.getAuthority())) {
					return;
				}
			}
		}
		throw new AccessDeniedException("没有权限访问");
	}

	public boolean supports(ConfigAttribute configAttribute) {
		return true;
	}

	public boolean supports(Class<?> aClass) {
		return true;
	}

}
