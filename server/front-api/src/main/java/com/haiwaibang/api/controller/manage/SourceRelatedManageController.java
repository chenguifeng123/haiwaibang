package com.haiwaibang.api.controller.manage;

import com.haiwaibang.common.web.Result;
import com.haiwaibang.config.SystemConfig;
import com.haiwaibang.model.dto.QueryInfo;
import com.haiwaibang.model.dto.ShowType;
import com.haiwaibang.model.po.CountryDocSource;
import com.haiwaibang.model.po.CountryImageSource;
import com.haiwaibang.model.po.ProjectDocSource;
import com.haiwaibang.model.po.ProjectImageSource;
import com.haiwaibang.model.service.CountryService;
import com.haiwaibang.model.service.ProjectService;
import com.haiwaibang.model.service.manage.CommonDbManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenguifeng on 2018/12/5.
 */
@RestController
@Api(value = "资源关联处理")
@RequestMapping("/manage")
public class SourceRelatedManageController {

	@Autowired
	CommonDbManageService commonDbManageService;

	@Autowired
	CountryService countryService;

	@Autowired
	ProjectService projectService;

	@ApiOperation("国家项目列表")
	@RequestMapping(value = "/countryContinentProject/list", method = RequestMethod.GET)
	public Result listProjectGroupByCountry(){
		return Result.ok(countryService.getCountryProjectTree());
	}

	@ApiOperation("国家列表")
	@RequestMapping(value = "/countryContinent/list", method = RequestMethod.GET)
	public Result listCountry(){
		return Result.ok(countryService.getCountryTree());
	}

	@ApiOperation("项目文档资源列表")
	@RequestMapping(value = "/projectDocSource/list/{projectId}", method = RequestMethod.POST)
	public Result listProjectDocSource(@PathVariable("projectId") int projectId, @RequestBody QueryInfo queryInfo){
		return Result.okWithPage(()-> projectService.listProjectDocSource(projectId), queryInfo);
	}

	@ApiOperation("增加项目文档资源")
	@RequestMapping(value = "/projectDocSource", method = RequestMethod.PUT)
	public Result addProjectDocSource(@RequestBody ProjectDocSource projectDocSource){
		return Result.ok(commonDbManageService.addObject(SystemConfig.ProjectDocSource, projectDocSource));
	}

	@ApiOperation("修改项目文档资源")
	@RequestMapping(value = "/projectDocSource/{id}", method = RequestMethod.POST)
	public Result updateProjectDocSource(@PathVariable("id") int id, @RequestBody ProjectDocSource projectDocSource){
		return Result.ok(commonDbManageService.updateObject(SystemConfig.ProjectDocSource, projectDocSource));
	}

	@ApiOperation("删除项目文档资源")
	@RequestMapping(value = "/projectDocSource/{id}", method = RequestMethod.DELETE)
	public Result deleteProjectDocSource(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.deleteObject(SystemConfig.ProjectDocSource, id));
	}

	@ApiOperation("国家资源列表")
	@RequestMapping(value = "/countryDocSource/list/{countryId}", method = RequestMethod.POST)
	public Result listCountryDocSource(@PathVariable("countryId") int countryId, @RequestBody QueryInfo queryInfo){
		return Result.okWithPage(()-> countryService.listCountryDocSource(countryId), queryInfo);
	}

	@ApiOperation("增加国家文档资源")
	@RequestMapping(value = "/countryDocSource", method = RequestMethod.PUT)
	public Result addCountryDocSource(@RequestBody CountryDocSource countryDocSource){
		return Result.ok(commonDbManageService.addObject(SystemConfig.CountryDocSource, countryDocSource));
	}

	@ApiOperation("修改国家文档资源")
	@RequestMapping(value = "/countryDocSource/{id}", method = RequestMethod.POST)
	public Result updateCountryDocSource(@PathVariable("id") int id, @RequestBody CountryDocSource countryDocSource){
		return Result.ok(commonDbManageService.updateObject(SystemConfig.CountryDocSource, countryDocSource));
	}

	@ApiOperation("删除国家文档资源")
	@RequestMapping(value = "/countryDocSource/{id}", method = RequestMethod.DELETE)
	public Result deleteCountryDocSource(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.deleteObject(SystemConfig.CountryDocSource, id));
	}

	@ApiOperation("国家资源列表")
	@RequestMapping(value = "/countryImageSource/list/{countryId}", method = RequestMethod.POST)
	public Result listCountryImageSource(@PathVariable("countryId") int countryId, @RequestBody QueryInfo queryInfo){
		//return Result.okWithPage(()-> countryService.listCountryImageSource(countryId), queryInfo);
		return Result.okWithPage(()-> countryService.listComplexCountryImageSource(countryId, ShowType.COMPUTER), queryInfo);
	}

	@ApiOperation("增加国家图片资源")
	@RequestMapping(value = "/countryImageSource", method = RequestMethod.PUT)
	public Result addCountryImageSource(@RequestBody CountryImageSource countryImageSource){
		return Result.ok(commonDbManageService.addObject(SystemConfig.CountryImageSource, countryImageSource));
	}

	@ApiOperation("修改国家图片资源")
	@RequestMapping(value = "/countryImageSource/{id}", method = RequestMethod.POST)
	public Result updateCountryImageSource(@PathVariable("id") int id, @RequestBody CountryImageSource countryImageSource){
		return Result.ok(commonDbManageService.updateObject(SystemConfig.CountryImageSource, countryImageSource));
	}

	@ApiOperation("删除国家图片资源")
	@RequestMapping(value = "/countryImageSource/{id}", method = RequestMethod.DELETE)
	public Result deleteCountryImageSource(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.deleteObject(SystemConfig.CountryImageSource, id));
	}

	@ApiOperation("项目图片列表")
	@RequestMapping(value = "/projectImageSource/list/{projectId}", method = RequestMethod.POST)
	public Result listProjectImageSource(@PathVariable("projectId") int projectId, @RequestBody QueryInfo queryInfo){
		//return Result.okWithPage(()-> projectService.listProjectImageSource(projectId), queryInfo);
		return Result.okWithPage(()-> projectService.listComplexProjectImageSource(projectId, ShowType.COMPUTER), queryInfo);
	}

	@ApiOperation("增加项目图片资源")
	@RequestMapping(value = "/projectImageSource", method = RequestMethod.PUT)
	public Result addProjectImageSource(@RequestBody ProjectImageSource projectImageSource){
		return Result.ok(commonDbManageService.addObject(SystemConfig.ProjectImageSource, projectImageSource));
	}

	@ApiOperation("修改项目图片资源")
	@RequestMapping(value = "/projectImageSource/{id}", method = RequestMethod.POST)
	public Result updateProjectImageSource(@PathVariable("id") int id, @RequestBody ProjectImageSource projectImageSource){
		return Result.ok(commonDbManageService.updateObject(SystemConfig.ProjectImageSource, projectImageSource));
	}

	@ApiOperation("删除项目图片资源")
	@RequestMapping(value = "/projectImageSource/{id}", method = RequestMethod.DELETE)
	public Result deleteProjectImageSource(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.deleteObject(SystemConfig.ProjectImageSource, id));
	}

}
