package com.haiwaibang.api.controller.resource;

import com.haiwaibang.api.controller.AbstractViewController;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chenguifeng on 2019/2/1.
 */
@Controller
@RequestMapping(value = "/corporation")
public class CorporationController extends AbstractViewController {

	@ApiOperation(value = "国家")
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView resource(){
		ModelAndView modelAndView = loadCachedModelAndView(new ModelAndView("/corporation/success"));
		return modelAndView;
	}
}
