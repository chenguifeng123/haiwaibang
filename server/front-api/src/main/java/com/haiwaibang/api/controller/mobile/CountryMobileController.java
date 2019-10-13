package com.haiwaibang.api.controller.mobile;

import com.haiwaibang.common.web.Result;
import com.haiwaibang.model.dto.QueryInfo;
import com.haiwaibang.model.dto.ShowType;
import com.haiwaibang.model.po.CountryDocSource;
import com.haiwaibang.model.service.CountryService;
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
 * Created by chenguifeng on 2018/12/18.
 */
@RestController
@Api(value = "国家加载")
@RequestMapping(value = "/m")
public class CountryMobileController {

	@Autowired
	CountryService countryService;

	@Autowired
	ProjectService projectService;

	@Autowired
	SourceService sourceService;

	@Autowired
	CommonDbManageService commonDbManageService;

	@ApiOperation("国家列表")
	@RequestMapping(value = "/countryWithImage/list", method = RequestMethod.GET)
	public Result listCountryWithImage(){
		return Result.ok(countryService.listComplexCountryWithImage());
	}

	@ApiOperation(value = "列出国家下的项目")
	@RequestMapping(value = "/country/list/{countryId}", method = RequestMethod.GET)
	public Result listProject(@PathVariable int countryId){
		return Result.ok(projectService.listComplexProjectWithImage(countryId));
	}

/*	@ApiOperation(value = "列出国家")
	@RequestMapping(value = "/country/{countryId}", method = RequestMethod.GET)
	public Result getCountry(@PathVariable int countryId){
		return Result.ok(commonDbManageService.getObjectById(SystemConfig.Country, countryId));
	}*/

	@ApiOperation(value = "列出国家")
	@RequestMapping(value = "/country/{countryId}", method = RequestMethod.GET)
	public Result getCountry(@PathVariable int countryId){
		return Result.ok(countryService.getComplexCountryWithImageByCountryId(countryId));
	}

	@ApiOperation(value = "列出国家下的文档")
	@RequestMapping(value = "/country/doc/list/{countryId}", method = RequestMethod.GET)
	public Result listDocList(@PathVariable int countryId){
		List<CountryDocSource> countryDocSourceList = countryService.getCountryDocSourceById(countryId);
		List<Integer> countryDocList = new ArrayList<>();
		countryDocSourceList.forEach(countryDocSource -> {
			countryDocList.add(countryDocSource.getDocId());
		});
		return Result.ok(sourceService.getDocList(countryDocList));
	}

	@ApiOperation("国家资源列表")
	@RequestMapping(value = "/countryImageSource/list/{countryId}", method = RequestMethod.POST)
	public Result listCountryImageSource(@PathVariable("countryId") int countryId, @RequestBody QueryInfo queryInfo){
		//return Result.okWithPage(()-> countryService.listCountryImageSource(countryId), queryInfo);
		return Result.okWithPage(()-> countryService.listComplexCountryImageSource(countryId, ShowType.MOBILE), queryInfo);
	}

}
