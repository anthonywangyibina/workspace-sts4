package com.dqgb.feignClient.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
/**
 *  短信、站内信实体
 *@className Notice
 *@author :技术部-zhangjs
 *@Description  短信、站内信实体
 *@date 2019年9月23日 下午1:58:51
 */
@Data
public class Notice {
	
	/**
	*  : 主键UUID
	*/ 
	private String id;
	
	/**
	*  发送人/号码
	*/ 
	private String sender;
	
	/**
	* : 发送人姓名
	*/ 
	private String senderName;
	
	
	/**
	* 接收人/号码
	*/ 
	private String receiver;
	
	/**
	* 接收姓名
	*/ 
	private String receiverName;
	
	/**
	* 内容
	*/ 
	private String content;
	
	/**
	*  客户端发送时间
	*/ 
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date clientSendTime;
	
	/**
	*  发送状态：0成功，1失败
	*/ 
	private Integer status;
	
	/**
	* 服务器成功/失败发送时间
	*/ 
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date serverSendTime;
	
	/**
	* 类别：0短信1站内信（私信）
	*/ 
	private Integer catagery;
	
	/**
	*  读者账号集合
	*/ 
	private String readerAccounts;
	
	
	/**
	* 读者应具有的角色的编码，发给所有角色用0表示
	*/ 
	private String readerRoles;
	
	/**
	*读者所属的部门的编码，发给所有的部门用0表示；角色、组织之间按顺序维护一一对应的关系
	*/ 
	private String readerOrgs;
	
	/**
	* 读者范围选择的类型：1指定的人2指定的部门3指定的角色4指定的角色和部门（交集）
	*/ 
	private Integer type;
	/**
	 * 消息查询默认查询第一页的数据
	 */
	private Integer page =0;
	/**
	 * 消息查询默认查询15条数据
	 */
	private Integer size=15;

}
