package com.haiwaibang.model.service;

import com.haiwaibang.model.po.Doc;
import com.haiwaibang.model.po.Image;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/14.
 */
public interface SourceService {

	Image getImageById(int imageId);
	Doc getDocById(int docId);

	List<Image> getImageList(List<Integer> imageList);
	List<Doc> getDocList(List<Integer> docList);
}
