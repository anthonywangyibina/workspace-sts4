package com.dqgb.feignClient.serviceFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dqgb.common.response.ResponseData;

@FeignClient("wikin-identify")
public interface IWikinIdentifyFeign {
	/**
	 * 通过token来获取登录的账号
	 * @Title getUserNameByToken
	 * @param token 令牌
	 * @return ResponseData
	 */
	@RequestMapping(value = "/reset/endoceToken", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData getUserNameByToken(@RequestParam("token")String token);
	
	/**
	 * 通过登录的用户名、密码和验证码来获取token
	 * @Title getTokenByUserNameAndPasswordAndCode
	 * @param verificationcode 验证码
	 * @param username 用户名
	 * @param password 密码
	 * @return ResponseData
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData getTokenByUserNameAndPasswordAndCode(@RequestParam("verificationcode")String verificationcode,
			@RequestParam("username")String username,@RequestParam("password")String password);
	
}
