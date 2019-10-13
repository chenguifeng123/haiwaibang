package com.haiwaibang.server.dao;

import com.haiwaibang.model.po.Example;
import com.haiwaibang.model.po.ExampleExample;
import com.haiwaibang.model.po.ExampleWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExampleMapper {
    int countByExample(ExampleExample example);

    int deleteByExample(ExampleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExampleWithBLOBs record);

    int insertSelective(ExampleWithBLOBs record);

    List<ExampleWithBLOBs> selectByExampleWithBLOBsWithRowbounds(ExampleExample example, RowBounds rowBounds);

    List<ExampleWithBLOBs> selectByExampleWithBLOBs(ExampleExample example);

    List<Example> selectByExampleWithRowbounds(ExampleExample example, RowBounds rowBounds);

    List<Example> selectByExample(ExampleExample example);

    ExampleWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExampleWithBLOBs record, @Param("example") ExampleExample example);

    int updateByExampleWithBLOBs(@Param("record") ExampleWithBLOBs record, @Param("example") ExampleExample example);

    int updateByExample(@Param("record") Example record, @Param("example") ExampleExample example);

    int updateByPrimaryKeySelective(ExampleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ExampleWithBLOBs record);

    int updateByPrimaryKey(Example record);
}