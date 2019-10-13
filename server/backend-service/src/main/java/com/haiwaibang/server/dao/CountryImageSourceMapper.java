package com.haiwaibang.server.dao;

import com.haiwaibang.model.po.CountryImageSource;
import com.haiwaibang.model.po.CountryImageSourceExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CountryImageSourceMapper {
    int countByExample(CountryImageSourceExample example);

    int deleteByExample(CountryImageSourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CountryImageSource record);

    int insertSelective(CountryImageSource record);

    List<CountryImageSource> selectByExampleWithRowbounds(CountryImageSourceExample example, RowBounds rowBounds);

    List<CountryImageSource> selectByExample(CountryImageSourceExample example);

    CountryImageSource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CountryImageSource record, @Param("example") CountryImageSourceExample example);

    int updateByExample(@Param("record") CountryImageSource record, @Param("example") CountryImageSourceExample example);

    int updateByPrimaryKeySelective(CountryImageSource record);

    int updateByPrimaryKey(CountryImageSource record);
}