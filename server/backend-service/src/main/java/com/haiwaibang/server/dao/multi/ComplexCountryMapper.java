package com.haiwaibang.server.dao.multi;

import com.haiwaibang.model.po.multi.ComplexCountry;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/30.
 */
public interface ComplexCountryMapper {
	List<ComplexCountry> getCountryGroupByContinent();
}
