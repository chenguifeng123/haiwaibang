package com.haiwaibang.server.dao;

import com.haiwaibang.model.po.ProjectImageSource;
import com.haiwaibang.model.po.ProjectImageSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ProjectImageSourceMapper {
    int countByExample(ProjectImageSourceExample example);

    int deleteByExample(ProjectImageSourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectImageSource record);

    int insertSelective(ProjectImageSource record);

    List<ProjectImageSource> selectByExampleWithRowbounds(ProjectImageSourceExample example, RowBounds rowBounds);

    List<ProjectImageSource> selectByExample(ProjectImageSourceExample example);

    ProjectImageSource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectImageSource record, @Param("example") ProjectImageSourceExample example);

    int updateByExample(@Param("record") ProjectImageSource record, @Param("example") ProjectImageSourceExample example);

    int updateByPrimaryKeySelective(ProjectImageSource record);

    int updateByPrimaryKey(ProjectImageSource record);
}