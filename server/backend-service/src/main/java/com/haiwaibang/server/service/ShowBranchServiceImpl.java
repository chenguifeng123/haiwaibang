package com.haiwaibang.server.service;

import com.haiwaibang.model.dto.ShowType;
import com.haiwaibang.model.po.*;
import com.haiwaibang.model.po.multi.ComplexBanner;
import com.haiwaibang.model.po.multi.ComplexHotCountry;
import com.haiwaibang.model.po.multi.ComplexHotProject;
import com.haiwaibang.model.service.ShowBranchService;
import com.haiwaibang.server.dao.ArticleMapper;
import com.haiwaibang.server.dao.CampaignMapper;
import com.haiwaibang.server.dao.CustomMapper;
import com.haiwaibang.server.dao.ExampleMapper;
import com.haiwaibang.server.dao.multi.ComplexBannerMapper;
import com.haiwaibang.server.dao.multi.ComplexHotObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenguifeng on 2018/12/4.
 */
@Component
public class ShowBranchServiceImpl implements ShowBranchService {

	@Autowired
	ComplexBannerMapper complexBannerMapper;

	@Autowired
	ArticleMapper articleMapper;

	@Autowired
	ExampleMapper exampleMapper;

	@Autowired
	CampaignMapper campaignMapper;

	@Autowired
	ComplexHotObjectMapper complexHotObjectMapper;

	@Autowired
	CustomMapper customMapper;

	public List<ComplexBanner> listBanner() {
		return listBanner(null);
	}

	@Override
	public List<ComplexBanner> listBanner(ShowType showType) {
		return complexBannerMapper.listBanner(showType != null ? showType.getType() : null);
	}

	public List<ArticleWithBLOBs> listArticle() {
		ArticleExample articleExample = new ArticleExample();
		articleExample.setOrderByClause("create_time desc");
		return articleMapper.selectByExampleWithBLOBs(articleExample);
	}

	public List<ExampleWithBLOBs> listExample() {
		ExampleExample exampleExample = new ExampleExample();
		exampleExample.setOrderByClause("create_time desc");
		return exampleMapper.selectByExampleWithBLOBs(exampleExample);
	}

	public List<CampaignWithBLOBs> listCampaign() {
		CampaignExample campaignExample = new CampaignExample();
		campaignExample.setOrderByClause("create_time desc");
		return campaignMapper.selectByExampleWithBLOBs(campaignExample);
	}

	public List<ComplexHotCountry> listHotCountry() {
		return complexHotObjectMapper.listHotCountry(null);
	}

	public List<ComplexHotCountry> listHotCountry(ShowType showType) {
		return complexHotObjectMapper.listHotCountry(showType != null ? showType.getType() : null);
	}

	public List<ComplexHotProject> listHotProject() {
		return complexHotObjectMapper.listHotProject();
	}

	public List<Custom> listCustom() {
		CustomExample customExample = new CustomExample();
		customExample.setOrderByClause("create_time desc");
		return customMapper.selectByExample(customExample);
	}
}
