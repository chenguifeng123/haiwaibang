package com.haiwaibang.util;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.haiwaibang.common.utils.LoggerUtils;
import com.haiwaibang.common.utils.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chenguifeng on 2019/1/28.
 */
public class JwtTokenUtils{

	public static final String TOKEN_HEADER = "Authorization";

	public static final String TOKEN_PREFIX = "Bearer ";

	public static final String COOKIE_HEADER = "Set-Cookie";

	public static final String TOKEN_COOKIE_KEY = "access_token";

	public static final String TOKEN_ROLE_KEY = "role";

	private static final String SECRET = "jwtsecret";

	/**
	 * 签发者
	 */
	private static final String ISS = "haiwaibang";

	/**
	 * 过期时间是3600秒，既是1个小时
	 */
	private static final long EXPIRATION = 3600L;


	private static final long REFRESH = 600L;

	/**
	 * 选择了记住我之后的过期时间为7天
	 */
	private static final long EXPIRATION_REMEMBER = 604800L;



	/**
	 * 创建token
	 * @param username
	 * @param isRememberMe
	 * @return
	 */
	public static String createToken(String username, List<String> role, boolean isRememberMe) {
		long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
		HashMap<String, Object> claims = new HashMap<String, Object>(){{
			put(TOKEN_ROLE_KEY, role);
		}};
		String token = Jwts.builder()
				.signWith(SignatureAlgorithm.HS512, SECRET)
				.setClaims(claims)
				.setIssuer(ISS)
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
				.compact();
		return token;
	}

	/**
	 * 从token中获取用户名
	 * @param token
	 * @return
	 */
	public static String getUsername(String token){
		return getTokenBody(token).getSubject();
	}

	/**
	 * 获取角色
	 * @param token
	 * @return
	 */
	public static List<String> getRole(String token){
		return (List<String>)getTokenBody(token).get(TOKEN_ROLE_KEY);
	}

	/**
	 * token文本和数据类型互转
	 * @param roles
	 * @return
	 */
	public static List<GrantedAuthority> roleString2Authority(List<String> roles){
		return Lists.transform(roles, new Function<String, GrantedAuthority>(){
			public GrantedAuthority apply(String s) {
				return new SimpleGrantedAuthority(s);
			}
		});
	}

	/**
	 * token文本和数据类型互转
	 * @param grantedAuthorities
	 * @return
	 */
	public static List<String> authority2RoleString(List<GrantedAuthority> grantedAuthorities){
		return Lists.transform(grantedAuthorities, new Function<GrantedAuthority, String>(){
			public String apply(GrantedAuthority grantedAuthority) {
				return grantedAuthority.getAuthority();
			}
		});
	}

	/**
	 * 获取角色
	 * @param token
	 * @return
	 */
	public static List<GrantedAuthority> getAuthority(String token){
		return roleString2Authority(getRole(token));
	}
	/**
	 * 判断是否已过期
	 * @param token
	 * @return
	 */
	public static boolean isExpiration(String token){
		return getTokenBody(token).getExpiration().before(new Date());
	}

	/**
	 * 判断是否需要刷新
	 * @param token
	 * @return
	 */
	public static boolean needRefresh(String token){
		Date issue = getTokenBody(token).getIssuedAt();
		LocalDateTime issueTime = LocalDateTime.ofInstant(issue.toInstant(), ZoneId.systemDefault());
		return LocalDateTime.now().minusSeconds(REFRESH).isAfter(issueTime);
	}

	/**
	 * 刷新token
	 * @param token
	 * @return
	 */
	public static String refreshToken(String token, HttpServletResponse response){
		String username = getUsername(token);
		List<String> role = getRole(token);
		String newToken = createToken(username, role, false);
		saveToken(response, newToken);
		return newToken;
	}

	/**
	 * 获取token体
	 * @param token
	 * @return
	 */
	private static Claims getTokenBody(String token){
		return Jwts.parser()
				.setSigningKey(SECRET)
				.parseClaimsJws(token)
				.getBody();
	}

	/**
	 * 保存token
	 * @param response
	 * @param token
	 */
	public static void saveToken(HttpServletResponse response, String token){
		LoggerUtils.info(JwtTokenUtils.class, String.format("token=%s", token));
		response.addHeader(TOKEN_HEADER, TOKEN_PREFIX + token);
		String cookie = String.format("%s=%s; Secure; HttpOnly;", TOKEN_COOKIE_KEY, token);
		response.addHeader(COOKIE_HEADER, cookie);
		response.addCookie(new Cookie(TOKEN_COOKIE_KEY, token));
	}

	/**
	 * 读取token
	 * @param request
	 * @return
	 */
	public static String readToken(HttpServletRequest request){
		String header = request.getHeader(TOKEN_HEADER);
		if(StringUtils.isNotBlank(header)) {
			return header.replace(JwtTokenUtils.TOKEN_PREFIX, "");
		}
		if(request.getCookies() != null)
			for(Cookie cookie : request.getCookies()){
				if(TOKEN_COOKIE_KEY.equals(cookie.getName()))
					return cookie.getValue();
			}
		return null;
	}
}
