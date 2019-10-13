package com.haiwaibang.api.controller;

import com.haiwaibang.common.exception.TemplateException;
import com.haiwaibang.model.po.CountryDocSource;
import com.haiwaibang.model.po.Project;
import com.haiwaibang.model.po.ProjectDocSource;
import com.haiwaibang.model.po.ProjectImageSource;
import com.haiwaibang.model.service.CountryService;
import com.haiwaibang.model.service.ProjectService;
import com.haiwaibang.model.service.SourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguifeng on 2018/11/13.
 */
@Controller
@Api(value = "项目页面")
public class ProjectController extends AbstractViewController{

	@Autowired
	ProjectService projectService;

	@Autowired
	CountryService countryService;

	@Autowired
	SourceService sourceService;

	@ApiOperation(value = "详情")
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public ModelAndView country(@PathVariable("projectId") int projectId){
		ModelAndView modelAndView = loadCachedModelAndView(new ModelAndView("project/project"));
		Project project = projectService.getProjectById(projectId);
		if(project == null) throw new TemplateException(String.format("项目%d不存在", project));


		List<ProjectImageSource> projectImageSourceList = projectService.getProjectImageSourceByProjectId(projectId);
		List<ProjectDocSource> projectDocSourceList = projectService.getProjectDocSourceByProjectId(projectId);
		List<CountryDocSource> countryDocSourceList = countryService.getCountryDocSourceById(project.getCountryId());

		List<Integer> projectImgList = new ArrayList<>();
		projectImageSourceList.forEach(projectImageSource -> {
			projectImgList.add(projectImageSource.getImageId());
		});
		List<Integer> projectDocList = new ArrayList<>();
		projectDocSourceList.forEach(projectDocSource -> {
			projectDocList.add(projectDocSource.getDocId());
		});
		List<Integer> countryDocList = new ArrayList<>();
		countryDocSourceList.forEach(countryDocSource -> {
			countryDocList.add(countryDocSource.getDocId());
		});

		// 添加资源信息
		modelAndView.addObject("project", project);
		modelAndView.addObject("img", sourceService.getImageList(projectImgList));
		modelAndView.addObject("doc", sourceService.getDocList(projectDocList));
		modelAndView.addObject("country_doc", sourceService.getDocList(countryDocList));

		return modelAndView;
	}
}
