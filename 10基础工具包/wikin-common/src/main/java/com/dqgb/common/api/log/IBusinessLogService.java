package com.dqgb.common.api.log;

import com.dqgb.common.domain.BusinessLog;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户日志service
 * @author yangmaoli
 * @version V1.0,2017年9月12日 下午2:11:16
 * @see [相关类/方法]
 * @since V1.0
 * 
*/
@FeignClient("wikin-log")
public interface IBusinessLogService {
	/**
     * 添加业务日志
     * @Title 添加业务日志
     * @author yangmaoli
     * @Description: 新增巡检项属性定义表数据,保存传入的巡检项属性定义表数据，并返回保存的结果描述
     * @date 2017年9月12日
     * @param bussnessLog
	 *  <pre>
	<b>请求类型</b>：Content-Type:application/json
	<b>请求地址</b>：/wikin-log/log/businessLog
	<b>请求方式</b>: POST
	<b>请求案例</b>
	 {
	      "dataId": "administrator",	===>"操作数据ID"
	      "operateIp": "10.114.73.31",	===> 操作地ip
	      "operateName": "登录平台",	===>操作：如删除用户、添加角色
	      "operateDetail": "administrator登录平台",	===>操作详情
	      "businessType": "认证登录",	===>所属业务：如角色管理、巡检记录等
	      "operateTime": 1567150668000,	===>操作时间
	      "modifyTime": null,	===>
	      "operateUser": "大庆金桥管理员(administrator)",	===>操作人姓名+账号：如，管理员(admin)
	      "bussinessCode": "wikin-identify",	===>所属业务编码
	      "applyCode": "jcpt",	===>所属应用编码
	      "applyName": "基础平台"	===>所属应用名
	  }
	 </pre>
     */
	  @RequestMapping(value = "/log/businessLog", method = RequestMethod.POST,produces =MediaType.APPLICATION_JSON_UTF8_VALUE)
	  public void save(@RequestBody BusinessLog bussnessLog);
     
}