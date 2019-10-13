package com.haiwaibang.server.service;

import com.haiwaibang.common.utils.LoggerUtils;
import com.haiwaibang.model.dto.ShowType;
import com.haiwaibang.model.po.*;
import com.haiwaibang.model.po.multi.ComplexProjectImageSource;
import com.haiwaibang.model.po.multi.ComplexProjectWithImage;
import com.haiwaibang.model.service.ProjectService;
import com.haiwaibang.server.dao.ProjectDocSourceMapper;
import com.haiwaibang.server.dao.ProjectImageSourceMapper;
import com.haiwaibang.server.dao.ProjectMapper;
import com.haiwaibang.server.dao.multi.ComplexObjectWithImageMapper;
import com.haiwaibang.server.dao.multi.ComplexProjectImageSourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/12.
 */
@Component
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectMapper projectMapper;

	@Autowired
	ProjectImageSourceMapper projectImageSourceMapper;

	@Autowired
	ComplexProjectImageSourceMapper complexProjectImageSourceMapper;

	@Autowired
	ProjectDocSourceMapper projectDocSourceMapper;

	@Autowired
	ComplexObjectWithImageMapper complexObjectWithImageMapper;

	public List<Project> getAllProjectByCountryId(int countryId) {
		ProjectExample projectExample = new ProjectExample();
		ProjectExample.Criteria criteria = projectExample.createCriteria();
		criteria.andCountryIdEqualTo(countryId);
		return projectMapper.selectByExample(projectExample);
	}

	public Project getProjectById(int projectId) {
		return projectMapper.selectByPrimaryKey(projectId);
	}


	public List<ProjectDocSource> listProjectDocSource(int projectId) {
		ProjectDocSourceExample projectImgSourceExample = new ProjectDocSourceExample();
		ProjectDocSourceExample.Criteria criteria = projectImgSourceExample.createCriteria();
		criteria.andProjectIdEqualTo(projectId);
		return projectDocSourceMapper.selectByExample(projectImgSourceExample);
	}

	public List<ComplexProjectImageSource> listComplexProjectImageSource(int projectId) {
		return listComplexProjectImageSource(projectId, null);
	}

	public List<ComplexProjectImageSource> listComplexProjectImageSource(int projectId, ShowType showType) {
		return complexProjectImageSourceMapper.listComplexProjectImageSource(projectId,
				showType != null ? showType.getType() : null);
	}

	public List<ProjectImageSource> listProjectImageSource(int projectId) {
		LoggerUtils.info(ProjectServiceImpl.class, "列出当前项目");
		ProjectImageSourceExample projectImageSourceExample = new ProjectImageSourceExample();
		ProjectImageSourceExample.Criteria criteria = projectImageSourceExample.createCriteria();
		criteria.andProjectIdEqualTo(projectId);
		return projectImageSourceMapper.selectByExample(projectImageSourceExample);
	}

	public List<ProjectImageSource> getProjectImageSourceByProjectId(int projectId) {
		ProjectImageSourceExample projectImageSourceExample = new ProjectImageSourceExample();
		ProjectImageSourceExample.Criteria criteria = projectImageSourceExample.createCriteria();
		criteria.andProjectIdEqualTo(projectId);
		return projectImageSourceMapper.selectByExample(projectImageSourceExample);
	}

	public List<ProjectDocSource> getProjectDocSourceByProjectId(int projectId) {
		ProjectDocSourceExample projectDocSourceExample = new ProjectDocSourceExample();
		ProjectDocSourceExample.Criteria criteria = projectDocSourceExample.createCriteria();
		criteria.andProjectIdEqualTo(projectId);
		return projectDocSourceMapper.selectByExample(projectDocSourceExample);
	}

	public List<ComplexProjectWithImage> listComplexProjectWithImage(int countryId) {
		return complexObjectWithImageMapper.listComplexProjectWithImage(countryId);
	}

	public List<ComplexProjectWithImage> getComplexProjectWithImageByProjectId(int projectId) {
		return complexObjectWithImageMapper.getComplexProjectWithImageByProjectId(projectId);
	}
}
