package com.haiwaibang.model.po.multi;

import com.haiwaibang.model.po.CountryImageSource;
import com.haiwaibang.model.po.Image;

/**
 * Created by chenguifeng on 2018/12/13.
 */
public class ComplexCountryImageSource extends CountryImageSource {
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
