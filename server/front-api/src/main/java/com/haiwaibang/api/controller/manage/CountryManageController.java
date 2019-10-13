package com.haiwaibang.api.controller.manage;

import com.haiwaibang.common.web.Result;
import com.haiwaibang.model.dto.QueryInfo;
import com.haiwaibang.model.po.Country;
import com.haiwaibang.model.service.manage.CountryManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenguifeng on 2018/11/16.
 */
@RestController
@Api(value = "具体国家处理")
@RequestMapping("/manage")
public class CountryManageController {

	@Autowired
	CountryManageService countryManageService;

	@ApiOperation("国家列表")
	@RequestMapping(value = "/country/list", method = RequestMethod.POST)
	public Result listCountry(@RequestBody QueryInfo queryInfo){
		return Result.okWithPage(()-> countryManageService.listCountry(), queryInfo);
	}

	@ApiOperation("国家列表")
	@RequestMapping(value = "/country/list", method = RequestMethod.GET)
	public Result listCountry(){
		return Result.ok(countryManageService.listCountry());
	}

	@ApiOperation("新增国家")
	@RequestMapping(value = "/country", method = RequestMethod.PUT)
	public Result addCountry(@RequestBody Country country){
		return Result.ok(countryManageService.addCountry(country));
	}

	@CrossOrigin
	@ApiOperation("修改国家")
	@RequestMapping(value = "/country/{id}", method = RequestMethod.POST)
	public Result updateCountry(@PathVariable("id") String id, @RequestBody Country country){
		return Result.ok(countryManageService.updateCountry(country));
	}

	@ApiOperation("删除国家")
	@RequestMapping(value = "/country/{id}", method = RequestMethod.DELETE)
	public Result deleteCountry(@PathVariable("id") String id){
		return Result.ok(countryManageService.deleteCountry(Integer.parseInt(id)));
	}
}
