package com.haiwaibang.api.controller;

import com.haiwaibang.common.exception.TemplateException;
import com.haiwaibang.model.po.Country;
import com.haiwaibang.model.po.Project;
import com.haiwaibang.model.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/11.
 */
@Controller
@Api(value = "具体国家处理")
public class CountryController extends AbstractViewController{

	@Autowired
	ProjectService projectService;

	@ApiOperation(value = "国家")
	@RequestMapping(value = "/country/{countryName}", method = RequestMethod.GET)
	public ModelAndView country(@PathVariable String countryName){
		ModelAndView modelAndView = loadCachedModelAndView(new ModelAndView("/project/country"));

		Country country = countryService.getCountryByName(countryName);
		if(country == null) throw new TemplateException(String.format("国家%s不存在", countryName));
		List<Project> projectList = projectService.getAllProjectByCountryId(country.getId());

		modelAndView.addObject("country", country);
		modelAndView.addObject("project", projectList);
		return modelAndView;
	}


}
