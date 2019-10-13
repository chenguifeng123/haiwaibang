package com.haiwaibang.api.controller.manage;

/**
 * Created by chenguifeng on 2018/12/7.
 */

import com.haiwaibang.config.SystemConfig;
import com.haiwaibang.ueditor.ActionEnter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


@RestController
@CrossOrigin
@RequestMapping("/ueditor")
public class UeditorController {

	@Value("${web.upload-path}")
	public String uploadPath;

	@RequestMapping(value = "/exec")
	@ResponseBody
	public String exec(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String rootPath = request.getRealPath("/");
		request.setAttribute(SystemConfig.UPLOAD_PARAM, uploadPath);
		//String rootPath = request.getSession().getServletContext().getRealPath("/");
		return new ActionEnter( request, rootPath).exec();
	}
}
