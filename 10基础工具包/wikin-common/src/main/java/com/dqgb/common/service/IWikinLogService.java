package com.dqgb.common.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dqgb.common.domain.BusinessLog;

/**
 * 用户日志service
 * 
 * @author yangmaoli
 * @version V1.0,2017年9月12日 下午2:11:16
 * @see [相关类/方法]
 * @since V1.0
 * 
 */
@FeignClient("wikin-log")
public interface IWikinLogService {
	/**
	 * 服务之间异步保存业务日志
	 * 
	 * @Title save
	 * @author yangmaoli
	 * @Description: 保存业务日志
	 * @date 2017年9月12日
	 * @param businessLog
	 *            {dataId : "操作数据ID", operateIP : "操作第IP", operateName : "操作名",
	 *            oprerateUser : "操作人", operateTime : "操作时间"
	 *            ,operateDetail:"操作详细",businessType:"业务类型",businessCode:"业务编码",applyCode:"应用编码",applyName:"应用名",isDeleted
	 *            : "是否删除: 0 不删除，1 删除"}
	 * @param tenant
	 *            租户标识
	 */
	@Async
	@RequestMapping(value = "/log/businessLog", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void save(@RequestBody BusinessLog businessLog);

}
