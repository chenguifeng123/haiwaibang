package com.haiwaibang.model.service;

import com.haiwaibang.model.dto.ShowType;
import com.haiwaibang.model.po.ArticleWithBLOBs;
import com.haiwaibang.model.po.CampaignWithBLOBs;
import com.haiwaibang.model.po.Custom;
import com.haiwaibang.model.po.ExampleWithBLOBs;
import com.haiwaibang.model.po.multi.ComplexBanner;
import com.haiwaibang.model.po.multi.ComplexHotCountry;
import com.haiwaibang.model.po.multi.ComplexHotProject;

import java.util.List;

/**
 * Created by chenguifeng on 2018/12/4.
 * 主要给 页面(PC/Mobile) 显示的分支用
 */
public interface ShowBranchService {
	List<ArticleWithBLOBs> listArticle();
	List<ExampleWithBLOBs> listExample();
	List<CampaignWithBLOBs> listCampaign();
	List<ComplexBanner> listBanner();
	List<ComplexBanner> listBanner(ShowType showType);
	List<ComplexHotCountry> listHotCountry();
	List<ComplexHotCountry> listHotCountry(ShowType showType);
	List<ComplexHotProject> listHotProject();

	List<Custom> listCustom();
}
