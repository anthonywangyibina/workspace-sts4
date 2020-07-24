package com.dqgb.feignClient.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 菜单实体
 *@className Menu
 *@author :技术部-zhangjs
 *@Description 菜单实体 
 *@date 2019年9月23日 下午1:58:25
 */
@Data
public class Menu {
	/**
	 * 资源id
	 */            
	@JsonProperty("resourceID")
	private String id;
	/**
	 * 资源编码
	 */
	private String serviceCode;
	/**
	 * 所属应用
	 */
	private String appId;
	/**
	 * 父ID
	 */
	@JsonProperty("resourceID")
	private String resourcePid;
	/**
	 * 资源名称
	 */
	private String resourceName;
	/**
	 * 菜单所属模块
	 */
	private String resourceModule;
	/**
	 * 资源类型
	 */
	@JsonProperty("ResourceType")
	private String resourceType;
	/**
	 * 资源URL
	 */
	@JsonProperty("ResourceUrl")
	private String resourceUrl;
}
