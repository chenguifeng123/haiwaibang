package com.haiwaibang.config;

import com.haiwaibang.filter.JWTAuthenticationEntryPoint;
import com.haiwaibang.filter.JWTAuthenticationFilter;
import com.haiwaibang.filter.JWTLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by chenguifeng on 2019/1/28.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${security.basic.path}")
	String[] path;

	@Autowired
	@Qualifier("userDetailsServiceImpl")
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationProvider authenticationProvider;// 自定义的AuthenticationProvider

	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
/*
		http.cors().and().csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.GET,"/hello/hello").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.and()
				.logout()
				.and()
				.addFilter(new JWTLoginFilter(authenticationManager()))
				.addFilter(new JWTAuthenticationFilter(authenticationManager()));*/


		http.cors().and().csrf().disable()
				.authorizeRequests()
				// 测试用资源，需要验证了的用户才能访问
				//.antMatchers("/resource/**").authenticated()
				.antMatchers(path).authenticated()
				// 其他都放行了
				.anyRequest().permitAll()
				.and().headers().frameOptions().disable()
				.and()
				.addFilter(new JWTLoginFilter(authenticationManager()))
				.addFilter(new JWTAuthenticationFilter(authenticationManager(), path))
				// 不需要session
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.exceptionHandling().authenticationEntryPoint(new JWTAuthenticationEntryPoint()).
				and()
				.exceptionHandling().accessDeniedPage("/403.html");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
}

