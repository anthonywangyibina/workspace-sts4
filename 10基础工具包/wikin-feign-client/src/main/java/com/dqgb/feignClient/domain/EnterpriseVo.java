package com.dqgb.feignClient.domain;

import java.io.Serializable;
import java.util.List;

public class EnterpriseVo implements Serializable{
	private static final long serialVersionUID = 3148176768559230877L;

	/** 企业组织机构管理表主键ID */
	private java.lang.String id;
	/** 上级企业ID */
	private java.lang.String fkEnterpriseId;
	/** 企业名称 */
	private java.lang.String enterpriseNameShort;
	/** 企业全称 */
	private java.lang.String enterpriseNameFull;
	/** 排序，即显示顺序 */
	private java.lang.Integer disOrder;
	/** 有效标识：0 否，1 是 */
	private java.lang.Integer isAbled;
	/** 备注 */
	private java.lang.String remarks;
	/** 创建人 */
	private java.lang.String userRealnameCreate;
	/** 创建人ID */
	private java.lang.String fkUserIdCreate;
	/** 创建时间 */
	private java.util.Date createDateBegin;
	private java.util.Date createDateEnd;
	private java.lang.String createDate;
	/** 分管领导 */
	private String leader;

	/** 分管领导名称 */
	private String leaderName;

	/**
	 * 企业代码：ENTERPRISE_Code
	 */
	private java.lang.String enterpriseCode;

	private java.lang.String erpCode;

	/** 企业级别：0 公司，1 组织 */
	private java.lang.Integer enterpriseLevel;

	/**
	 * @Fields children : 下级组织机构
	 */
	private List<EnterpriseVo> children;
	/**
	 * @Fields key : 表格树节点key
	 */
	private String key;

	public java.lang.String getId() {
		return this.id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getFkEnterpriseId() {
		return this.fkEnterpriseId;
	}

	public void setFkEnterpriseId(java.lang.String fkEnterpriseId) {
		this.fkEnterpriseId = fkEnterpriseId;
	}

	public java.lang.String getEnterpriseNameShort() {
		return this.enterpriseNameShort;
	}

	public void setEnterpriseNameShort(java.lang.String enterpriseNameShort) {
		this.enterpriseNameShort = enterpriseNameShort;
	}

	public java.lang.String getEnterpriseNameFull() {
		return this.enterpriseNameFull;
	}

	public void setEnterpriseNameFull(java.lang.String enterpriseNameFull) {
		this.enterpriseNameFull = enterpriseNameFull;
	}

	public java.lang.Integer getDisOrder() {
		return this.disOrder;
	}

	public void setDisOrder(java.lang.Integer disOrder) {
		this.disOrder = disOrder;
	}

	public java.lang.Integer getIsAbled() {
		return this.isAbled;
	}

	public void setIsAbled(java.lang.Integer isAbled) {
		this.isAbled = isAbled;
	}

	public java.lang.String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	public java.lang.String getUserRealnameCreate() {
		return this.userRealnameCreate;
	}

	public void setUserRealnameCreate(java.lang.String userRealnameCreate) {
		this.userRealnameCreate = userRealnameCreate;
	}

	public java.lang.String getFkUserIdCreate() {
		return this.fkUserIdCreate;
	}

	public void setFkUserIdCreate(java.lang.String fkUserIdCreate) {
		this.fkUserIdCreate = fkUserIdCreate;
	}

	public java.util.Date getCreateDateBegin() {
		return this.createDateBegin;
	}

	public void setCreateDateBegin(java.util.Date createDateBegin) {
		this.createDateBegin = createDateBegin;
	}

	public java.util.Date getCreateDateEnd() {
		return this.createDateEnd;
	}

	public void setCreateDateEnd(java.util.Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public java.lang.String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(java.lang.String createDate) {
		this.createDate = createDate;
	}

	public List<EnterpriseVo> getChildren() {
		return children;
	}

	public void setChildren(List<EnterpriseVo> children) {
		this.children = children;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return enterpriseCode
	 */
	public java.lang.String getEnterpriseCode() {
		return enterpriseCode;
	}

	/**
	 * @param enterpriseCode
	 *            要设置的 enterpriseCode
	 */
	public void setEnterpriseCode(java.lang.String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}

	/**
	 * @return erpCode
	 */
	public java.lang.String getErpCode() {
		return erpCode;
	}

	/**
	 * @param erpCode
	 *            要设置的 erpCode
	 */
	public void setErpCode(java.lang.String erpCode) {
		this.erpCode = erpCode;
	}

	/**
	 * @return enterpriseLevel
	 */
	public java.lang.Integer getEnterpriseLevel() {
		return enterpriseLevel;
	}

	/**
	 * @param enterpriseLevel
	 *            要设置的 enterpriseLevel
	 */
	public void setEnterpriseLevel(java.lang.Integer enterpriseLevel) {
		this.enterpriseLevel = enterpriseLevel;
	}

	/**
	 * @return leader 分管领导
	 */
	public String getLeader() {
		return leader;
	}

	/**
	 * @param 分管领导
	 *            要设置的 leader
	 */
	public void setLeader(String leader) {
		this.leader = leader;
	}

	/**
	 * @return leaderName
	 */
	public String getLeaderName() {
		return leaderName;
	}

	/**
	 * @param leaderName
	 *            要设置的 leaderName
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

}
