package com.haiwaibang.api.controller.manage;

import com.haiwaibang.common.web.Result;
import com.haiwaibang.model.po.Country;
import com.haiwaibang.model.po.Project;
import com.haiwaibang.model.service.manage.CountryManageService;
import com.haiwaibang.model.service.manage.ProjectManageService;
import com.haiwaibang.model.service.manage.UploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by chenguifeng on 2018/11/8.
 */
@Api(value = "上传文件")
@CrossOrigin
@RestController
@RequestMapping("/manage")
public class FileUploadController {

	@Autowired
	UploadFileService uploadFileService;

	@Autowired
	ProjectManageService projectManageService;

	@Autowired
	CountryManageService countryManageService;


	private String separator(){
		//return File.separator;
		return "/";
	}

	private Result upload(MultipartFile file, String subPath){
		return Result.ok(uploadFileService.upload(file,  subPath + separator() +
				file.getOriginalFilename()));
	}

	/**
	 * 存放项目图片，考虑了一下还是用ID做目录，防止名称修改后关联不到
	 * @param path
	 * @param projectId
	 * @return
	 */
	private String getProjectPath(String path, int projectId){
		Project project = projectManageService.getProjectById(projectId);
		Country country = countryManageService.getCountryById(project.getCountryId());
		//return path + separator() + country.getName() + separator() + project.getName();
		return path + separator() + project.getCountryId() + separator() + projectId;
	}

	/**
	 * 存放国家图片，考虑了一下还是用ID做目录，防止名称修改后关联不到
	 * @param path
	 * @param countryId
	 * @return
	 */
	private String getCountryPath(String path, int countryId){
		Country country = countryManageService.getCountryById(countryId);
		//return path + separator() + country.getName();
		return  path + separator() + countryId;
	}

	@ApiOperation(value = "上传图片")
	@RequestMapping(value = "/upload/img/project/{projectId}", method = RequestMethod.POST)
	public Result uploadProjectPicture(@RequestParam("file") MultipartFile file, @PathVariable("projectId") int projectId){
		return upload(file, getProjectPath(UploadFileService.IMG_PATH, projectId));
	}

	@ApiOperation(value = "上传文档")
	@RequestMapping(value = "/upload/doc/project/{projectId}", method = RequestMethod.POST)
	public Result uploadProjectDoc(@RequestParam("file") MultipartFile file, @PathVariable("projectId") int projectId){
		return upload(file, getProjectPath(UploadFileService.DOC_PATH, projectId));
	}

	@ApiOperation(value = "上传图片")
	@RequestMapping(value = "/upload/img/country/{countryId}", method = RequestMethod.POST)
	public Result uploadCountryPicture(@RequestParam("file") MultipartFile file, @PathVariable("countryId") int countryId){
		return upload(file, getCountryPath(UploadFileService.IMG_PATH, countryId));
	}

	@ApiOperation(value = "上传文档")
	@RequestMapping(value = "/upload/doc/country/{countryId}", method = RequestMethod.POST)
	public Result uploadCountryDoc(@RequestParam("file") MultipartFile file, @PathVariable("countryId") int countryId){
		return upload(file, getCountryPath(UploadFileService.DOC_PATH, countryId));
	}

	@ApiOperation(value = "上传图片")
	@RequestMapping(value = "/upload/img/banner", method = RequestMethod.POST)
	public Result uploadBannerPicture(@RequestParam("file") MultipartFile file){
		return upload(file, UploadFileService.BANNER_PATH);
	}

}
