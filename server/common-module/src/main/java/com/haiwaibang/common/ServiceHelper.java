package com.haiwaibang.common;

import com.haiwaibang.common.utils.LoggerUtils;
import com.haiwaibang.common.utils.StringUtils;
import com.haiwaibang.config.SystemConfig;
import com.haiwaibang.model.dto.QueryInfo;
import com.haiwaibang.model.po.Banner;

import java.beans.PropertyDescriptor;
import java.util.Collection;

/**
 * Created by chenguifeng on 2018/11/14.
 */
public class ServiceHelper {

	public static <T> T getSimpleDataByCollection(Collection<T> collections) {
		if (collections == null || collections.size() == 0) return null;
		return collections.iterator().next();
	}

	static enum Attach{
		Campaign(0), Article(1), Example(2);
		int type;
		Attach(int type){
			this.type = type;
		}

		static Attach getAttach(int type){
			for(Attach attach : values())
				if (attach.type == type)
					return attach;
			return Campaign;
		}
	}

	public static Banner fillBanner(Banner banner){
		String path = SystemConfig.Campaign;
		switch (Attach.getAttach(banner.getAttachType())){
			case Campaign: path = SystemConfig.Campaign; break;
			case Article: path = SystemConfig.Article; break;
			case Example: path = SystemConfig.Example; break;
		}
		banner.setUrl(String.format("/%s/%d", path ,banner.getAttachId()));
		return banner;
	}

	public static <T> T fillUrl(T t){
		try {
			PropertyDescriptor descriptor = new PropertyDescriptor("url", t.getClass());
			String url = descriptor.getReadMethod().invoke(t).toString();
			if(!url.startsWith("/")) {
				url = "/" + url;
				descriptor.getWriteMethod().invoke(t, url);
			}
		}catch (Exception e){
			LoggerUtils.error(ServiceHelper.class, "设置url失败", e);
		}
		return t;
	}

	/**
	 * 对html模块统一处理
	 * @param t
	 * @param <T>
	 * @return
	 */
	public static <T> T fillHtml(T t){
		try {
			PropertyDescriptor descriptor = new PropertyDescriptor("contents", t.getClass());
			String contents = descriptor.getReadMethod().invoke(t).toString();

			String [] images = StringUtils.getImgaddress(contents);
			String imageUrl = images != null && images.length > 0 ? images[0] : SystemConfig.DEFAULT_IMG;
			String summary = StringUtils.html2Text(contents);

			new PropertyDescriptor("imageUrl", t.getClass()).getWriteMethod().invoke(t, imageUrl);
			new PropertyDescriptor("summary", t.getClass()).getWriteMethod().invoke(t, summary);
		}catch (Exception e){
			LoggerUtils.error(ServiceHelper.class, "抽取html元素失败", e);
		}
		return t;
	}

	public static QueryInfo getQueryListByPage(){
		QueryInfo queryInfo = new QueryInfo();
		queryInfo.setPageNo(LAST_PAGE);
		queryInfo.setPageSize(PAGE_SIZE);
		return queryInfo;
	}

	private static final int PAGE_SIZE = 6;
	private static final int LAST_PAGE = 1;
}
