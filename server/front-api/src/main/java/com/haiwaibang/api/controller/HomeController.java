package com.haiwaibang.api.controller;

import com.haiwaibang.config.SystemConfig;
import com.haiwaibang.model.dto.QueryInfo;
import com.haiwaibang.model.dto.ShowType;
import com.haiwaibang.model.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenguifeng on 2018/11/10.
 */
@Controller
@Api(value = "首页加载")
public class HomeController extends AbstractViewController{

	private static final int PAGE_SIZE = 6;
	private static final int LAST_PAGE = 1;

	@Autowired
	ProjectService projectService;

	QueryInfo getQueryListByPage(){
		QueryInfo queryInfo = new QueryInfo();
		queryInfo.setPageNo(LAST_PAGE);
		queryInfo.setPageSize(PAGE_SIZE);
		return queryInfo;
	}

	@ApiOperation(value = "主页")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(){
		return home();
	}

	@Cacheable(value = SystemConfig.CACHE, key = SystemConfig.MAIN_CONTENT)
	public Map<String, Object> getContentModel() {
		return new HashMap<String, Object>(){{
			put("banner", showBranchService.listBanner(ShowType.COMPUTER));
			put("hotCountry", showBranchService.listHotCountry(ShowType.COMPUTER));
			put("hotProject", showBranchService.listHotProject());
		}};
	}

	@ApiOperation(value = "首页")
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(){
		return loadCachedModelAndView(new ModelAndView("home").addAllObjects(
				getRecommendArticle(getRecommendExample(getContentModel()))));
	}


	@ApiOperation(value = "关于")
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about(){
		return loadCachedModelAndView(new ModelAndView("about"));
	}

}
