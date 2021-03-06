/**
 * @项目名:wikin-common
 * @文件名:UtilServiceImpl.java
 * @包名:com.dqgb.common.service.impl
 * @描述 UtilServiceImpl.java
 * @修改人 wenzhang
 * @修改时间:2018年3月6日下午4:22:48
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dqgb.common.domain.BusinessLog;
import com.dqgb.common.domain.Email;
import com.dqgb.common.response.ResponseData;
import com.dqgb.common.service.IApiService;
import com.dqgb.common.service.IWikinDatacenterService;
import com.dqgb.common.service.IWikinFileServie;
import com.dqgb.common.service.IWikinLogService;
import com.dqgb.common.service.IWikinNoticeService;

/**
 * ClassName:UtilServiceImpl <br/>
 * Function: 公用路径服务层实现类. <br/>
 * Date: 2018年3月6日 下午4:22:48 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
@Component
@Service
public class ApiServiceImpl implements IApiService {

	@Autowired
	private IWikinFileServie fileService;

	@Autowired
	private IWikinNoticeService noticeService;

	@Autowired
	private IWikinLogService logService;

	@Autowired
	private IWikinDatacenterService dataService;

	@Override
	public void downFiles(List<String> ids) {
		fileService.downloadFiles(ids);
	}

	@Override
	public void download(List<String> businessIds) {
		fileService.download(businessIds);
	}

	@Override
	public ResponseData uploadFiles(String filePath, String userId, String businessId, String description, String type,
			HttpServletRequest request) {
		return fileService.uploadFiles(filePath, userId, businessId, description, type, request);
	}

	@Override
	public ResponseData getFileDetail(String businessId, int page, int size) {
		return fileService.getFileDetail(businessId, page, size);
	}

	@Override
	public ResponseData getFileDetails(List<String> businessIds) {
		return fileService.getFileDetails(businessIds);
	}

	@Override
	public ResponseData sendEmail(Email email) {
		return noticeService.sendEmail(email);
	}

	@Override
	public void saveLog(BusinessLog businessLog) {
		logService.save(businessLog);
	}

	@Override
	public ResponseData findTreeData(Integer page, Integer size, String childSortProperty, String childSortDerect,
			String parentSortProperty, String parentSortDerect, String modelParentCode, String modelChildCode,
			String treeParentNameField, String treeChildNameField, String treeChildNameFieldValue,
			String parentDataId) {
		return dataService.findTreeData(page, size, childSortProperty, childSortDerect, parentSortProperty,
				parentSortDerect, modelParentCode, modelChildCode, treeParentNameField, treeChildNameField,
				treeChildNameFieldValue, parentDataId);
	}

	@Override
	public ResponseData findChildrenByParentCode(Integer page, Integer size, String sortProperty, String sortDerect,
			String modelCode, String parentDataId, String fields) {
		return dataService.findChildrenByParentCode(page, size, sortProperty, sortDerect, modelCode, parentDataId,
				fields);
	}

	@Override
	public ResponseData findByStringFilter(Integer page, Integer size, String sortProperty, String sortDerect,
			String modelId, String modelCode, String filterJson, String fields) {
		return dataService.findByStringFilter(page, size, sortProperty, sortDerect, modelId, modelCode, filterJson, fields);
	}

}
