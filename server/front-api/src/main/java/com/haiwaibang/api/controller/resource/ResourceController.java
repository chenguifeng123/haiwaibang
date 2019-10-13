package com.haiwaibang.api.controller.resource;

import com.haiwaibang.api.controller.AbstractViewController;
import com.haiwaibang.model.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chenguifeng on 2019/1/30.
 */
@Controller
@Api(value = "资源请求")
@RequestMapping(value = "/resource/")
public class ResourceController extends AbstractViewController{

	@Autowired
	ProjectService projectService;

	@ApiOperation(value = "国家")
	@RequestMapping(value = "/resource", method = RequestMethod.GET)
	public ModelAndView resource(){
		ModelAndView modelAndView = loadCachedModelAndView(new ModelAndView("/resource/resource"));
		return modelAndView;
	}
}
