package com.haiwaibang.server.dao;

import com.haiwaibang.model.po.multi.CountryProjectTree;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/25.
 */
public interface ProjectSourceManageMapper {
	List<CountryProjectTree> getCountryProjectTree();
	List<CountryProjectTree> getCountryTree();
}
