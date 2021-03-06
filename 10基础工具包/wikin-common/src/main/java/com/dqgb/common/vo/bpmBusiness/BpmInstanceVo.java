/**
 * @项目名:wikin-common
 * @文件名:BpmInstanceVo.java
 * @包名:com.dqgb.common.vo.bpmBusiness
 * @描述 BpmInstanceVo.java
 * @修改人 wenzhang
 * @修改时间:2018年5月22日下午3:32:47
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.vo.bpmBusiness;

/**
 * ClassName:BpmInstanceVo <br/>
 * Function: 流程实例展示. <br/>
 * Date: 2018年5月22日 下午3:32:47 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
public class BpmInstanceVo {

	private String instanceKey;// 流程实例业务主键

	private Integer instanceStatus;// 流程实例状态 0 审批中 1 拒绝，2 同意，3 撤销，4驳回，5 挂起 6异常结束

	private String procinstId;// 流程实例id(引擎中的)

	private boolean isDone;// 流程实例是否结束

	private String appCode;// 应用服务编码
	
	private String modelKey;// 模板key
	
	private String categoryCode;//流程分类code

	public String getInstanceKey() {
		return instanceKey;
	}

	public void setInstanceKey(String instanceKey) {
		this.instanceKey = instanceKey;
	}

	public Integer getInstanceStatus() {
		return instanceStatus;
	}

	public void setInstanceStatus(Integer instanceStatus) {
		this.instanceStatus = instanceStatus;
	}

	public String getProcinstId() {
		return procinstId;
	}

	public void setProcinstId(String procinstId) {
		this.procinstId = procinstId;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getModelKey() {
		return modelKey;
	}

	public void setModelKey(String modelKey) {
		this.modelKey = modelKey;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	

}
