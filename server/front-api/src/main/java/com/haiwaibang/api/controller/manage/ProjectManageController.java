package com.haiwaibang.api.controller.manage;

import com.haiwaibang.common.web.Result;
import com.haiwaibang.model.dto.QueryInfo;
import com.haiwaibang.model.po.Project;
import com.haiwaibang.model.service.manage.ProjectManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenguifeng on 2018/11/23.
 */
@RestController
@Api(value = "具体项目处理")
@RequestMapping("/manage")
public class ProjectManageController {

	@Autowired
	ProjectManageService projectManageService;

	@ApiOperation("项目列表")
	@RequestMapping(value = "/project/list", method = RequestMethod.POST)
	public Result listProgram(@RequestBody QueryInfo queryInfo){
		return Result.okWithPage(()-> projectManageService.listProject(queryInfo), queryInfo);
	}

	@ApiOperation("国家列表")
	@RequestMapping(value = "/project/list", method = RequestMethod.GET)
	public Result listProgram(){
		return Result.ok(projectManageService.listProject());
	}


	@ApiOperation("新增项目")
	@RequestMapping(value = "/project", method = RequestMethod.PUT)
	public Result addProgram(@RequestBody Project project){
		return Result.ok(projectManageService.addProject(project));
	}

	@CrossOrigin
	@ApiOperation("修改项目")
	@RequestMapping(value = "/project/{id}", method = RequestMethod.POST)
	public Result updateProgram(@PathVariable("id") String id, @RequestBody Project project){
		return Result.ok(projectManageService.updateProject(project));
	}

	@ApiOperation("删除项目")
	@RequestMapping(value = "/project/{id}", method = RequestMethod.DELETE)
	public Result deleteProgram(@PathVariable("id") String id){
		return Result.ok(projectManageService.deleteProject(Integer.parseInt(id)));
	}
}
