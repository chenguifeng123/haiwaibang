package com.haiwaibang.api.controller.manage;

import com.haiwaibang.common.web.Result;
import com.haiwaibang.config.SystemConfig;
import com.haiwaibang.model.po.Doc;
import com.haiwaibang.model.po.Image;
import com.haiwaibang.model.service.manage.CommonDbManageService;
import com.haiwaibang.common.ServiceHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenguifeng on 2018/12/5.
 */
@RestController
@Api(value = "资源处理")
@RequestMapping("/manage")
public class SourceManageController {

	@Autowired
	CommonDbManageService commonDbManageService;

	@ApiOperation("增加Image资源")
	@RequestMapping(value = "/image", method = RequestMethod.PUT)
	public Result addImage(@RequestBody Image image){
		image = ServiceHelper.fillUrl(image);
		return Result.ok(commonDbManageService.addObject(SystemConfig.Image, image));
	}

	@ApiOperation("修改Image资源")
	@RequestMapping(value = "/image/{id}", method = RequestMethod.POST)
	public Result updateImage(@PathVariable("id") int id, @RequestBody Image image){
		image = ServiceHelper.fillUrl(image);
		return Result.ok(commonDbManageService.updateObject(SystemConfig.Image, image));
	}

	@ApiOperation("删除Image资源")
	@RequestMapping(value = "/image/{id}", method = RequestMethod.DELETE)
	public Result deleteImage(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.addObject(SystemConfig.Image, id));
	}

	@ApiOperation("获取Image资源")
	@RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
	public Result getImageById(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.getObjectById(SystemConfig.Image, id));
	}


	@ApiOperation("增加Doc资源")
	@RequestMapping(value = "/doc", method = RequestMethod.PUT)
	public Result addDoc(@RequestBody Doc doc){
		doc = ServiceHelper.fillUrl(doc);
		return Result.ok(commonDbManageService.addObject(SystemConfig.Doc, doc));
	}

	@ApiOperation("修改Doc资源")
	@RequestMapping(value = "/doc/{id}", method = RequestMethod.POST)
	public Result updateDoc(@PathVariable("id") int id, @RequestBody Doc doc){
		doc = ServiceHelper.fillUrl(doc);
		return Result.ok(commonDbManageService.updateObject(SystemConfig.Doc, doc));
	}

	@ApiOperation("删除Doc资源")
	@RequestMapping(value = "/doc/{id}", method = RequestMethod.DELETE)
	public Result deleteDoc(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.deleteObject(SystemConfig.Doc, id));
	}

	@ApiOperation("获取Doc资源")
	@RequestMapping(value = "/doc/{id}", method = RequestMethod.GET)
	public Result getDocById(@PathVariable("id") int id){
		return Result.ok(commonDbManageService.getObjectById(SystemConfig.Doc, id));
	}


}
