package com.haiwaibang.model.po.multi;

import com.haiwaibang.model.po.Image;
import com.haiwaibang.model.po.ProjectImageSource;

/**
 * Created by chenguifeng on 2018/12/13.
 */
public class ComplexProjectImageSource extends ProjectImageSource {
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
