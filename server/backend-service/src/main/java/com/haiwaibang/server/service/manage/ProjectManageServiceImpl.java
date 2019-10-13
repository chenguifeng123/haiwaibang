package com.haiwaibang.server.service.manage;

import com.haiwaibang.common.exception.Error;
import com.haiwaibang.common.exception.GlobalProcessException;
import com.haiwaibang.common.utils.LoggerUtils;
import com.haiwaibang.common.utils.StringUtils;
import com.haiwaibang.model.dto.QueryInfo;
import com.haiwaibang.model.po.Project;
import com.haiwaibang.model.po.ProjectExample;
import com.haiwaibang.model.service.manage.ProjectManageService;
import com.haiwaibang.server.dao.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/23.
 * 有特殊检查的, 暂不适用通用处理方法,后续考虑 抽象两个方法, 检查和对象保护处理
 */
@Component
public class ProjectManageServiceImpl extends AbstractManageServiceImpl implements ProjectManageService {

	@Autowired
	ProjectMapper projectMapper;


	private static enum ProjectManageServiceError implements Error {

		E_P0000001("P0000001","项目名已经存在"),
		E_P0000002("P0000002","项目新增失败"),
		E_P0000003("P0000003","项目修改失败"),
		E_P0000004("P0000004","项目删除失败"),
		E_P0000005("P0000005","项目记录不存在"),;

		String code;

		String msg;

		ProjectManageServiceError(String code, String msg) {
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

	private void checkProjectExists(int projectId){
		if(!isProjectExists(projectId)) throw new GlobalProcessException(ProjectManageServiceError.E_P0000005);
	}


	public Project addProject(Project project) {
		LoggerUtils.info(ProjectManageServiceImpl.class, "插入新的项目");

		// 检查国家名是否被使用
		ProjectExample projectExample = new ProjectExample();
		ProjectExample.Criteria criteria = projectExample.createCriteria();
		criteria.andNameEqualTo(project.getName());


		List<Project> list = projectMapper.selectByExample(projectExample);
		if(list != null && list.size() > 0)
			throw new GlobalProcessException(ProjectManageServiceError.E_P0000001);

		// 执行插入操作
		return daoOperate(project, (Project o) ->{
			return projectMapper.insert(o);
		}, ProjectManageServiceError.E_P0000002);

	}

	public Project updateProject(Project project) {
		LoggerUtils.info(ProjectManageServiceImpl.class, "更新当前项目");
		checkProjectExists(project.getId());

		// 检查国家名是否被其他id使用
		ProjectExample projectExample = new ProjectExample();
		ProjectExample.Criteria criteria = projectExample.createCriteria();
		criteria.andNameEqualTo(project.getName());
		criteria.andIdNotEqualTo(project.getId());

		List<Project> list = projectMapper.selectByExample(projectExample);
		if(list != null && list.size() > 0)
			throw new GlobalProcessException(ProjectManageServiceError.E_P0000001);

		// 执行修改操作
		return daoOperate(project, (Project o) ->{
			return projectMapper.updateByPrimaryKey(o);
		}, ProjectManageServiceError.E_P0000003);
	}

	public int deleteProject(int projectId) {
		LoggerUtils.info(ProjectManageServiceImpl.class, "删除当前项目");
		checkProjectExists(projectId);
		return daoOperate(projectId, (Integer o) ->{
			return projectMapper.deleteByPrimaryKey(o);
		}, ProjectManageServiceError.E_P0000004);
	}

	public List<Project> listProject(QueryInfo queryInfo) {
		LoggerUtils.info(ProjectManageServiceImpl.class, "列出当前项目");
		ProjectExample projectExample = new ProjectExample();
		if(StringUtils.isNotBlank(queryInfo.getSearchValue())) {
			ProjectExample.Criteria criteria = projectExample.createCriteria();
			criteria.andNameLike(StringUtils.bothLikeMatch(queryInfo.getSearchValue()));
		}
		return projectMapper.selectByExample(projectExample);
	}

	public List<Project> listProject() {
		return projectMapper.selectByExample(new ProjectExample());
	}

	public boolean isProjectExists(int projectId) {
		Project dbProject = projectMapper.selectByPrimaryKey(projectId);
		return dbProject != null;
	}

	public Project getProjectById(int projectId) {
		return projectMapper.selectByPrimaryKey(projectId);
	}
}
