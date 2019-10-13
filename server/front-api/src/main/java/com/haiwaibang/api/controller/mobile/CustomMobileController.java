package com.haiwaibang.api.controller.mobile;

import com.haiwaibang.common.web.Result;
import com.haiwaibang.config.SystemConfig;
import com.haiwaibang.model.po.Custom;
import com.haiwaibang.model.service.manage.CommonDbManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenguifeng on 2018/12/30.
 */
@RestController
@Api(value = "记录用户信息")
@RequestMapping(value = "/m")
public class CustomMobileController {

	@Autowired
	CommonDbManageService commonDbManageService;

	@CrossOrigin
	@ApiOperation("新增用户信息")
	@RequestMapping(value = "/custom", method = RequestMethod.PUT)
	public Result addCustom(@RequestBody Custom custom){
		return Result.ok(commonDbManageService.addObject(SystemConfig.Custom, custom));
	}

}
