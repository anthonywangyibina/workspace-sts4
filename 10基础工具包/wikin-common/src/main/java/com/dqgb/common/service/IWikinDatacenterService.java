/**
 * @项目名:wikin-common
 * @文件名:IWikinDatacenterService.java
 * @包名:com.dqgb.common.service
 * @描述 IWikinDatacenterService.java
 * @修改人 wenzhang
 * @修改时间:2018年2月2日下午4:45:53
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.service;

import javax.validation.constraints.NotNull;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqgb.common.response.ResponseData;

/**
 * ClassName:IWikinDatacenterService <br/>
 * 调用数据中心服务 Date: 2018年2月2日 下午4:45:53 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
@FeignClient("wikin-datacenter")
public interface IWikinDatacenterService {

	/**
	 * 
	 * @Description:根据需求获取树接口
	 *
	 * @author wenzhang
	 * @date:2018年2月2日 下午4:52:48
	 * @Title:findTreeData
	 * @param page
	 *            页码
	 * @param size
	 *            每页个数
	 * @param childSortProperty
	 *            子表排序字段
	 * @param childSortDerect
	 *            子表升序(ASC)/降序(DESC)
	 * @param parentSortProperty
	 *            父表排序字段
	 * @param parentSortDerect
	 *            父表升序(ASC)/降序(DESC)
	 * @param modelParentCode
	 *            模型编码
	 * @param modelChildCode
	 *            子模型编码
	 * @param treeParentNameField
	 *            父对象的名称字段
	 * @param treeChildNameField
	 *            子对象的名称字段
	 * @param treeChildNameFieldValue
	 * @param parentDataId
	 * @return ResponseData:{resCode:"操作是否成功编码",resMsg:"返回信息",data:"返回数据"}
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/treeNodesData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData findTreeData(@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
			@RequestParam(required = false, value = "size", defaultValue = "10000") Integer size,
			@RequestParam(required = false, value = "childSortProperty", defaultValue = "id") String childSortProperty,
			@RequestParam(required = false, value = "childSortDerect", defaultValue = "ASC") String childSortDerect,
			@RequestParam(required = false, value = "parentSortProperty", defaultValue = "id") String parentSortProperty,
			@RequestParam(required = false, value = "parentSortDerect", defaultValue = "ASC") String parentSortDerect,
			@RequestParam(value = "modelParentCode") String modelParentCode,
			@RequestParam(required = false, value = "modelChildCode") String modelChildCode,
			@RequestParam(value = "treeParentNameField") String treeParentNameField,
			@RequestParam(required = false, value = "treeChildNameField") String treeChildNameField,
			@RequestParam(required = false, value = "treeChildNameFieldValue") String treeChildNameFieldValue,
			@RequestParam(required = false, value = "parentDataId") String parentDataId);

	/**
	 * @Description:查询数据. 默认查询全部数据，当传入具体的一个或多个属性值时，则查询与其匹配的数据,过滤条件为字符串形式如：name:张三,李四;username:zhangsan,lisi
	 * @author wenzhang
	 * @date:2018年2月2日 下午5:21:17
	 * @Title:findByStringFilter
	 * @param page
	 *            当前页
	 * @param size
	 *            每页显示的条数
	 * @param sortProperty
	 *            排序字段
	 * @param sortDerect
	 *            升序(ASC)/降序(DESC)
	 * @param modelId
	 *            模型Id
	 * @param modelCode
	 *            模型编码
	 * @param filterJson
	 *            过滤条件
	 * @param fields
	 *            查询字段
	 * @return
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseData findByStringFilter(
			@RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
			@RequestParam(required = false, defaultValue = "10000", value = "size") Integer size,
			@RequestParam(required = false, defaultValue = "id", value = "sortProperty") String sortProperty,
			@RequestParam(required = false, defaultValue = "ASC", value = "sortDerect") String sortDerect,
			@RequestParam(required = false, value = "modelId") String modelId,
			@RequestParam(required = false, value = "modelCode") String modelCode,
			@RequestParam(required = false, value = "filterJson") String filterJson,
			@RequestParam(required = false, value = "fields") String fields);

	/**
	 * 
	 * @Description:当传入父表code和父表ID时，查询与其匹配的子表数据.
	 * @author wenzhang
	 * @date:2018年2月2日 下午5:25:52
	 * @Title:findChildrenByParentCode
	 * @param page
	 *            当前页
	 * @param size
	 *            每页显示的条数
	 * @param sortProperty
	 *            排序字段
	 * @param sortDerect
	 *            升序(ASC)/降序(DESC)
	 * @param modelParentCode
	 *            父模型编码
	 * @param modelParentId
	 *            父表数据的ID
	 * @param modelChildCode
	 *            模型编码
	 * @param fields
	 *            查询字段
	 * @return ResponseData 查询结果
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/data/childrenDatas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData findChildrenByParentCode(
			@RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
			@RequestParam(required = false, defaultValue = "10000", value = "size") Integer size,
			@RequestParam(required = false, defaultValue = "CREATETIME", value = "sortProperty") String sortProperty,
			@RequestParam(required = false, defaultValue = "ASC", value = "sortDerect") String sortDerect,
			@RequestParam(value = "modelCode") String modelCode,
			@RequestParam(required = false, value = "parentDataId") String parentDataId,
			@RequestParam(required = false, value = "fields") String fields);

	/**
	 * 
	 * @Description:修改数据. 保存传入的数据，并返回保存的结果描述
	 * @author wenzhang
	 * @date:2018年2月5日 上午9:03:21
	 * @Title:update
	 * @param modelCodeOrId
	 *            模型编码或ID
	 * @param dataJson
	 *            拼接修改的字符串
	 * @return ResponseData 修改后的对象结果
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/data/{modelCodeOrId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseData update(@NotNull @PathVariable("modelCodeOrId") String modelCodeOrId,
			@RequestBody String dataJson);

	
	/**
	 * 根据需求获取树接口
	 * @Title findTreeData
	 * @author wenzhang
	 * @Description 根据需求获取树接口
	 * @date 2018年6月7日 下午4:45:48
	 * @param page 页码
	 * @param size 每页个数
	 * @param childSortProperty 子表排序字段
	 * @param childSortDerect 子表升序(ASC)/降序(DESC)
	 * @param parentSortProperty 父表排序字段
	 * @param parentSortDerect 父表升序(ASC)/降序(DESC)
	 * @param modelParentCode 模型编码
	 * @param modelChildCode 子模型编码
	 * @param treeParentNameField 父对象的名称字段
	 * @param treeChildNameField 子对象的名称字段
	 * @return ResponseData
	 */
	@RequestMapping(value = "/treeNodesData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData findTreeData(@RequestParam(required = false, value = "page") Integer page,
			@RequestParam(required = false, value = "size") Integer size,
			@RequestParam(required = false, value = "childSortProperty") String childSortProperty,
			@RequestParam(required = false, value = "childSortDerect") String childSortDerect,
			@RequestParam(required = false, value = "parentSortProperty") String parentSortProperty,
			@RequestParam(required = false, value = "parentSortDerect") String parentSortDerect,
			@RequestParam(value = "modelParentCode") String modelParentCode,
			@RequestParam(required = false, value = "modelChildCode") String modelChildCode,
			@RequestParam(value = "treeParentNameField") String treeParentNameField,
			@RequestParam(required = false, value = "treeChildNameField") String treeChildNameField);
}
