package com.dqgb.common.vo;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.dqgb.common.constant.CommonConst;
import com.dqgb.common.utils.StringUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserVo {
	
	private String userId;//用户id
	
	private String userName;//用户名
	
	private String realName;//用户真实名称
	
	private String password;//密码
	
	private String telephone;//用户电话
	
	private String email;//用户邮箱
	
	private String departmentName;//部门名称
	
	private String departmentId;//部门id
	
	private String rfid;
	
	private String erpId;
	
	private String teamId;//班组id
	
	private String teamName;//班组名称
	
	private String address;//用户地址
	
	private Integer isRegionuser;

	//private String tenant;//租户标识
	
	private String ip;//用户登录时的ip
	
	private String language = CommonConst.INTERNATION._CHINESE ; //语言
	
	private String personImages;//个人头像
	
	private String electronicSign;//电子签名
    
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	public String getErpId() {
		return erpId;
	}

	public void setErpId(String erpId) {
		this.erpId = erpId;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getTenant() {
//		return tenant;
//	}
//
//	public void setTenant(String tenant) {
//		this.tenant = tenant;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getIsRegionuser() {
		return isRegionuser;
	}

	public void setIsRegionuser(Integer isRegionuser) {
		this.isRegionuser = isRegionuser;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPersonImages() {
		return personImages;
	}

	public void setPersonImages(String personImages) {
		this.personImages = personImages;
	}

	public String getElectronicSign() {
		return electronicSign;
	}

	public void setElectronicSign(String electronicSign) {
		this.electronicSign = electronicSign;
	}
	
	
	
}
