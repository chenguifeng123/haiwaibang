package com.haiwaibang.server.dao;

import com.haiwaibang.model.po.Campaign;
import com.haiwaibang.model.po.CampaignExample;
import com.haiwaibang.model.po.CampaignWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CampaignMapper {
    int countByExample(CampaignExample example);

    int deleteByExample(CampaignExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CampaignWithBLOBs record);

    int insertSelective(CampaignWithBLOBs record);

    List<CampaignWithBLOBs> selectByExampleWithBLOBsWithRowbounds(CampaignExample example, RowBounds rowBounds);

    List<CampaignWithBLOBs> selectByExampleWithBLOBs(CampaignExample example);

    List<Campaign> selectByExampleWithRowbounds(CampaignExample example, RowBounds rowBounds);

    List<Campaign> selectByExample(CampaignExample example);

    CampaignWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CampaignWithBLOBs record, @Param("example") CampaignExample example);

    int updateByExampleWithBLOBs(@Param("record") CampaignWithBLOBs record, @Param("example") CampaignExample example);

    int updateByExample(@Param("record") Campaign record, @Param("example") CampaignExample example);

    int updateByPrimaryKeySelective(CampaignWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CampaignWithBLOBs record);

    int updateByPrimaryKey(Campaign record);
}