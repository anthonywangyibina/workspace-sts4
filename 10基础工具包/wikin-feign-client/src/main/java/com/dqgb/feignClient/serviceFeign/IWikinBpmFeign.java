/**
 * @项目名:wikin-bpm
 * @文件名:IWikinRoleService.java
 * @包名:com.dqgb.bpm.service
 * @描述 IWikinRoleService.java
 * @修改人 wenzhang
 * @修改时间:2018年4月17日上午11:16:02
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.feignClient.serviceFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.dqgb.common.response.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Date: 2018年4月17日 上午11:16:02 <br/>
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
@FeignClient("wikin-bpm")
public interface IWikinBpmFeign {
	/**
	 *  查询我的已办任务，  默认查询全部数据，当传入具体的一个或多个属性值时，则查询与其匹配的数据
	 * @param taskCompleteTime 处理时间
	 * @param taskCompleteDate 处理日期
	 * @param current 当前页
	 * @param pageSize 每页显示的条数
	 * @param appCode  应用编号
	 * @param processInstanceName 流程名称
	 * @return ResponseData
	 */
	
	@RequestMapping(value = "/task/findAppDoneTaskOfMine", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData findAppDoneTaskOfMine(
			@RequestParam(value = "taskCompleteTime", required = false) String taskCompleteTime,
			@RequestParam(value = "taskCompleteDate", required = false) String taskCompleteDate,
			@RequestParam("current") Integer current,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam(value = "appCode") String appCode,
			@RequestParam(value = "processInstanceName", required = false) String processInstanceName);
	
	/**
	 *  查询我的待办任务，  默认查询全部数据，当传入具体的一个或多个属性值时，则查询与其匹配的数据
	 * @Title findToDoTaskOfMine
	 * @param current 当前页
	 * @param pageSize 每页显示的条数
	 * @param taskCreateTime  任务创建时间(时间已"~"隔开）例如   2020-06-29 14:02:28~2020-06-30 14:02:28 
	 * @param processInstanceName 流程名称
	 * @return ResponseData
	 */
	
	@RequestMapping(value = "/task/findToDoTaskOfMine", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData findToDoTaskOfMine(
			@RequestParam(value = "current") Integer current,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam(value = "taskCreateTime", required = false) String taskCreateTime,
			@RequestParam(value = "processInstanceName", required = false) String processInstanceName);
	
	/**
	 * 审批一个任务，撤销流程实例
	 * @Title repealProcessInstance
	 * @param procinstId 流程实例id
	 * @param taskId 当前任务节点id
	 * @param suggestion 审批意见
	 * @return ResponseData
	 */
	@RequestMapping(value = "/processInstance/repeal", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData repealProcessInstance(@RequestParam("procinstId") String procinstId,
			@RequestParam("taskId") String taskId,@RequestParam("suggestion") String suggestion);
	/**
	 * 审批一个任务，驳回流程实例
	 * @Title rejectProcessInstance
	 * @param procinstId 流程实例id
	 * @param taskId 当前任务节点id
	 * @param suggestion 审批意见
	 * @return ResponseData
	 */
	@RequestMapping(value = "/processInstance/reject", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData rejectProcessInstance(@RequestParam("procinstId") String procinstId,
			@RequestParam("taskId") String taskId,@RequestParam("suggestion") String suggestion);
	/**
	 * 审批一个任务，拒绝流程实例
	 * @Title refuseProcessInstance
	 * @param procinstId 流程实例id
	 * @param taskId 当前任务节点id
	 * @param suggestion 审批意见
	 * @return ResponseData
	 */
	@RequestMapping(value = "/processInstance/refuse", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData refuseProcessInstance(@RequestParam("procinstId") String procinstId,
			@RequestParam("taskId") String taskId,@RequestParam("suggestion") String suggestion);
	
	/**
	 * 审批一个任务，同意流程实例
	 * @Title agreeProcessInstance
	 * @param procinstId 流程实例id
	 * @param taskId 当前任务节点id
	 * @param suggestion 审批意见
	 * @return ResponseData
	 */
	@RequestMapping(value = "/processInstance/agree", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData agreeProcessInstance(@RequestParam("procinstId") String procinstId,
			@RequestParam("taskId") String taskId,@RequestParam("suggestion") String suggestion);
	
	/**
	 * 启动流程实例
	 * 
	 * @author jovenno
	 * @Description:
	 * @date 2018年5月2日
	 * @param processInfoJson{processKey
	 *            流程模板编码,businessKey 业务数据ID,processInstanceName
	 *            流程实例名字,processInstanceStartUser 流程发起者}
	 * @param variableInfoJson 流程变量信息 {key-value：形式的map键值对}
	 * @return
	 */
	@RequestMapping(value = "/processInstance/startProcessInstance", method = RequestMethod.GET)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "processInfoJson", paramType = "query", dataType = "String", value = "流程模板key值", required = true),
			@ApiImplicitParam(name = "variableInfoJson", paramType = "query", dataType = "String", value = "业务记录ID", required = true) })
	@ApiOperation(value = "启动流程实例", notes = "启动流程实例")
	public ResponseData startProcessInstance(@RequestParam("processInfoJson") String processInfoJson,
			@RequestParam("variableInfoJson") String variableInfoJson);
}