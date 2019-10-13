package com.haiwaibang.model.service.manage;

import com.haiwaibang.model.dto.QueryInfo;
import com.haiwaibang.model.po.Project;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/16.
 * 有特殊检查的, 暂不适用通用处理方法,后续考虑 抽象两个方法, 检查和对象保护处理
 */
public interface ProjectManageService {
	Project addProject(Project project);
	Project updateProject(Project project);
	int deleteProject(int projectId);

	List<Project> listProject(QueryInfo queryInfo);
	List<Project> listProject();
	boolean isProjectExists(int projectId);
	Project getProjectById(int projectId);
}

