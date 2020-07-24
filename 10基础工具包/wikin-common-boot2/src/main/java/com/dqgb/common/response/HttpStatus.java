
package com.dqgb.common.response;

import java.util.EnumSet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dqgb.common.config.LocaleMessageSourceUtil;

/**
 * 自定义Http响应状态码
 *@className HttpStatus
 *@author :yangxi
 *@Description  
 *@date 2019年11月5日 下午4:07:55
 */
public enum HttpStatus {
	NOT_AUTHORIZED(491, "没有权限"), JWTTOKEN_EXPIRE(492, "会话过期");
	private HttpStatus(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private Integer code;
	private String msg;

	private LocaleMessageSourceUtil messageSource;
	
	public HttpStatus setMessageSource(LocaleMessageSourceUtil messageSource) {
        this.messageSource = messageSource;
        return this;
    }
	
	 @Component
	 public static class ReportTypeServiceInjector {

	  @Autowired
	  private LocaleMessageSourceUtil messageSource;

	  @PostConstruct
	  public void postConstruct() {
	     for (HttpStatus rt : EnumSet.allOf(HttpStatus.class))
	           rt.setMessageSource(messageSource);
	        }
	    }
	
	
	
	public Integer getCode() {
		return code;
	}

//	public String getMsg() {
//		return msg;
//	}

	
	/**
     * @return the statusMsg，根据语言环境返回国际化字符串
     */
	@SuppressWarnings("static-access")
	public String getMsg() {
        return messageSource.getMessage(code.toString(),null);
	}
	
}
