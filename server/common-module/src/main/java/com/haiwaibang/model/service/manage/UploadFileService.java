package com.haiwaibang.model.service.manage;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by chenguifeng on 2018/11/9.
 * 针对上传文件的专门服务
 */
public interface UploadFileService {
	public static final String IMG_PATH = "imgfile";
	public static final String DOC_PATH = "docfile";
	public static final String BANNER_PATH = "banner";

	public Map<String, String> upload(MultipartFile file, String fileName);

}
