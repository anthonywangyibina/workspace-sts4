/**
 * @项目名:wikin-bpm
 * @文件名:DeparmentDo.java
 * @包名:com.dqgb.bpm.vo
 * @描述 DeparmentDo.java
 * @修改人 Administrator
 * @修改时间:2018年6月7日下午5:33:11
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.vo;

/**
 * ClassName:DeparmentDo <br/>
 * Function: 树组件传过来的数据解析. <br/>
 * Date: 2018年6月7日 下午5:33:11 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
public class DeparmentDo {

	private String value;// 树节点id

	private String label;// 树节点名称

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
