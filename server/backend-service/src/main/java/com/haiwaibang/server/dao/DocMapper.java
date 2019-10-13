package com.haiwaibang.server.dao;

import com.haiwaibang.model.po.Doc;
import com.haiwaibang.model.po.DocExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DocMapper {
    int countByExample(DocExample example);

    int deleteByExample(DocExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Doc record);

    int insertSelective(Doc record);

    List<Doc> selectByExampleWithRowbounds(DocExample example, RowBounds rowBounds);

    List<Doc> selectByExample(DocExample example);

    Doc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Doc record, @Param("example") DocExample example);

    int updateByExample(@Param("record") Doc record, @Param("example") DocExample example);

    int updateByPrimaryKeySelective(Doc record);

    int updateByPrimaryKey(Doc record);
}