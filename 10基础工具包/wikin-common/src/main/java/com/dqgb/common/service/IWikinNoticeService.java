/**
 * @项目名:wikin-common
 * @文件名:IWikinNoticeService.java
 * @包名:com.dqgb.common.service
 * @描述 IWikinNoticeService.java
 * @修改人 wenzhang
 * @修改时间:2018年2月5日下午5:20:06
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqgb.common.domain.Email;
import com.dqgb.common.domain.Message;
import com.dqgb.common.response.ResponseData;

/**
 * ClassName:IWikinNoticeService <br/>
 * Function: 公用通知中心路径方法. <br/>
 * Reason: 统一路径，调用公用. <br/>
 * Date: 2018年2月5日 下午5:20:06 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
@FeignClient("wikin-notice")
public interface IWikinNoticeService {

	/**
	 * @Description:发送邮件.
	 * @author wenzhang
	 * @date:2018年2月5日 下午5:23:05
	 * @Title:sendEmail
	 * @param email
	 * @return ResponseData:{rspMsg:"操作结果",data:"新增邮件id"}
	 * @since JDK 1.8
	 */
	@ResponseBody
	@RequestMapping(value = "/notice/emails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData sendEmail(@RequestBody Email email);
	
	/**
	 * 发送站内信、短信
	 * @Title sendMessage
	 * @author wenzhang
	 * @Description 发送站内信、短信
	 * @date 2018年6月7日 下午4:47:57
	 * @param message
	 * @return ResponseData
	 */
	@ResponseBody
	@RequestMapping(value = "/notice/messages", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData sendMessage(@RequestBody Message message);
}
