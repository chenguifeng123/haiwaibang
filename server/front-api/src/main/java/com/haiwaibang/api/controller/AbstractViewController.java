package com.haiwaibang.api.controller;

import com.haiwaibang.common.ServiceHelper;
import com.haiwaibang.common.web.Result;
import com.haiwaibang.config.SystemConfig;
import com.haiwaibang.model.po.multi.ComplexCountry;
import com.haiwaibang.model.service.CountryService;
import com.haiwaibang.model.service.ShowBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenguifeng on 2018/11/12.
 */
public abstract class AbstractViewController {

	@Autowired
	CountryService countryService;

	@Autowired
	ShowBranchService showBranchService;

	private List<ComplexCountry> getCountryGroupByContinent(){
		return countryService.getCountryGroupByContinent();
	}

	@Cacheable(value = SystemConfig.CACHE, key = SystemConfig.MENU)
	public Map<String, Object> getMenuModel() {
		return new HashMap<String, Object>(){{
			put("defaultImg", SystemConfig.DEFAULT_IMG);
			put("continent", getCountryGroupByContinent());
		}};
	}

	public Map<String, Object> getRecommendArticle(Map<String, Object> map) {
		map.put("articleRecommend", Result.okWithPage( () -> showBranchService.listArticle(),
				ServiceHelper.getQueryListByPage()).getData());
		return map;
	}

	public Map<String, Object> getRecommendExample(Map<String, Object> map) {
		map.put("exampleRecommend", Result.okWithPage( () -> showBranchService.listExample(),
				ServiceHelper.getQueryListByPage()).getData());
		return map;
	}

	public ModelAndView loadCachedModelAndView(ModelAndView modelAndView){
		return modelAndView == null ? modelAndView : modelAndView.addAllObjects(getMenuModel());
	}
}
