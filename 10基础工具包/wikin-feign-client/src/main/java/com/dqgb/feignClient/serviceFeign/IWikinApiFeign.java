//package com.dqgb.feignClient.serviceFeign;
//
//import java.util.Map;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.dqgb.common.response.ResponseData;
//
//@FeignClient("wikin-api")
//public interface IWikinApiFeign {
//	@RequestMapping(value="/api/requests/{apiCode}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
//	Object  findTreeDataByCode(@PathVariable(value = "apiCode") String apiCode,@RequestBody(required = false) Map<String, Object> bodyParams,@RequestHeader(value = "jwtToken")String jwtToken);
//
//}
