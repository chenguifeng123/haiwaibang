package com.haiwaibang.web;

import com.haiwaibang.common.web.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

/**
 * Created by chenguifeng on 2018/11/8.
 */
@RestController
@Api(value = "登陆")
@RequestMapping(value = "/manage")
public class LoginController {

	private static final String FIXED_USER = "admin";
	private static final String FIXED_PASSWORD = "admin123";

	@ApiOperation(value = "登陆")
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result login(@Valid @RequestBody VueLoginInfoVo loginInfoVo, HttpSession httpSession, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			String message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
			return Result.error(message);
		}
		if (!Objects.equals(FIXED_USER, loginInfoVo.getUsername()) || !Objects.equals(FIXED_PASSWORD, loginInfoVo.getPassword())) {
			String message = String.format("登陆失败，详细信息[用户名、密码信息不正确]。");
			return Result.error(message);
		}
		httpSession.setAttribute(LoginFilter.SESSION_KEY, FIXED_USER);
		return Result.ok();
	}


	@CrossOrigin
	@RequestMapping(value = "/test")
	public Result test(){
		return Result.ok();
	}

	@ApiOperation(value = "登出")
	@RequestMapping(value = "/logout" , method = RequestMethod.GET)
	public String loginOut(HttpSession httpSession){
		httpSession.removeAttribute(LoginFilter.SESSION_KEY);
		return String.format("redirect:%s", LoginFilter.LOGIN);
	}
}
