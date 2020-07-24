/**
 * @项目名:wikin-bpm
 * @文件名:IUserService.java
 * @包名:com.dqgb.bpm.service
 * @描述 IUserService.java
 * @修改人 wenzhang
 * @修改时间:2018年4月25日下午3:26:23
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.service;

import java.util.List;

import com.dqgb.common.response.ResponseData;
import com.dqgb.common.vo.DepartmentVo;
import com.dqgb.common.vo.RoleVo;
import com.dqgb.common.vo.UserVo;
/**
 * 查询用户信息公用service.
 *@className IUserService
 *@author wenzhang
 *@Description  查询用户信息公用service.
 *@date 2018年6月7日 下午4:37:01
 */
public interface ILogService {

	/**
	 * 添加日志
	 * @param appCode  应用编码
	 * @param appName  应用名称
	 * @param businessCode 服务编码
	 * @param businessName 服务名称
	 * @param operateDetail 操作详情
	 * @param operateName 操作名（标题）
	 * @param dataId 数据ID
	 */
	public void saveBusinessLog(String appCode,String appName,String businessCode,String businessName,String operateDetail, String operateName, String dataId);

	

}
