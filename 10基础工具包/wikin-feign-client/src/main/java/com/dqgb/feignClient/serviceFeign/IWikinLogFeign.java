package com.dqgb.feignClient.serviceFeign;

import com.dqgb.common.domain.BusinessLog;
import com.dqgb.common.response.ResponseData;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * wikin-log原始接口
 * 
 * @className IWikinLogFeign
 * @author :技术部-zhangjs
 * @Description
 * @date 2019年9月26日 下午11:06:04
 */
@FeignClient(value = "wikin-log")
public interface IWikinLogFeign {
	
	/**
	 * 保存业务日志
	 * @param businessLog 业务日志对象
	 * 				{dataId : "操作数据ID", operateIP : "操作第IP", operateName : "操作名" ,oprerateUser :"操作人",
	 *  				operateTime : "操作时间" ,operateDetail:"操作详细",businessType:"业务类型"}
	 * @return ResponseData
	 */
	@RequestMapping(value = "/log/businessLog", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData save(@RequestBody BusinessLog businessLog);

	
	/**
	 * 根据模板查询日志
	 * 根据分页信息，默认查询全部数据，当传入具体的一个或多个属性值时，则查询与其匹配的数据,
	 * @param businessLog
	 * @return ResponseData
	 */
	@RequestMapping(value = "/log/businessLogs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData findLog(@RequestBody BusinessLog businessLog, @RequestParam(value = "page") Integer page,
	        @RequestParam(value = "size") Integer size, @RequestParam(value = "sortProperty") String sortProperty,
	        @RequestParam(value = "sortDerect") String sortDerect);
}