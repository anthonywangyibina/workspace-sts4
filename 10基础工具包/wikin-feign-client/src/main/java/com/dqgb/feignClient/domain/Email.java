package com.dqgb.feignClient.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 *	 邮件信息实体
 *@className Email
 *@author :技术部-zhangjs
 *@Description  邮件信息实体
 *@date 2019年9月23日 下午1:53:01
 */
@Data
public class Email {

	/**
	 * 主键uuid
	 */
	private String id;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 主题
	 */
	private String subject;
	/**
	 * 邮件内容
	 */
	private String content;

	/**
	 * 发送人账号
	 */
	private String senderAccount;

	/**
	 * 发件人姓名
	 */
	private String senderName;

	/**
	 * 收件人账号
	 */
	private String receiverAccounts;

	/**
	 * 抄送人账号
	 */
	private String ccAccounts;

	/**
	 * 发送时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date sendTime;

	/**
	 * 接收时间
	 */
	private Date receiveTime;

	/**
	 * 附件URL
	 */
	private String attachUrl;

	/**
	 * 发送状态：0草稿1发送成功2发送失败
	 */
	private Integer status;

}
