package com.haiwaibang.model.service;

import com.haiwaibang.model.dto.ShowType;
import com.haiwaibang.model.po.Country;
import com.haiwaibang.model.po.CountryDocSource;
import com.haiwaibang.model.po.CountryImageSource;
import com.haiwaibang.model.po.multi.*;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/12.
 * 国家相关信息的处理
 */
public interface CountryService {

	public List<ComplexCountry> getCountryGroupByContinent();
	public Country getCountryByName(String name);

	List<CountryProjectTree> getCountryProjectTree();
	List<CountryProjectTree> getCountryTree();
	List<CountryDocSource> listCountryDocSource(int countryId);
	List<CountryDocSource> getCountryDocSourceById(int countryId);

	List<CountryImageSource> listCountryImageSource(int countryId);
	List<CountryImageSource> getCountryImageSourceById(int countryId);
	List<ComplexCountryImageSource> listComplexCountryImageSource(int countryId);
	List<ComplexCountryImageSource> listComplexCountryImageSource(int countryId, ShowType showType);

	List<ComplexCountryWithImage> listComplexCountryWithImage();
	List<ComplexCountryWithImage> getComplexCountryWithImageByCountryId(int countryId);
}
