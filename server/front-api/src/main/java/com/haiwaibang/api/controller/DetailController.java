package com.haiwaibang.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chenguifeng on 2018/11/11.
 */
@Controller
@Api(value = "")
public class DetailController extends AbstractViewController{

	@ApiOperation(value = "详情")
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView country(@RequestParam("url") String url){
		return loadCachedModelAndView(new ModelAndView("/project/detail")).addObject("url", url);
	}
}
