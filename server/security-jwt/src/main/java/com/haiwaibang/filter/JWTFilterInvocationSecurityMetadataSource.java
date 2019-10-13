package com.haiwaibang.filter;

import com.haiwaibang.model.po.multi.ComplexPermissionRole;
import com.haiwaibang.model.service.user.PermissionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by chenguifeng on 2019/2/14.
 */
@Component
public class JWTFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	@Autowired
	PermissionService permissionService;

	private ConcurrentHashMap<String, Collection<ConfigAttribute>> permissionMap = null;

	/**
	 * 加载url 到 角色的映射关系
	 */
	@ApiOperation("重新加载权限列表")
	@RequestMapping(value = "/permission/role/reload")
	private void loadPermission(){
		List<ComplexPermissionRole> permissions = permissionService.listComplexPermissionRole();
		if(permissions == null || permissions.size() ==0) return;
		permissionMap = new ConcurrentHashMap<>();
		for(ComplexPermissionRole permission : permissions) {
			final Collection<ConfigAttribute> array = new ArrayList<>();
			//此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。
			// 此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
			permission.getSysRoles().forEach(sysRole -> {
				array.add(new SecurityConfig(sysRole.getName()));
			});
			//用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
			permissionMap.put(permission.getUrl(), array);
		}
	}

	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		synchronized (this) {
			if (permissionMap == null) loadPermission();
		}
		//object 中包含用户请求的request 信息
		HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
		AntPathRequestMatcher matcher;
		String resUrl;
		for(Iterator<String> iter = permissionMap.keySet().iterator(); iter.hasNext(); ) {
			resUrl = iter.next();
			matcher = new AntPathRequestMatcher(resUrl);
			if(matcher.matches(request)) {
				return permissionMap.get(resUrl);
			}
		}
		return null;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> aClass) {
		return true;
	}
}
