package com.haiwaibang.api.controller.mobile;

import com.haiwaibang.common.ServiceHelper;
import com.haiwaibang.common.web.Result;
import com.haiwaibang.config.SystemConfig;
import com.haiwaibang.model.dto.QueryInfo;
import com.haiwaibang.model.dto.ShowType;
import com.haiwaibang.model.service.ShowBranchService;
import com.haiwaibang.model.service.manage.CommonDbManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenguifeng on 2018/12/17.
 */
@RestController
@Api(value = "首页加载")
@RequestMapping(value = "/m")
public class HomeMobileController {

	@Autowired
	ShowBranchService showBranchService;

	@Autowired
	CommonDbManageService commonDbManageService;

	@ApiOperation("广告栏列表")
	@RequestMapping(value = "/banner/list", method = RequestMethod.GET)
	public Result listBanner(){
		return Result.ok(showBranchService.listBanner(ShowType.MOBILE));
	}

	@ApiOperation("广告栏列表")
	@RequestMapping(value = "/banner/list", method = RequestMethod.POST)
	public Result listBannerByPage(@RequestBody QueryInfo queryInfo){
		return Result.okWithPage(()->showBranchService.listBanner(ShowType.MOBILE), queryInfo);
	}

	@ApiOperation("热门列表")
	@RequestMapping(value = "/hotCountry/list", method = RequestMethod.GET)
	public Result listHotCountry(){
		return Result.ok(showBranchService.listHotCountry(ShowType.MOBILE));
	}

	@ApiOperation("文章列表")
	@RequestMapping(value = "/article/list", method = RequestMethod.GET)
	public Result listArticle(){
		return Result.okWithPage( () -> showBranchService.listArticle(),
				ServiceHelper.getQueryListByPage());
	}

	@ApiOperation("文章列表")
	@RequestMapping(value = "/article/list", method = RequestMethod.POST)
	public Result listArticleByPage(@RequestBody QueryInfo queryInfo){
		return Result.okWithPage( () -> showBranchService.listArticle(), queryInfo);
	}

	@ApiOperation("获取文章")
	@RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
	public Result getArticle(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.getObjectById(SystemConfig.Article, id));
	}

	@ApiOperation("案例列表")
	@RequestMapping(value = "/example/list", method = RequestMethod.GET)
	public Result listExample(){
		return Result.okWithPage( () -> showBranchService.listExample(),
				ServiceHelper.getQueryListByPage());
	}

	@ApiOperation("案例列表")
	@RequestMapping(value = "/example/list", method = RequestMethod.POST)
	public Result listExampleByPage(@RequestBody QueryInfo queryInfo){
		return Result.okWithPage( () -> showBranchService.listExample(), queryInfo);
	}

	@ApiOperation("获取案例")
	@RequestMapping(value = "/example/{id}", method = RequestMethod.GET)
	public Result getExample(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.getObjectById(SystemConfig.Example, id));
	}

	@ApiOperation("活动列表")
	@RequestMapping(value = "/campaign/list", method = RequestMethod.GET)
	public Result listCampaign(){
		return Result.okWithPage( () -> showBranchService.listCampaign(),
				ServiceHelper.getQueryListByPage());
	}

	@ApiOperation("案例列表")
	@RequestMapping(value = "/campaign/list", method = RequestMethod.POST)
	public Result listCampaignByPage(@RequestBody QueryInfo queryInfo){
		return Result.okWithPage( () -> showBranchService.listCampaign(), queryInfo);
	}

	@ApiOperation("获取活动")
	@RequestMapping(value = "/campaign/{id}", method = RequestMethod.GET)
	public Result getCampaign(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.getObjectById(SystemConfig.Campaign, id));
	}
}
