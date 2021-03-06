/**
 * @项目名:wikin-common
 * @文件名:IBpmFallbackService.java
 * @包名:com.dqgb.common.service
 * @描述 IBpmFallbackService.java
 * @修改人 wenzhang
 * @修改时间:2018年5月21日下午2:52:16
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.service;

/**
 * ClassName:IBpmFallbackService <br/>
 * Function: 流程设计前置后置接口，由业务方自己实现. <br/>
 * Date: 2018年5月21日 下午2:52:16 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
 public interface IBpmBusinessCallbackService {

	/**
	 * 
	 * @Description:业务流程前置事件.
	 *
	 * @author wenzhang
	 * @date:2018年5月21日 下午2:54:27
	 * @Title:serviceFront
	 * @param procinstId
	 *            流程实例ID
	 * @return
	 * @since JDK 1.8
	 */
	default void serviceBefore(String json){
		System.out.println("父类前置方法");
		System.out.println("before:"+json);
	};

	/**
	 * 
	 * @Description:业务流程后置事件.
	 *
	 * @author wenzhang
	 * @date:2018年5月21日 下午2:54:40
	 * @Title:serviceBack
	 * @param procinstId
	 *            流程实例ID
	 * @return
	 * @since JDK 1.8
	 */
	default void serviceAfter(String json){
		System.out.println("父类后置方法");
		System.out.println("before:"+json);
	};

}
