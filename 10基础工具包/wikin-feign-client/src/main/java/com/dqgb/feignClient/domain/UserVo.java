package com.dqgb.feignClient.domain;

import lombok.Data;

/**
 * 用户包装类
 * 
 * @className UserVo
 * @author :技术部-zhangjs
 * @Description
 * @date 2019年9月26日 下午11:28:54
 */
@Data
public class UserVo {
	/**
	 * 用户Id
	 */
	private String userId;
	/**
	 * 用户名（账号）
	 */
	private String userName;
	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 邮件
	 */
	private String email;
	/**
	 * 部门（或者组织）名称
	 */
	private String departmentName;
	/**
	 * 部门（或者组织）id
	 */
	private String departmentId;
	/**
	 * rfid
	 */
	private String rfid;
	/**
	 * erpId
	 */
	private String erpId;
	/**
	 * 组队id
	 */
	private String teamId;
	/**
	 * 组队名称
	 */
	private String teamName;
	/**
	 * 地址
	 */
	private String address;
	private Integer isRegionuser;
	/**
	 * 用户当前ip地址
	 */
	private String ip;
	private String language = "zh_CN";
}