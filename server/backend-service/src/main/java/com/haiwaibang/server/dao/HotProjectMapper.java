package com.haiwaibang.server.dao;

import com.haiwaibang.model.po.HotProject;
import com.haiwaibang.model.po.HotProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface HotProjectMapper {
    int countByExample(HotProjectExample example);

    int deleteByExample(HotProjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HotProject record);

    int insertSelective(HotProject record);

    List<HotProject> selectByExampleWithRowbounds(HotProjectExample example, RowBounds rowBounds);

    List<HotProject> selectByExample(HotProjectExample example);

    HotProject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HotProject record, @Param("example") HotProjectExample example);

    int updateByExample(@Param("record") HotProject record, @Param("example") HotProjectExample example);

    int updateByPrimaryKeySelective(HotProject record);

    int updateByPrimaryKey(HotProject record);
}