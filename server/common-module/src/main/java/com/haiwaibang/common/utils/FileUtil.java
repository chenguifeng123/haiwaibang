package com.haiwaibang.common.utils;

import com.haiwaibang.common.exception.GlobalProcessException;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by chenguifeng on 2018/11/9.
 */
public class FileUtil {

	public static void writeFile(String fileName, byte[] bytes) throws IOException{
		File savedFile = new File(fileName);
		FileUtils.writeByteArrayToFile(savedFile, bytes);

	}

	public static void forceWriteFile(String fileName, byte[] bytes) throws IOException{
		File savedFile = new File(fileName);
		if(savedFile.exists()) FileUtils.forceDelete(savedFile);
		File filePath = savedFile.getParentFile();
		if(!filePath.exists()) FileUtils.forceMkdir(filePath);
		FileUtils.writeByteArrayToFile(savedFile, bytes);
	}

	public static void forceWriteUploadFile(String fileName, MultipartFile file){
		try {
			forceWriteFile(fileName, file.getBytes());
		}catch (IOException e){
			String msg = "文件%s保存失败 ";
			LoggerUtils.fmtError(FileUtil.class, e, msg, fileName);
			throw new GlobalProcessException(String.format(msg, fileName));
		}
	}

	public static void forceRefreshDir(String pathName){
		try {
			File file = new File(pathName);
			if(file.exists()) return;
			if (file.isDirectory()) {
				FileUtils.forceMkdir(file);
			} else {
				FileUtils.forceMkdir(file.getParentFile());
			}
		}catch (Exception e){
			LoggerUtils.fmtError(FileUtil.class, e, e.getMessage());
			throw new GlobalProcessException(e.getMessage());
		}
	}
}
