package com.dqgb.common.domain;

import java.util.Date;

/**
 * 用户日志实体
 * @author yangmaoli
 * @version V1.0,2017年9月12日 上午9:49:04
 * @see [相关类/方法]
 * @since V1.0
 * 
*/ 

public class BusinessLog {
	
	
	/**
	* 操作数据的ID:多个用逗号隔开
	*/ 
	private String dataId;
	
	/**
	* 操作地ip
	*/ 
	private String operateIp;
	
	/**
	* 操作：如删除用户、添加角色
	*/ 
	private String operateName;
	
	/**
	* 操作详情
	*/ 
	private String operateDetail;
	
	/**
	* 所属业务：如角色管理、巡检记录等
	*/ 
	private String businessType;
	
	/**
	* 操作时间
	*/ 
	private Date operateTime;
	

	
	/**
	* 操作人姓名+账号：如，管理员(admin)
	*/ 
	private String operateUser;
	
	/**
	 * 所属业务编码
	 */ 
	private String bussinessCode;
	
	/**
	 * 所属应用编码
	 */ 
	private String applyCode;
	
	/**
	 * 所属应用名
	 */ 
	private String applyName;

	

	


	public String getDataId() {
		return dataId;
	}
	
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	
	public String getOperateIp() {
		return operateIp;
	}
	
	public void setOperateIp(String operateIp) {
		this.operateIp = operateIp;
	}
	
	public String getOperateName() {
		return operateName;
	}
	
	
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	
	public String getOperateDetail() {
		return operateDetail;
	}
	
	public void setOperateDetail(String operateDetail) {
		this.operateDetail = operateDetail;
	}
	
	public String getBusinessType() {
		return businessType;
	}
	
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	
	public Date getOperateTime() {
		return operateTime;
	}
	
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	

	
	public String getOperateUser() {
		return operateUser;
	}
	
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	



	public String getBussinessCode() {
		return bussinessCode;
	}

	public void setBussinessCode(String bussinessCode) {
		this.bussinessCode = bussinessCode;
	}
	
	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}


	
	

}
