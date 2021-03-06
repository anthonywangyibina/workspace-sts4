package com.dqgb.common.response;

import com.dqgb.common.config.LocaleMessageSourceUtil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Response", description = "数据返回基类")
public class Response {
	@ApiModelProperty(value = "返回信息码,默认:000000")
	private String rspCode = "000000";
	@ApiModelProperty(value = "返回信息内容，默认:操作成功")
	private String rspMsg=LocaleMessageSourceUtil.getMessage("000000");
	//= "操作成功";

	/**
	 * 
	 * Creates a new instance of Response.
	 *
	 */
	public Response() {
	}

	/**
	 * 
	 * Creates a new instance of Response.
	 *
	 * @param msg
	 */
	public Response(ResponseMsg msg) {
		this.rspCode = msg.getCode();
		this.rspMsg = msg.getMsg();
	}

	/**
	 * 
	 * Creates a new instance of Response.
	 *
	 * @param rspCode
	 */
	public Response(String rspCode) {
		this.rspCode = rspCode;
		this.rspMsg = "";
	}

	/**
	 * 
	 * Creates a new instance of Response.
	 *
	 * @param rspCode
	 * @param rspMsg
	 */
	public Response(String rspCode, String rspMsg) {
		this.rspCode = rspCode;
		this.rspMsg = rspMsg;
	}

	public String getRspCode() {
		return rspCode;
	}

	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}

	public String getRspMsg() {
		return rspMsg;
	}

	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}

	@Override
	public String toString() {
		return "Response{" + "rspCode='" + rspCode + '\'' + ", rspMsg='" + rspMsg + '\'' + '}';
	}
}
