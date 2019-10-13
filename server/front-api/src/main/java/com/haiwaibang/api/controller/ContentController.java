package com.haiwaibang.api.controller;

import com.haiwaibang.common.web.Result;
import com.haiwaibang.config.SystemConfig;
import com.haiwaibang.model.dto.QueryInfo;
import com.haiwaibang.model.service.manage.CommonDbManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * Created by chenguifeng on 2018/12/9.
 */
@Controller
@Api(value = "内容发布")
public class ContentController extends AbstractViewController{

	private static final int PAGE_SIZE = 10;

	@Autowired
	CommonDbManageService commonDbManageService;

	QueryInfo getQueryByPage(int pageNo){
		QueryInfo queryInfo = new QueryInfo();
		queryInfo.setPageNo(pageNo);
		queryInfo.setPageSize(PAGE_SIZE);
		return queryInfo;
	}

	ModelAndView addPage2View(ModelAndView modelAndView, Result result){
		int pageNum = (int)Math.ceil((float)result.getTotalCount() / result.getPageSize());
		int pageNo = result.getPageNo();
		return modelAndView.addObject("total", result.getTotalCount()).
				addObject("currentPage", pageNo).
				addObject("prev", pageNo == 1 ? pageNo : pageNo -1).
				addObject("next", pageNo == pageNum ? pageNum : pageNo + 1).
				addObject("pageNum", pageNum);
	}

	@ApiOperation(value = "文章列表")
	@RequestMapping(value = "/article/list", method = RequestMethod.GET)
	public ModelAndView articleListDefault(){
		return articleList(1);
	}

	@ApiOperation(value = "文章列表")
	@RequestMapping(value = "/article/list/{pageNo}", method = RequestMethod.GET)
	public ModelAndView articleList(@PathVariable("pageNo") int pageNo){
		Result result = Result.okWithPage(()->showBranchService.listArticle(), getQueryByPage(pageNo));
		return loadCachedModelAndView(addPage2View(new ModelAndView("/content/articleList"), result).
				addObject("articleList", result.getData()));
	}

	@ApiOperation(value = "文章")
	@RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET)
	public ModelAndView article(@PathVariable("articleId") int articleId){
		return loadCachedModelAndView(new ModelAndView("/content/article").addObject(
				SystemConfig.Article, commonDbManageService.getObjectById(SystemConfig.Article, articleId)).
				addAllObjects(getRecommendArticle(new HashMap<>())));
	}

	@ApiOperation(value = "案例列表")
	@RequestMapping(value = "/example/list", method = RequestMethod.GET)
	public ModelAndView exampleListDefault(){
		return exampleList(1);
	}

	@ApiOperation(value = "案例列表")
	@RequestMapping(value = "/example/list/{pageNo}", method = RequestMethod.GET)
	public ModelAndView exampleList(@PathVariable("pageNo") int pageNo){
		Result result = Result.okWithPage(()->showBranchService.listExample(), getQueryByPage(pageNo));
		return loadCachedModelAndView(addPage2View(new ModelAndView("/content/exampleList"), result).
				addObject("exampleList", result.getData()));
	}

	@ApiOperation(value = "案例")
	@RequestMapping(value = "/example/{exampleId}", method = RequestMethod.GET)
	public ModelAndView example(@PathVariable("exampleId") int exampleId){
		return loadCachedModelAndView(new ModelAndView("/content/example").addObject(
				SystemConfig.Example, commonDbManageService.getObjectById(SystemConfig.Example, exampleId)).
				addAllObjects(getRecommendExample(new HashMap<>())));
	}
}
