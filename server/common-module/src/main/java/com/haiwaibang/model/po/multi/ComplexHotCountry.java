package com.haiwaibang.model.po.multi;

import com.haiwaibang.model.po.Country;
import com.haiwaibang.model.po.HotCountry;
import com.haiwaibang.model.po.Image;

/**
 * Created by chenguifeng on 2018/12/4.
 */
public class ComplexHotCountry extends HotCountry {
	private Country country;
	private Image image;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
