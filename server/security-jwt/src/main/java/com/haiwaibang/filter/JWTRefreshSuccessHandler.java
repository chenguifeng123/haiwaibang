package com.haiwaibang.filter;

import com.haiwaibang.util.JwtTokenUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chenguifeng on 2019/1/30.
 */
public class JWTRefreshSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
		String header = httpServletRequest.getHeader(JwtTokenUtils.TOKEN_HEADER);
		String token = header.replace(JwtTokenUtils.TOKEN_PREFIX, "");

		if(JwtTokenUtils.needRefresh(token)) {
			String newToken = JwtTokenUtils.refreshToken(token, httpServletResponse);
			JwtTokenUtils.saveToken(httpServletResponse, newToken);
		}
	}

}
