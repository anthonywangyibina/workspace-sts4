/**
 * @项目名:wikin-bpm
 * @文件名:UserServiceImpl.java
 * @包名:com.dqgb.bpm.service.impl
 * @描述 UserServiceImpl.java
 * @修改人 wenzhang
 * @修改时间:2018年4月25日下午3:27:12
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dqgb.common.domain.BusinessLog;
import com.dqgb.common.service.ILogService;
import com.dqgb.common.service.IWikinLogService;
import com.dqgb.common.service.impl.BaseServiceImpl;
import com.dqgb.common.utils.BusinessLogCreate;


/**
 * ClassName:UserServiceImpl <br/>
 * Function: 和用户相关的调取服务层. <br/>
 * Date: 2018年4月25日 下午3:27:12 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
@Component
@Service
public class LogServiceImpl extends BaseServiceImpl implements ILogService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());// 日志

	@Autowired
	private IWikinLogService logService;

	
	/**
	 * 
	 * @Title saveBusinessLog
	 * @author :yangxi
	 * @Description 
	 * @date 2019年4月4日 下午3:19:29
	 * @param appCode
	 * @param appName
	 * @param businessCode
	 * @param businessName
	 * @param operateDetail
	 * @param operateName
	 * @param dataId
	 */
	@Override
	public void saveBusinessLog(String appCode,String appName,String businessCode,String businessName,String operateDetail, String operateName, String dataId) {
		BusinessLog businessLog = BusinessLogCreate.getBusinessLog(this.getUserIp(),this.getUser().getRealName()+"("+this.getUser().getUserName()+")");
		businessLog.setApplyCode(appCode);
		businessLog.setApplyName(appName);
		businessLog.setBussinessCode(businessCode);
		businessLog.setBusinessType(businessName);
		businessLog.setOperateDetail(operateDetail);
		businessLog.setOperateName(operateName);
		businessLog.setDataId(dataId);
		logService.save(businessLog);

	}

	

	

}
