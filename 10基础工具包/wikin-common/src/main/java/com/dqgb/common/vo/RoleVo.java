package com.dqgb.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * ClassName: Role <br/>
 * Function: 权限中心的角色对象. <br/>
 * date: 2018年4月24日 下午4:29:19 <br/>
 *
 * @author wenzhang
 * @version
 * @see [相关类/方法]
 * @Description:
 * @since JDK 1.8
 */
public class RoleVo {

	@ApiModelProperty(value = "主键ID")
	private String id;

	@ApiModelProperty(value = "角色名称")
	private String roleName;

	@ApiModelProperty(value = "角色编码")
	private String code;

	@ApiModelProperty(value = "资源权限")
	private String rightsResource;

	@ApiModelProperty(value = "角色可以使用的系统")
	private Integer rightsSys;

	@ApiModelProperty(value = "角色所属的系统")
	private String roleSys;

	@ApiModelProperty(value = "角色是否为超级管理员")
	private Integer roleIsSys;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "最后修改时间")
	private Date modifyTime;

	@ApiModelProperty(value = "创建人")
	private String operatePerson;

	@ApiModelProperty(value = "说明")
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRightsResource() {
		return rightsResource;
	}

	public void setRightsResource(String rightsResource) {
		this.rightsResource = rightsResource;
	}

	public Integer getRightsSys() {
		return rightsSys;
	}

	public void setRightsSys(Integer rightsSys) {
		this.rightsSys = rightsSys;
	}

	public String getRoleSys() {
		return roleSys;
	}

	public void setRoleSys(String roleSys) {
		this.roleSys = roleSys;
	}

	public Integer getRoleIsSys() {
		return roleIsSys;
	}

	public void setRoleIsSys(Integer roleIsSys) {
		this.roleIsSys = roleIsSys;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getOperatePerson() {
		return operatePerson;
	}

	public void setOperatePerson(String operatePerson) {
		this.operatePerson = operatePerson;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
