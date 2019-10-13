package com.haiwaibang.model.service;

import com.haiwaibang.model.dto.ShowType;
import com.haiwaibang.model.po.Project;
import com.haiwaibang.model.po.ProjectDocSource;
import com.haiwaibang.model.po.ProjectImageSource;
import com.haiwaibang.model.po.multi.ComplexProjectImageSource;
import com.haiwaibang.model.po.multi.ComplexProjectWithImage;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/9.
 * 项目相关的信息展示
 */
public interface ProjectService {
	List<Project> getAllProjectByCountryId(int countryId);
	Project getProjectById(int projectId);

	List<ProjectDocSource> listProjectDocSource(int projectId);
	List<ProjectImageSource> listProjectImageSource(int projectId);
	List<ComplexProjectImageSource> listComplexProjectImageSource(int projectId);
	List<ComplexProjectImageSource> listComplexProjectImageSource(int projectId, ShowType showType);

	List<ProjectImageSource> getProjectImageSourceByProjectId(int projectId);
	List<ProjectDocSource> getProjectDocSourceByProjectId(int projectId);

	List<ComplexProjectWithImage> listComplexProjectWithImage(int countryId);
	List<ComplexProjectWithImage> getComplexProjectWithImageByProjectId(int projectId);
}
