package com.haiwaibang.server.dao;

import com.haiwaibang.model.po.ProjectDocSource;
import com.haiwaibang.model.po.ProjectDocSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ProjectDocSourceMapper {
    int countByExample(ProjectDocSourceExample example);

    int deleteByExample(ProjectDocSourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectDocSource record);

    int insertSelective(ProjectDocSource record);

    List<ProjectDocSource> selectByExampleWithRowbounds(ProjectDocSourceExample example, RowBounds rowBounds);

    List<ProjectDocSource> selectByExample(ProjectDocSourceExample example);

    ProjectDocSource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectDocSource record, @Param("example") ProjectDocSourceExample example);

    int updateByExample(@Param("record") ProjectDocSource record, @Param("example") ProjectDocSourceExample example);

    int updateByPrimaryKeySelective(ProjectDocSource record);

    int updateByPrimaryKey(ProjectDocSource record);
}