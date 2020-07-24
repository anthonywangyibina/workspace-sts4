/**
 * @项目名:wikin-bpm
 * @文件名:IWikinAppService.java
 * @包名:com.dqgb.bpm.service
 * @描述 IWikinAppService.java
 * @修改人 wenzhang
 * @修改时间:2018年5月23日下午4:35:36
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.feignClient.serviceFeign;

import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dqgb.common.response.ResponseData;

/**
 * ClassName:IWikinAppService <br/>
 * Function: 获取应用服务名. <br/>
 * Date: 2018年5月23日 下午4:35:36 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
@FeignClient(name="wikin-app")
public interface IWikinAppFeign {

	/**
	 * 
	 * 获取应用下的全部服务.
	 * @param applicationCodes
	 *            应用编码，多个以,相连
	 * @return ResponseData
	 */
	@RequestMapping(value = "/appRec/applicationCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData queryApplications(@RequestParam(value = "applicationCodes") String applicationCodes);

	/**
	 * 根据应用编码获取应用 ，多个编码以","分隔
	 * @Title queryAppByCodes 
	 * @param applicationCodes 应用编码
	 * @return ResponseData
	 */
	
	@RequestMapping(value = "/appRec/queryappByCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData queryAppByCodes(@RequestParam(value = "applicationCodes") String applicationCodes);
}
