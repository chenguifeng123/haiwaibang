package com.haiwaibang.api.controller.manage;

import com.haiwaibang.common.web.Result;
import com.haiwaibang.config.SystemConfig;
import com.haiwaibang.model.dto.QueryInfo;
import com.haiwaibang.model.po.Custom;
import com.haiwaibang.model.service.ShowBranchService;
import com.haiwaibang.model.service.manage.CommonDbManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenguifeng on 2018/12/29.
 */
@RestController
@Api(value = "记录用户信息")
@RequestMapping(value = "/manage")
public class CustomController {

	@Autowired
	ShowBranchService showBranchService;

	@Autowired
	CommonDbManageService commonDbManageService;

	@CrossOrigin
	@ApiOperation("用户信息列表")
	@RequestMapping(value = "/custom/list", method = RequestMethod.POST)
	public Result listCustom(@RequestBody QueryInfo queryInfo){
		return Result.okWithPage(()-> showBranchService.listCustom(), queryInfo);
	}

	@CrossOrigin
	@ApiOperation("新增用户信息")
	@RequestMapping(value = "/custom", method = RequestMethod.PUT)
	public Result addCustom(@RequestBody Custom custom){
		return Result.ok(commonDbManageService.addObject(SystemConfig.Custom, custom));
	}

	@CrossOrigin
	@ApiOperation("修改用户信息")
	@RequestMapping(value = "/custom/{id}", method = RequestMethod.POST)
	public Result updateCustom(@PathVariable("id") Integer id, @RequestBody Custom custom){
		return Result.ok(commonDbManageService.updateObject(SystemConfig.Custom, custom));
	}

	@CrossOrigin
	@ApiOperation("删除用户信息")
	@RequestMapping(value = "/custom/{id}", method = RequestMethod.DELETE)
	public Result deleteCustom(@PathVariable("id") Integer id){
		return Result.ok(commonDbManageService.deleteObject(SystemConfig.Custom, id));
	}
}
