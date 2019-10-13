package com.haiwaibang.model.po.multi;

import com.haiwaibang.model.po.Country;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/12.
 */
public class ComplexCountry{

	private Integer continentId;

	private String continentName;

	private List<Country> subCountrys;

	public Integer getContinentId() {
		return continentId;
	}

	public void setContinentId(Integer continentId) {
		this.continentId = continentId;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public List<Country> getSubCountrys() {
		return subCountrys;
	}

	public void setSubCountrys(List<Country> subCountrys) {
		this.subCountrys = subCountrys;
	}
}
