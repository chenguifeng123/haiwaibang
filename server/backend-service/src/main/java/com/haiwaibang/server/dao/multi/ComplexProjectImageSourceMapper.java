package com.haiwaibang.server.dao.multi;

import com.haiwaibang.model.po.multi.ComplexProjectImageSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComplexProjectImageSourceMapper {
    List<ComplexProjectImageSource> listComplexProjectImageSource(@Param("projectId") int projectId, @Param("showType") Integer showType);
}