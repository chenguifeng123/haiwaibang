package com.haiwaibang.server.dao;

import com.haiwaibang.model.po.HotCountry;
import com.haiwaibang.model.po.HotCountryExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface HotCountryMapper {
    int countByExample(HotCountryExample example);

    int deleteByExample(HotCountryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HotCountry record);

    int insertSelective(HotCountry record);

    List<HotCountry> selectByExampleWithRowbounds(HotCountryExample example, RowBounds rowBounds);

    List<HotCountry> selectByExample(HotCountryExample example);

    HotCountry selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HotCountry record, @Param("example") HotCountryExample example);

    int updateByExample(@Param("record") HotCountry record, @Param("example") HotCountryExample example);

    int updateByPrimaryKeySelective(HotCountry record);

    int updateByPrimaryKey(HotCountry record);
}