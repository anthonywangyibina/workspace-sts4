package com.dqgb.common.utils;

import com.dqgb.common.domain.BusinessLog;
import com.dqgb.common.utils.DateUtils;

/**
 * 创建业务日志实体公共方法
 * 
 * @author yangmaoli
 * @version V1.0,2018年2月9日 上午9:11:42
 * @see [相关类/方法]
 * @since V1.0
 * 
 */
public class BusinessLogCreate {
	/**
	 * @Title getBusinessLog
	 * @author yangmaoli
	 * @Description: 创建业务实体，将一个服务的公共内容提出
	 * @date 2018年2月9日
	 * @param ip
	 * @param username
	 * @return
	 */
	public static BusinessLog getBusinessLog(String ip, String username) {
		BusinessLog businessLog = new BusinessLog();
		businessLog.setOperateIp(ip);
		businessLog.setOperateUser(username);
		businessLog.setOperateTime(DateUtils.nowDate(DateUtils.YYYY_MM_DD_HHMMSS));
		return businessLog;
	}
}
