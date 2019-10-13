package com.haiwaibang.server.dao;

import com.haiwaibang.model.po.CountryDocSource;
import com.haiwaibang.model.po.CountryDocSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CountryDocSourceMapper {
    int countByExample(CountryDocSourceExample example);

    int deleteByExample(CountryDocSourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CountryDocSource record);

    int insertSelective(CountryDocSource record);

    List<CountryDocSource> selectByExampleWithRowbounds(CountryDocSourceExample example, RowBounds rowBounds);

    List<CountryDocSource> selectByExample(CountryDocSourceExample example);

    CountryDocSource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CountryDocSource record, @Param("example") CountryDocSourceExample example);

    int updateByExample(@Param("record") CountryDocSource record, @Param("example") CountryDocSourceExample example);

    int updateByPrimaryKeySelective(CountryDocSource record);

    int updateByPrimaryKey(CountryDocSource record);
}