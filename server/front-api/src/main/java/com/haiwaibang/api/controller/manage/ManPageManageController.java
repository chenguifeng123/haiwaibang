package com.haiwaibang.api.controller.manage;

import com.haiwaibang.common.ServiceHelper;
import com.haiwaibang.common.web.Result;
import com.haiwaibang.config.SystemConfig;
import com.haiwaibang.model.dto.QueryInfo;
import com.haiwaibang.model.dto.ShowType;
import com.haiwaibang.model.po.*;
import com.haiwaibang.model.service.ShowBranchService;
import com.haiwaibang.model.service.manage.CommonDbManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenguifeng on 2018/12/2.
 */
@RestController
@Api(value = "广告栏处理")
@RequestMapping("/manage")
public class ManPageManageController {

	@Autowired
	ShowBranchService showBranchService;

	@Autowired
	CommonDbManageService commonDbManageService;

	@ApiOperation("广告栏列表")
	@RequestMapping(value = "/banner/list", method = RequestMethod.GET)
	public Result listBanner(){
		return Result.ok(showBranchService.listBanner(ShowType.COMPUTER));
	}

	@ApiOperation("广告栏列表")
	@RequestMapping(value = "/banner/list", method = RequestMethod.POST)
	public Result listBannerByPage(@RequestBody QueryInfo queryInfo){
		return Result.okWithPage(()->showBranchService.listBanner(ShowType.COMPUTER), queryInfo);
	}

	@ApiOperation("增加广告栏")
	@RequestMapping(value = "/banner", method = RequestMethod.PUT)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result addBanner(@RequestBody Banner banner){
		banner = ServiceHelper.fillBanner(banner);
		return Result.ok(commonDbManageService.addObject(SystemConfig.Banner, banner));
	}

	@ApiOperation("修改广告栏")
	@RequestMapping(value = "/banner/{id}", method = RequestMethod.POST)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result updateBanner(@PathVariable("id") int id, @RequestBody Banner banner){
		banner = ServiceHelper.fillBanner(banner);
		return Result.ok(commonDbManageService.updateObject(SystemConfig.Banner, banner));
	}

	@ApiOperation("删除广告栏")
	@RequestMapping(value = "/banner/{id}", method = RequestMethod.DELETE)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result deleteBanner(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.deleteObject(SystemConfig.Banner, id));
	}

	@ApiOperation("热门国家列表")
	@RequestMapping(value = "/hotCountry/list", method = RequestMethod.GET)
	public Result listHotCountry(){
		return Result.ok(showBranchService.listHotCountry(ShowType.COMPUTER));
	}

	@ApiOperation("增加热门国家")
	@RequestMapping(value = "/hotCountry", method = RequestMethod.PUT)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result addHotCountry(@RequestBody HotCountry hotCountry){
		return Result.ok(commonDbManageService.addObject(SystemConfig.HotCountry, hotCountry));
	}

	@ApiOperation("修改热门国家")
	@RequestMapping(value = "/hotCountry/{id}", method = RequestMethod.POST)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result updateHotCountry(@PathVariable("id") int id, @RequestBody HotCountry hotCountry){
		return Result.ok(commonDbManageService.updateObject(SystemConfig.HotCountry, hotCountry));
	}

	@ApiOperation("删除热门国家")
	@RequestMapping(value = "/hotCountry/{id}", method = RequestMethod.DELETE)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result deleteHotCountry(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.deleteObject(SystemConfig.HotCountry, id));
	}

	@ApiOperation("热门项目列表")
	@RequestMapping(value = "/hotProject/list", method = RequestMethod.GET)
	public Result listHotProject(){
		return Result.ok(showBranchService.listHotProject());
	}

	@ApiOperation("增加热门项目")
	@RequestMapping(value = "/hotProject", method = RequestMethod.PUT)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result addHotProject(@RequestBody HotProject hotProject){
		return Result.ok(commonDbManageService.addObject(SystemConfig.HotProject, hotProject));
	}

	@ApiOperation("修改热门项目")
	@RequestMapping(value = "/hotProject/{id}", method = RequestMethod.POST)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result updateHotProject(@PathVariable("id") int id, @RequestBody HotProject hotProject){
		return Result.ok(commonDbManageService.updateObject(SystemConfig.HotProject, hotProject));
	}

	@ApiOperation("删除热门项目")
	@RequestMapping(value = "/hotProject/{id}", method = RequestMethod.DELETE)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result deleteHotProject(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.deleteObject(SystemConfig.HotProject, id));
	}

	@ApiOperation("文章列表")
	@RequestMapping(value = "/article/list", method = RequestMethod.GET)
	public Result listArticle(){
		return Result.ok(showBranchService.listArticle());
	}

	@ApiOperation("文章列表")
	@RequestMapping(value = "/article/list", method = RequestMethod.POST)
	public Result listArticleByPage(@RequestBody QueryInfo queryInfo){
		return Result.okWithPage(()->showBranchService.listArticle(), queryInfo);
	}

	@ApiOperation("增加文章")
	@RequestMapping(value = "/article", method = RequestMethod.PUT)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result addArticle(@RequestBody ArticleWithBLOBs articleWithBLOBs){
		articleWithBLOBs = ServiceHelper.fillHtml(articleWithBLOBs);
		return Result.ok(commonDbManageService.addObject(SystemConfig.Article, articleWithBLOBs));
	}

	@ApiOperation("修改文章")
	@RequestMapping(value = "/article/{id}", method = RequestMethod.POST)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result updateArticle(@PathVariable("id") int id, @RequestBody ArticleWithBLOBs articleWithBLOBs){
		articleWithBLOBs = ServiceHelper.fillHtml(articleWithBLOBs);
		return Result.ok(commonDbManageService.updateObject(SystemConfig.Article, articleWithBLOBs));
	}

	@ApiOperation("删除文章")
	@RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result deleteArticle(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.deleteObject(SystemConfig.Article, id));
	}

	@ApiOperation("案例列表")
	@RequestMapping(value = "/example/list", method = RequestMethod.GET)
	public Result listExample(){
		return Result.ok(showBranchService.listExample());
	}

	@ApiOperation("案例列表")
	@RequestMapping(value = "/example/list", method = RequestMethod.POST)
	public Result listExampleByPage(@RequestBody QueryInfo queryInfo){
		return Result.okWithPage(()->showBranchService.listExample(), queryInfo);
	}

	@ApiOperation("增加案例")
	@RequestMapping(value = "/example", method = RequestMethod.PUT)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result addExample(@RequestBody ExampleWithBLOBs exampleWithBLOBs){
		exampleWithBLOBs = ServiceHelper.fillHtml(exampleWithBLOBs);
		return Result.ok(commonDbManageService.addObject(SystemConfig.Example, exampleWithBLOBs));
	}

	@ApiOperation("修改案例")
	@RequestMapping(value = "/example/{id}", method = RequestMethod.POST)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result updateExample(@PathVariable("id") int id, @RequestBody ExampleWithBLOBs exampleWithBLOBs){
		exampleWithBLOBs = ServiceHelper.fillHtml(exampleWithBLOBs);
		return Result.ok(commonDbManageService.updateObject(SystemConfig.Example, exampleWithBLOBs));
	}

	@ApiOperation("删除案例")
	@RequestMapping(value = "/example/{id}", method = RequestMethod.DELETE)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result deleteExample(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.deleteObject(SystemConfig.Example, id));
	}

	@ApiOperation("活动列表")
	@RequestMapping(value = "/campaign/list", method = RequestMethod.GET)
	public Result listCampaign(){
		return Result.ok(showBranchService.listCampaign());
	}

	@ApiOperation("活动列表")
	@RequestMapping(value = "/campaign/list", method = RequestMethod.POST)
	public Result listCampaignByPage(@RequestBody QueryInfo queryInfo){
		return Result.okWithPage(()->showBranchService.listCampaign(), queryInfo);
	}

	@ApiOperation("增加活动")
	@RequestMapping(value = "/campaign", method = RequestMethod.PUT)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result addCampaign(@RequestBody CampaignWithBLOBs campaignWithBLOBs){
		campaignWithBLOBs = ServiceHelper.fillHtml(campaignWithBLOBs);
		return Result.ok(commonDbManageService.addObject(SystemConfig.Campaign, campaignWithBLOBs));
	}

	@ApiOperation("修改活动")
	@RequestMapping(value = "/campaign/{id}", method = RequestMethod.POST)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result updateCampaign(@PathVariable("id") int id, @RequestBody CampaignWithBLOBs campaignWithBLOBs){
		campaignWithBLOBs = ServiceHelper.fillHtml(campaignWithBLOBs);
		return Result.ok(commonDbManageService.updateObject(SystemConfig.Campaign, campaignWithBLOBs));
	}

	@ApiOperation("删除活动")
	@RequestMapping(value = "/campaign/{id}", method = RequestMethod.DELETE)
	@CacheEvict(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Result deleteCampaign(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.deleteObject(SystemConfig.Campaign, id));
	}
}
