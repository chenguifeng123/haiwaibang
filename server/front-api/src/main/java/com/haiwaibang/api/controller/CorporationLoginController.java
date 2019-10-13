package com.haiwaibang.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chenguifeng on 2019/1/30.
 */
@Controller
@Api(value = "登陆加载")
public class CorporationLoginController extends AbstractViewController{

	@ApiOperation(value = "登陆")
	@RequestMapping(value = "/corporation/login", method = RequestMethod.GET)
	public ModelAndView home(){
		return loadCachedModelAndView(new ModelAndView("corporation/login"));
	}
}
