/**
 * @项目名:wikin-bpm
 * @文件名:DepartmentVo.java
 * @包名:com.dqgb.bpm.vo
 * @描述 DepartmentVo.java
 * @修改人 wenzhang
 * @修改时间:2018年4月25日上午11:16:52
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.vo;

/**
 * ClassName:DepartmentVo <br/>
 * Function: 部门对象. <br/>
 * Date: 2018年4月25日 上午11:16:52 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
public class DepartmentVo {

	private String id;// 部门主键

	private String name;// 部门名称

	private String description;// 部门描述

	private String fkDepartmentId;// 关联（上级）部门id

	private String fkDepartmentName;// 关联（上级）部门名称

	private String code;// 部门编码

	private String leaderId;// 主管领导账号

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFkDepartmentId() {
		return fkDepartmentId;
	}

	public void setFkDepartmentId(String fkDepartmentId) {
		this.fkDepartmentId = fkDepartmentId;
	}

	public String getFkDepartmentName() {
		return fkDepartmentName;
	}

	public void setFkDepartmentName(String fkDepartmentName) {
		this.fkDepartmentName = fkDepartmentName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}

}
