package com.haiwaibang.model.po.multi;

import com.haiwaibang.model.po.HotProject;
import com.haiwaibang.model.po.Image;
import com.haiwaibang.model.po.Project;

/**
 * Created by chenguifeng on 2018/12/4.
 */
public class ComplexHotProject extends HotProject {
	private Project project;
	private Image image;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
