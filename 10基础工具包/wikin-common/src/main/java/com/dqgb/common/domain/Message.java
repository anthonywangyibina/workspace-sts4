package com.dqgb.common.domain;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 短信、站内信通用记录实体
 * @author yangmaoli
 * @version V1.0,2017年8月14日 下午5:28:26
 * @see [相关类/方法]
 * @since V1.0
 *
 */
public class Message  implements Comparable{
	
	/**
	*  : 主键UUID
	*/ 
	@ApiModelProperty(value = "主键UUID")
	private String id;
	
	/**
	*  发送人/号码
	*/ 
	@ApiModelProperty(value = "发送人/号码")
	private String sender;
	
	/**
	* : 发送人姓名
	*/ 
	@ApiModelProperty(value = "发送人姓名")
	private String senderName;
	
	
	/**
	* 接收人/号码
	*/ 
	@ApiModelProperty(value = "接收人/号码")
	private String receiver;
	
	/**
	* 接收姓名
	*/ 
	@ApiModelProperty(value = "接收姓名")
	private String receiverName;
	
	/**
	* 内容
	*/ 
	@ApiModelProperty(value = "内容")
	private String content;
	
	/**
	*  客户端发送时间
	*/ 
	@ApiModelProperty(value = "客户端发送时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date clientSendTime;
	
	/**
	*  发送状态：0成功，1失败
	*/ 
	@ApiModelProperty(value = "发送状态：0成功，1失败")
	private Integer status;
	
	/**
	* 服务器成功/失败发送时间
	*/ 
	@ApiModelProperty(value = "服务器成功/失败发送时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date serverSendTime;
	
	/**
	* 类别：0短信1站内信（私信）
	*/ 
	@ApiModelProperty(value = "类别：0短信1站内信（私信）")
	private Integer catagery;
	
	/**
	*  读者账号集合
	*/ 
	@ApiModelProperty(value = "读者账号集合")
	private String readerAccounts;
	
	
	/**
	* 读者应具有的角色的编码，发给所有角色用0表示
	*/ 
	@ApiModelProperty(value = "读者应具有的角色的编码，发给所有角色用0表示")
	private String readerRoles;
	
	/**
	*读者所属的部门的编码，发给所有的部门用0表示；角色、组织之间按顺序维护一一对应的关系
	*/ 
	@ApiModelProperty(value = "读者所属的部门的编码，发给所有的部门用0表示；角色、组织之间按顺序维护一一对应的关系")
	private String readerOrgs;
	
	/**
	* 读者范围选择的类型：1指定的人2指定的部门3指定的角色4指定的角色和部门（交集）
	*/ 
	@ApiModelProperty(value = "读者范围选择的类型：1指定的人2指定的部门3指定的角色4指定的角色和部门（交集）")
	private Integer type;

	/**
	 * 站内置是否已读
	 */
	@ApiModelProperty(value = "是否已读  0：未读 1：已读")
	private Integer isRead;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCatagery() {
		return catagery;
	}

	public void setCatagery(Integer catagery) {
		this.catagery = catagery;
	}

	public Date getClientSendTime() {
		return clientSendTime;
	}

	public void setClientSendTime(Date clientSendTime) {
		this.clientSendTime = clientSendTime;
	}

	public Date getServerSendTime() {
		return serverSendTime;
	}

	public void setServerSendTime(Date serverSendTime) {
		this.serverSendTime = serverSendTime;
	}

	public String getReaderAccounts() {
		return readerAccounts;
	}

	public void setReaderAccounts(String readerAccounts) {
		this.readerAccounts = readerAccounts;
	}

	public String getReaderRoles() {
		return readerRoles;
	}

	public void setReaderRoles(String readerRoles) {
		this.readerRoles = readerRoles;
	}

	public String getReaderOrgs() {
		return readerOrgs;
	}

	public void setReaderOrgs(String readerOrgs) {
		this.readerOrgs = readerOrgs;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
	
	@Override
	public int compareTo(Object o) {
		try{
			if(o instanceof Message){
				Message emp = (Message) o;
				//按照时间排序
				if(emp.getClientSendTime().getTime()>this.clientSendTime.getTime()){
					return 1;
				}else if(emp.getClientSendTime().getTime()<this.clientSendTime.getTime()){
					return -1;
				}else{
					return 0;
				}
		    }
		}catch(Exception e){
			return 0;
		}
		throw new ClassCastException("对象不能转换为Message对象...");
	    
	}
}
