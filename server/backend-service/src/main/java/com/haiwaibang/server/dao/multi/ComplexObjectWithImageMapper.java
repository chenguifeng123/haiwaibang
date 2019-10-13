package com.haiwaibang.server.dao.multi;

import com.haiwaibang.model.po.multi.ComplexCountryWithImage;
import com.haiwaibang.model.po.multi.ComplexProjectWithImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/30.
 */
public interface ComplexObjectWithImageMapper {
	List<ComplexCountryWithImage> listComplexCountryWithImage();
	public List<ComplexCountryWithImage> getComplexCountryWithImageByCountryId(@Param("countryId") int countryId);
	List<ComplexProjectWithImage> listComplexProjectWithImage(@Param("countryId") int countryId);
	List<ComplexProjectWithImage> getComplexProjectWithImageByProjectId(@Param("projectId") int projectId);
}
