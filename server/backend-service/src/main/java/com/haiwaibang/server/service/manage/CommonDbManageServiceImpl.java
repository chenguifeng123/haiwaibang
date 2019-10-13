package com.haiwaibang.server.service.manage;

import com.haiwaibang.common.exception.Error;
import com.haiwaibang.common.exception.GlobalProcessException;
import com.haiwaibang.common.utils.LoggerUtils;
import com.haiwaibang.config.SystemConfig;
import com.haiwaibang.model.service.manage.CommonDbManageService;
import com.haiwaibang.server.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by chenguifeng on 2018/12/5.
 */
@Component
public class CommonDbManageServiceImpl extends AbstractManageServiceImpl implements CommonDbManageService {

	@Autowired
	BannerMapper bannerMapper;

	@Autowired
	ArticleMapper articleMapper;

	@Autowired
	ExampleMapper exampleMapper;

	@Autowired
	CampaignMapper campaignMapper;

	@Autowired
	HotCountryMapper hotCountryMapper;

	@Autowired
	HotProjectMapper hotProjectMapper;

	@Autowired
	ImageMapper imageMapper;

	@Autowired
	DocMapper docMapper;

	@Autowired
	CountryMapper countryMapper;

	@Autowired
	ProjectMapper projectMapper;

	@Autowired
	ProjectDocSourceMapper projectDocSourceMapper;

	@Autowired
	CountryDocSourceMapper countryDocSourceMapper;

	@Autowired
	ProjectImageSourceMapper projectImageSourceMapper;

	@Autowired
	CountryImageSourceMapper countryImageSourceMapper;

	@Autowired
	CustomMapper customMapper;

	private ConcurrentHashMap mapperTable = new ConcurrentHashMap();

	private static enum CommonDbManageServiceError implements Error {

		E_CD000001("CD000001","新增失败"),
		E_CD000002("CD000002","修改失败"),
		E_CD000003("CD000003","删除失败"),
		E_CD000004("CD000004","不存在对应的处理类"),
		E_CD000005("CD000005","处理失败"),;

		String code;

		String msg;

		CommonDbManageServiceError(String code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		@Override
		public String code() {
			return code;
		}

		@Override
		public String msg() {
			return msg;
		}
	}

	private ConcurrentHashMap getMapperTable(){
		if(mapperTable.size() == 0) {
			synchronized (mapperTable) {
				mapperTable.put(SystemConfig.Banner, bannerMapper);
				mapperTable.put(SystemConfig.Article, articleMapper);
				mapperTable.put(SystemConfig.Example, exampleMapper);
				mapperTable.put(SystemConfig.Campaign, campaignMapper);
				mapperTable.put(SystemConfig.HotCountry, hotCountryMapper);
				mapperTable.put(SystemConfig.HotProject, hotProjectMapper);
				mapperTable.put(SystemConfig.Image, imageMapper);
				mapperTable.put(SystemConfig.Country, countryMapper);
				mapperTable.put(SystemConfig.Project, projectMapper);
				mapperTable.put(SystemConfig.Doc, docMapper);
				mapperTable.put(SystemConfig.ProjectDocSource, projectDocSourceMapper);
				mapperTable.put(SystemConfig.CountryDocSource, countryDocSourceMapper);
				mapperTable.put(SystemConfig.ProjectImageSource, projectImageSourceMapper);
				mapperTable.put(SystemConfig.CountryImageSource, countryImageSourceMapper);

				mapperTable.put(SystemConfig.Custom, customMapper);
			}
		}
		return mapperTable;
	}

	private Object getMapperByObjectName(String objectName){
		Object mapper = getMapperTable().get(objectName);
		if(mapper == null) throw new GlobalProcessException(CommonDbManageServiceError.E_CD000004);
		return mapper;
	}

	private Object invoke(String objectName, Object object, String methodName, CommonDbManageServiceError error) {
		Object mapper = getMapperByObjectName(objectName);
		return daoOperate(object, (Object o) ->{
			Method m = mapper.getClass().getMethod(methodName, o.getClass());
			Object result = m.invoke(mapper, o);
			return Integer.parseInt(result.toString());
		}, error);
	}

	public Object addObject(String objectName, Object object) {
		return invoke(objectName, object, "insert", CommonDbManageServiceError.E_CD000001);
	}

	public Object updateObject(String objectName, Object object) {
		return invoke(objectName, object, "updateByPrimaryKey", CommonDbManageServiceError.E_CD000002);
	}

	public int deleteObject(String objectName, int objectId) {
		Object result = invoke(objectName, objectId, "deleteByPrimaryKey", CommonDbManageServiceError.E_CD000003);
		return Integer.parseInt(result.toString());
	}

	public Object getObjectById(String objectName, int objectId) {
		Object mapper = getMapperByObjectName(objectName);
		try {
			Method m = mapper.getClass().getMethod("selectByPrimaryKey", Integer.class);
			return m.invoke(mapper, objectId);
		}catch (Exception e){
			LoggerUtils.error(CommonDbManageServiceImpl.class, e.getMessage(), e);
			throw new GlobalProcessException(CommonDbManageServiceError.E_CD000005);
		}
	}

	public boolean isObjectExists(String objectName, int objectId) {
		return getObjectById(objectName, objectId) != null;
	}
}
