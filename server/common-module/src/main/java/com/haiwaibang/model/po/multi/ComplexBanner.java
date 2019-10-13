package com.haiwaibang.model.po.multi;

import com.haiwaibang.model.po.Banner;
import com.haiwaibang.model.po.Image;

/**
 * Created by chenguifeng on 2018/11/30.
 */
public class ComplexBanner extends Banner{
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}


}
