package com.haiwaibang.server.dao.multi;

import com.haiwaibang.model.po.multi.ComplexHotCountry;
import com.haiwaibang.model.po.multi.ComplexHotProject;

import java.util.List;

/**
 * Created by chenguifeng on 2018/12/4.
 */
public interface ComplexHotObjectMapper {
	List<ComplexHotCountry> listHotCountry(Integer showType);
	List<ComplexHotProject> listHotProject();
}
