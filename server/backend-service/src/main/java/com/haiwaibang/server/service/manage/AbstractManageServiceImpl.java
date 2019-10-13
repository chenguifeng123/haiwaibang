package com.haiwaibang.server.service.manage;

import com.haiwaibang.common.exception.GlobalProcessException;
import com.haiwaibang.common.utils.LoggerUtils;
import com.haiwaibang.common.exception.Error;

/**
 * Created by chenguifeng on 2018/11/27.
 */
public abstract class AbstractManageServiceImpl {

	public interface ExecuteDaoOperate<T>{
		public int operate(T t) throws Exception;
	}

	/**
	 * 数据库的 DDL 操作
	 * @param t
	 * @param execute
	 * @param error
	 * @param <T>
	 * @return
	 */
	public <T> T daoOperate(T t, ExecuteDaoOperate<T> execute, Error error){
		LoggerUtils.info(AbstractManageServiceImpl.class, "执行操作----------------");
		try {
			int result = execute.operate(t);
			LoggerUtils.fmtInfo(AbstractManageServiceImpl.class, "操作结果 %d", result);
			return t;
		}catch (Exception e){
			LoggerUtils.error(AbstractManageServiceImpl.class, "操作失败", e);
			throw new GlobalProcessException(error);
		}
	}
}
