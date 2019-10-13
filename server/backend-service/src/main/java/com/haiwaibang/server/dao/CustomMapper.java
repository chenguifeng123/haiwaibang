package com.haiwaibang.server.dao;

import com.haiwaibang.model.po.Custom;
import com.haiwaibang.model.po.CustomExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CustomMapper {
    int countByExample(CustomExample example);

    int deleteByExample(CustomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Custom record);

    int insertSelective(Custom record);

    List<Custom> selectByExampleWithRowbounds(CustomExample example, RowBounds rowBounds);

    List<Custom> selectByExample(CustomExample example);

    Custom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByExample(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);
}