package com.haiwaibang.server.dao.multi;

import com.haiwaibang.model.po.multi.ComplexBanner;

import java.util.List;

/**
 * Created by chenguifeng on 2018/12/2.
 */
public interface ComplexBannerMapper {
	List<ComplexBanner> listBanner(int showType);
}
