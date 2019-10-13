package com.haiwaibang.server.service;

import com.haiwaibang.common.ServiceHelper;
import com.haiwaibang.model.dto.ShowType;
import com.haiwaibang.model.po.*;
import com.haiwaibang.model.po.multi.ComplexCountry;
import com.haiwaibang.model.po.multi.ComplexCountryImageSource;
import com.haiwaibang.model.po.multi.ComplexCountryWithImage;
import com.haiwaibang.model.po.multi.CountryProjectTree;
import com.haiwaibang.model.service.CountryService;
import com.haiwaibang.server.dao.CountryDocSourceMapper;
import com.haiwaibang.server.dao.CountryImageSourceMapper;
import com.haiwaibang.server.dao.CountryMapper;
import com.haiwaibang.server.dao.ProjectSourceManageMapper;
import com.haiwaibang.server.dao.multi.ComplexCountryImageSourceMapper;
import com.haiwaibang.server.dao.multi.ComplexCountryMapper;
import com.haiwaibang.server.dao.multi.ComplexObjectWithImageMapper;
import com.haiwaibang.server.dao.multi.ComplexHotObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/12.
 */
@Component
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryMapper countryMapper;

	@Autowired
	ComplexCountryMapper complexCountryMapper;

	@Autowired
	ProjectSourceManageMapper projectSourceManageMapper;

	@Autowired
	CountryImageSourceMapper countryImageSourceMapper;

	@Autowired
	ComplexCountryImageSourceMapper complexCountryImageSourceMapper;

	@Autowired
	CountryDocSourceMapper countryDocSourceMapper;

	@Autowired
	ComplexHotObjectMapper complexHotCountryMapper;

	@Autowired
	ComplexObjectWithImageMapper complexObjectWithImageMapper;

	public List<ComplexCountry> getCountryGroupByContinent() {
		return complexCountryMapper.getCountryGroupByContinent();
	}

	public Country getCountryByName(String name){
		CountryExample countryExample = new CountryExample();
		CountryExample.Criteria criteria = countryExample.createCriteria();
		criteria.andNameEqualTo(name);
		List<Country> list = countryMapper.selectByExample(countryExample);
		return ServiceHelper.getSimpleDataByCollection(list);
	}
	public List<CountryProjectTree> getCountryProjectTree() {
		return projectSourceManageMapper.getCountryProjectTree();
	}

	public List<CountryProjectTree> getCountryTree() {
		return projectSourceManageMapper.getCountryTree();
	}

	public List<CountryDocSource> listCountryDocSource(int countryId) {
		CountryDocSourceExample countryDocSourceExample = new CountryDocSourceExample();
		CountryDocSourceExample.Criteria criteria = countryDocSourceExample.createCriteria();
		criteria.andCountryIdEqualTo(countryId);
		return countryDocSourceMapper.selectByExample(countryDocSourceExample);
	}

	public List<CountryImageSource> listCountryImageSource(int countryId) {
		CountryImageSourceExample countryImageSourceExample = new CountryImageSourceExample();
		CountryImageSourceExample.Criteria criteria = countryImageSourceExample.createCriteria();
		criteria.andCountryIdEqualTo(countryId);
		return countryImageSourceMapper.selectByExample(countryImageSourceExample);
	}

	public List<ComplexCountryImageSource> listComplexCountryImageSource(int countryId) {
		return listComplexCountryImageSource(countryId, null);
	}

	public List<ComplexCountryImageSource> listComplexCountryImageSource(int countryId, ShowType showType) {
		return complexCountryImageSourceMapper.listComplexCountryImageSource(countryId,
				showType != null ? showType.getType() : null);
	}

	public List<CountryImageSource> getCountryImageSourceById(int countryId) {
		CountryImageSourceExample countryImageSourceExample = new CountryImageSourceExample();
		CountryImageSourceExample.Criteria criteria = countryImageSourceExample.createCriteria();
		criteria.andCountryIdEqualTo(countryId);
		return countryImageSourceMapper.selectByExample(countryImageSourceExample);
	}

	public List<CountryDocSource> getCountryDocSourceById(int countryId) {
		CountryDocSourceExample countryDocSourceExample = new CountryDocSourceExample();
		CountryDocSourceExample.Criteria criteria = countryDocSourceExample.createCriteria();
		criteria.andCountryIdEqualTo(countryId);
		return countryDocSourceMapper.selectByExample(countryDocSourceExample);
	}

	public List<ComplexCountryWithImage> listComplexCountryWithImage() {
		return complexObjectWithImageMapper.listComplexCountryWithImage();
	}

	public List<ComplexCountryWithImage> getComplexCountryWithImageByCountryId(int countryId) {
		return complexObjectWithImageMapper.getComplexCountryWithImageByCountryId(countryId);
	}
}

