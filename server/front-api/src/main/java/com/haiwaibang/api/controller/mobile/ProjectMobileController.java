package com.haiwaibang.api.controller.mobile;

import com.haiwaibang.common.web.Result;
import com.haiwaibang.config.SystemConfig;
import com.haiwaibang.model.dto.QueryInfo;
import com.haiwaibang.model.dto.ShowType;
import com.haiwaibang.model.po.ProjectDocSource;
import com.haiwaibang.model.service.ProjectService;
import com.haiwaibang.model.service.SourceService;
import com.haiwaibang.model.service.manage.CommonDbManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguifeng on 2018/12/19.
 */
@RestController
@Api(value = "项目加载")
@RequestMapping(value = "/m")
public class ProjectMobileController {

	@Autowired
	ProjectService projectService;

	@Autowired
	SourceService sourceService;

	@Autowired
	CommonDbManageService commonDbManageService;

/*	@ApiOperation(value = "项目")
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public Result getProjectInfo(@PathVariable int projectId){
		return Result.ok(projectService.getComplexProjectWithImageByProjectId(projectId));
	}*/

	@ApiOperation(value = "项目")
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public Result getProjectInfo(@PathVariable int projectId){
		return Result.ok(commonDbManageService.getObjectById(SystemConfig.Project, projectId));
	}

	@ApiOperation(value = "列出项目下的文档")
	@RequestMapping(value = "/project/doc/list/{projectId}", method = RequestMethod.GET)
	public Result listDocList(@PathVariable int projectId){
		List<ProjectDocSource> projectDocSourceList = projectService.getProjectDocSourceByProjectId(projectId);
		List<Integer> projectDocList = new ArrayList<>();
		projectDocSourceList.forEach(projectDocSource -> {
			projectDocList.add(projectDocSource.getDocId());
		});
		return Result.ok(sourceService.getDocList(projectDocList));
	}

	@ApiOperation("项目图片列表")
	@RequestMapping(value = "/projectImageSource/list/{projectId}", method = RequestMethod.POST)
	public Result listProjectImageSource(@PathVariable("projectId") int projectId, @RequestBody QueryInfo queryInfo){
		//return Result.okWithPage(()-> projectService.listProjectImageSource(projectId), queryInfo);
		return Result.okWithPage(()-> projectService.listComplexProjectImageSource(projectId, ShowType.MOBILE), queryInfo);
	}

}
