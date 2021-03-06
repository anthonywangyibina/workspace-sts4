/**
 * @项目名:wikin-file
 * @文件名:BpmController.java
 * @包名:com.dqgb.fileCenter.web
 * @描述 BpmController.java
 * @修改人 wenzhang
 * @修改时间:2018年5月21日下午3:45:51
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dqgb.common.service.IBpmBusinessCallbackService;
import com.dqgb.common.web.BaseController;

/**
 * ClassName:BpmController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年5月21日 下午3:45:51 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
@Controller
@EnableAutoConfiguration
@RestController
public class BpmBusinessController extends BaseController {
	
	@Resource
	private IBpmBusinessCallbackService callbackService;

	/* 前置事件 */
	@ResponseBody
	@RequestMapping(value = "/bpm/serviceBefore", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void serviceBefore(String json) {
		callbackService.serviceBefore(json);
	}

	/* 后置事件 */
	@ResponseBody
	@RequestMapping(value = "/bpm/serviceAfter", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void serviceAfter(String json) {
		callbackService.serviceAfter(json);
	}

}
