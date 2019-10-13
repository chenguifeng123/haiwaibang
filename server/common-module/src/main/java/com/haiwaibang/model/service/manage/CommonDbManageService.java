package com.haiwaibang.model.service.manage;

/**
 * Created by chenguifeng on 2018/12/5.
 * 通用对象处理, 针对通用的 单表操作, 没有检查和约束的处理
 */
public interface CommonDbManageService {
	Object addObject(String objectName, Object object);
	Object updateObject(String objectName, Object object);
	int deleteObject(String objectName, int objectId);
	Object getObjectById(String objectName, int objectId);
	boolean isObjectExists(String objectName, int objectId);
}
