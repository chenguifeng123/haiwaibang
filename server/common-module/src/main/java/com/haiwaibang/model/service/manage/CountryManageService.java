package com.haiwaibang.model.service.manage;

import com.haiwaibang.model.po.Country;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/16.
 * 有特殊检查的, 暂不适用通用处理方法,后续考虑 抽象两个方法, 检查和对象保护处理
 */
public interface CountryManageService {

	Country addCountry(Country country);
	Country updateCountry(Country country);
	int deleteCountry(int countryId);


	List<Country> listCountry();
	boolean isCountryExists(int countryId);
	Country getCountryById(int countryId);
}
