package com.haiwaibang.server.service.manage;

import com.haiwaibang.common.exception.Error;
import com.haiwaibang.common.exception.GlobalProcessException;
import com.haiwaibang.common.utils.LoggerUtils;
import com.haiwaibang.model.po.Country;
import com.haiwaibang.model.po.CountryExample;
import com.haiwaibang.model.service.manage.CountryManageService;
import com.haiwaibang.server.dao.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/16.
 * 有特殊检查的, 暂不适用通用处理方法,后续考虑 抽象两个方法, 检查和对象保护处理
 */
@Component
public class CountryManageServiceImpl extends AbstractManageServiceImpl implements CountryManageService{

	@Autowired
	CountryMapper countryMapper;


	private static enum CountryManageServiceError implements Error {

		E_C0000001("C0000001","国家名已经存在"),
		E_C0000002("C0000002","国家新增失败"),
		E_C0000003("C0000003","国家修改失败"),
		E_C0000004("C0000004","国家删除失败"),
		E_C0000005("C0000005","国家记录不存在"),;

		String code;

		String msg;

		CountryManageServiceError(String code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		@Override
		public String code() {
			return code;
		}

		@Override
		public String msg() {
			return msg;
		}
	}

	private void checkCountryExists(int countryId){
		if(!isCountryExists(countryId)) throw new GlobalProcessException(CountryManageServiceError.E_C0000005);
	}

	public Country addCountry(Country country) {
		LoggerUtils.info(CountryManageServiceImpl.class, "插入新的国家");

		// 检查国家名是否被使用
		CountryExample countryExample = new CountryExample();
		CountryExample.Criteria criteriaName = countryExample.createCriteria();
		criteriaName.andNameEqualTo(country.getName());

		CountryExample.Criteria criteriaNameZh = countryExample.createCriteria();
		criteriaNameZh.andNameZhEqualTo(country.getNameZh());
		countryExample.or(criteriaNameZh);
		List<Country> list = countryMapper.selectByExample(countryExample);
		if(list != null && list.size() > 0)
			throw new GlobalProcessException(CountryManageServiceError.E_C0000001);

		// 执行插入操作
		return daoOperate(country, (Country o) ->{
			return countryMapper.insert(o);
		}, CountryManageServiceError.E_C0000002);

	}

	public Country updateCountry(Country country) {
		LoggerUtils.info(CountryManageServiceImpl.class, "更新当前国家");
		checkCountryExists(country.getId());

		// 检查国家名是否被其他id使用
		CountryExample countryExample = new CountryExample();

		CountryExample.Criteria criteriaName = countryExample.createCriteria();
		criteriaName.andIdNotEqualTo(country.getId());
		criteriaName.andNameEqualTo(country.getName());

		CountryExample.Criteria criteriaNameZh = countryExample.createCriteria();
		criteriaNameZh.andIdNotEqualTo(country.getId());
		criteriaNameZh.andNameZhEqualTo(country.getNameZh());

		countryExample.or(criteriaNameZh);

		List<Country> list = countryMapper.selectByExample(countryExample);
		if(list != null && list.size() > 0)
			throw new GlobalProcessException(CountryManageServiceError.E_C0000001);

		// 执行修改操作
		return daoOperate(country, (Country o) ->{
			return countryMapper.updateByPrimaryKey(o);
		}, CountryManageServiceError.E_C0000003);

	}

	public int deleteCountry(int countryId) {
		LoggerUtils.info(CountryManageServiceImpl.class, "删除当前国家");
		checkCountryExists(countryId);
		return daoOperate(countryId, (Integer o) ->{
			return countryMapper.deleteByPrimaryKey(o);
		}, CountryManageServiceError.E_C0000004);
	}

	public List<Country> listCountry() {
		LoggerUtils.info(CountryManageServiceImpl.class, "列出当前国家");
		return countryMapper.selectByExample(new CountryExample());
	}

	public boolean isCountryExists(int countryId) {
		Country dbCountry = countryMapper.selectByPrimaryKey(countryId);
		return dbCountry != null;
	}

	public Country getCountryById(int countryId) {
		return countryMapper.selectByPrimaryKey(countryId);
	}
}
