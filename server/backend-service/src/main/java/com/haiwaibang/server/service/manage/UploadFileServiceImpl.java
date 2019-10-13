package com.haiwaibang.server.service.manage;

import com.haiwaibang.common.utils.FileUtil;
import com.haiwaibang.common.utils.LoggerUtils;
import com.haiwaibang.model.service.manage.UploadFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenguifeng on 2018/11/9.
 */
// 以后可以注解类似 dubbo, 或者 cloud 的注解
@Component
public class UploadFileServiceImpl implements UploadFileService{

	@Value("${web.upload-path}")
	public String uploadPath;

	public Map<String, String> upload(MultipartFile file, String fileName){
		LoggerUtils.info(UploadFileServiceImpl.class, String.format("保存文件%s", fileName));
		String fullPath = uploadPath + File.separator + fileName;
		FileUtil.forceWriteUploadFile(fullPath, file);
		return new HashMap<String, String>(){{
			put("name", file.getOriginalFilename());
			put("url", fileName);
		}
		};
	}
}
