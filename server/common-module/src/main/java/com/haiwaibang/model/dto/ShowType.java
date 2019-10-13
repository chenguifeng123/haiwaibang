package com.haiwaibang.model.dto;

import com.haiwaibang.common.exception.GlobalProcessException;

/**
 * Created by chenguifeng on 2018/12/17.
 */
public enum ShowType {
	COMPUTER(0), MOBILE(1), ALL(-1);
	int type;

	public int getType() {
		return type;
	}

	ShowType(int type){
		this.type = type;
	}

	public static ShowType getShowType(int type){
		for(ShowType showType : values()){
			if(showType.type == type)
				return showType;
		}
		throw new GlobalProcessException(String.format("ShowType 类型不匹配 %d", type));
	}
}
