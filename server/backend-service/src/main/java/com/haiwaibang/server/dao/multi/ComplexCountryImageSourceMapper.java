package com.haiwaibang.server.dao.multi;

import com.haiwaibang.model.po.multi.ComplexCountryImageSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComplexCountryImageSourceMapper {
    List<ComplexCountryImageSource> listComplexCountryImageSource(
            @Param("countryId") int countryId, @Param("showType") int showType);
}