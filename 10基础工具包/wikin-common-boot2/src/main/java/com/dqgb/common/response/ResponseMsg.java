
package com.dqgb.common.response;

import java.util.EnumSet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.dqgb.common.config.LocaleMessageSourceUtil;

public enum ResponseMsg {
	
	
	
	SUCCESS("000000", "操作成功"), FAILED("999999", "操作失败"), ILLEGAL_PARAM("000001", "非法的参数"), NO_MAPPING_RESULT("000002",
			"没有对应的结果数据"), REF_OBJ_NOT_EXISIT("000003", "查询的数据不存在"), OBJ_BEEN_USED("000004", "已经被使用"), DELETE_FORBIDDEN(
					"000005", "不允许被删除"), MODIFY_FORBIDDEN("000006", "不允许被修改"), CLASS_CAST_ERROR("000007",
							"参数类型转换错误"), DATABASE_OPERATION_ERROR("000008", "数据库操作错误"), JWTTOKEN_EXPIRE("000009", "会话已过期");
	private String code;
	private String msg;
	private ResponseMsg(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	private LocaleMessageSourceUtil messageSource;
	
	public ResponseMsg setMessageSource(LocaleMessageSourceUtil messageSource) {
        this.messageSource = messageSource;
        return this;
    }
	
	 @Component
	 public static class ReportTypeServiceInjector {

	  @Autowired
	  private LocaleMessageSourceUtil messageSource;

	  @PostConstruct
	  public void postConstruct() {
	     for (ResponseMsg rt : EnumSet.allOf(ResponseMsg.class))
	           rt.setMessageSource(messageSource);
	        }
	  }
	
	
	public String getCode() {
		return code;
	}

	/**
     * @return the statusMsg，根据语言环境返回国际化字符串
     */
	@SuppressWarnings("static-access")
	public String getMsg() {
        return messageSource.getMessage(code,null);
	}
	

}
