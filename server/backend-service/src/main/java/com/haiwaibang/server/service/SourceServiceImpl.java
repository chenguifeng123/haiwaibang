package com.haiwaibang.server.service;

import com.haiwaibang.common.utils.CommUtils;
import com.haiwaibang.model.po.Doc;
import com.haiwaibang.model.po.DocExample;
import com.haiwaibang.model.po.Image;
import com.haiwaibang.model.po.ImageExample;
import com.haiwaibang.model.service.SourceService;
import com.haiwaibang.server.dao.DocMapper;
import com.haiwaibang.server.dao.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/14.
 */
@Component
public class SourceServiceImpl implements SourceService {

	@Autowired
	ImageMapper imageMapper;

	@Autowired
	DocMapper docMapper;

	public Image getImageById(int imageId) {
		return imageMapper.selectByPrimaryKey(imageId);
	}

	public Doc getDocById(int docId) {
		return docMapper.selectByPrimaryKey(docId);
	}

	public List<Image> getImageList(List<Integer> imageList) {
		if(CommUtils.collectionIsEmpty(imageList)) return null;
		ImageExample imageExample = new ImageExample();
		ImageExample.Criteria criteria = imageExample.createCriteria();
		criteria.andIdIn(imageList);
		return imageMapper.selectByExample(imageExample);
	}

	public List<Doc> getDocList(List<Integer> docList) {
		if(CommUtils.collectionIsEmpty(docList)) return null;
		DocExample docExample = new DocExample();
		DocExample.Criteria criteria = docExample.createCriteria();
		criteria.andIdIn(docList);
		return docMapper.selectByExample(docExample);
	}
}
