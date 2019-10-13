package com.haiwaibang.filter;

import com.haiwaibang.common.utils.StringUtils;
import com.haiwaibang.util.JwtTokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by chenguifeng on 2019/1/28.
 * token的校验
 * 该类继承自BasicAuthenticationFilter，在doFilterInternal方法中，
 * 从http头的Authorization 项读取token数据，然后用Jwts包提供的方法校验token的合法性。
 * 如果校验通过，就认为这是一个取得授权的合法请求
 */
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {

	private String[] needAuthenticationUrl;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager){
		super(authenticationManager);
	}


	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, String[] needAuthenticationUrl){
		this(authenticationManager);
		this.needAuthenticationUrl = needAuthenticationUrl;
	}

	/**
	 * 是否放行检测 token
	 * @param header
	 * @param request
	 * @return
	 */
	private boolean passRequest(String header, HttpServletRequest request){
		if(StringUtils.isBlank(header)) return true;
		// 如果是非需鉴权的URL 也一律放行
		if(needAuthenticationUrl != null){
			boolean notNeed = true;
			String current = request.getServletPath();
			for(String url: needAuthenticationUrl){
				if(current.startsWith(url.replace("*", "")))
					notNeed = false;
			}
			return notNeed;
		}
		return false;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		//String header = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
		String header = JwtTokenUtils.readToken(request);

		// 如果请求头中没有Authorization信息则直接放行了
		//if(header == null || !header.startsWith(JwtTokenUtils.TOKEN_PREFIX)){
		if(passRequest(header, request)){
			chain.doFilter(request, response);
			return;
		}

		if(JwtTokenUtils.needRefresh(header)){
			header = JwtTokenUtils.refreshToken(header, response);
		}

		// 如果请求头中有token，则进行解析，并且设置认证信息
		UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(header);

		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		chain.doFilter(request,response);
	}

	/**
	 *这里从token中获取用户信息并新建一个token
	 */
	private UsernamePasswordAuthenticationToken getAuthentication(String header) {

		//String token = header.replace(JwtTokenUtils.TOKEN_PREFIX, "");
		//String principal = JwtTokenUtils.getUsername(token);
		String principal = JwtTokenUtils.getUsername(header);
		List<GrantedAuthority> grantedAuthorities = JwtTokenUtils.getAuthority(header);

		if (principal != null) {
			return new UsernamePasswordAuthenticationToken(principal, null, grantedAuthorities);
		}
		return null;
	}

}
