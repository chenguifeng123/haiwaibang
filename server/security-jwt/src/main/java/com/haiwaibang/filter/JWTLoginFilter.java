package com.haiwaibang.filter;

import com.haiwaibang.common.exception.GlobalSecurityException;
import com.haiwaibang.util.JwtTokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by chenguifeng on 2019/1/28.
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
 * attemptAuthentication ：接收并解析用户凭证。
 * successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JWTLoginFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	/**
	 *接收并解析用户凭证
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
												HttpServletResponse response)
			throws AuthenticationException {
		//从输入流中获取登录信息
		try{
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			//ObjectMapper mapper = new ObjectMapper();
			//AuthenticationBean authenticationBean = mapper.readValue(request.getInputStream() ,AuthenticationBean.class);
			//String username = authenticationBean.getUsername();
			//String password = authenticationBean.getPassword();

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>()));
		}catch (Exception e){
			throw new GlobalSecurityException("用户验证失败", e);
		}
	}

	/**
	 * 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
	 */
	@Override
	public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
											Authentication auth) throws IOException, ServletException {
		//String principal = ((JwtUser)auth.getPrincipal()).getUsername();
		String principal = auth.getPrincipal().toString();

		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		List<String> role = new ArrayList<>();
		authorities.forEach(authority ->{
			role.add(authority.getAuthority());
		});

		String token = JwtTokenUtils.createToken(principal, role, false);
		JwtTokenUtils.saveToken(response, token);
	}

	/**
	 * 这是验证失败时候调用的方法
	 */
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
		response.getWriter().write("authentication failed, reason: " + failed.getMessage());
	}

}
