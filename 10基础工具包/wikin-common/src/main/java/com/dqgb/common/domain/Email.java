/**  
* @文件名 EmailRec.java
* @版权 Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
* @描述 邮件记录实体
* @修改人 Mr.Wang
* @修改时间 2017年6月1日 下午4:07:18
* @修改内容 新增
*/
package com.dqgb.common.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 邮件记录实体
 * 
 * @author yangmaoli
 * @version V1.0,2017年8月14日 下午5:27:59
 * @see [相关类/方法]
 * @since V1.0
 *
 */
public class Email {

	/**
	 * 主键uuid
	 */
	@ApiModelProperty(value = "主键uuid")
	private String id;

	/**
	 * 标题
	 */
	@ApiModelProperty(value = "标题")
	private String title;

	/**
	 * 主题
	 */
	@ApiModelProperty(value = "主题")
	private String subject;

	@ApiModelProperty(value = "内容/正文")
	private String content;

	/**
	 * 发送人账号
	 */
	@ApiModelProperty(value = "发送人账号")
	private String senderAccount;

	/**
	 * 发件人姓名
	 */
	@ApiModelProperty(value = "发件人姓名")
	private String senderName;

	/**
	 * 收件人账号
	 */
	@ApiModelProperty(value = "收件人账号")
	private String receiverAccounts;

	/**
	 * 抄送人账号
	 */
	@ApiModelProperty(value = "抄送人账号")
	private String ccAccounts;

	/**
	 * 发送时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "发送时间")
	private Date sendTime;

	/**
	 * 接收时间
	 */
	@ApiModelProperty(value = "接收时间")
	private Date receiveTime;

	/**
	 * 附件URL
	 */
	@ApiModelProperty(value = "附件URL")
	private String attachUrl;

	/**
	 * 发送状态：0草稿1发送成功2发送失败
	 */
	@ApiModelProperty(value = "发送状态：0草稿1发送成功2发送失败")
	private Integer status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSenderAccount() {
		return senderAccount;
	}

	public void setSenderAccount(String senderAccount) {
		this.senderAccount = senderAccount;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverAccounts() {
		return receiverAccounts;
	}

	public void setReceiverAccounts(String receiverAccounts) {
		this.receiverAccounts = receiverAccounts;
	}

	public String getCcAccounts() {
		return ccAccounts;
	}

	public void setCcAccounts(String ccAccounts) {
		this.ccAccounts = ccAccounts;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getAttachUrl() {
		return attachUrl;
	}

	public void setAttachUrl(String attachUrl) {
		this.attachUrl = attachUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
