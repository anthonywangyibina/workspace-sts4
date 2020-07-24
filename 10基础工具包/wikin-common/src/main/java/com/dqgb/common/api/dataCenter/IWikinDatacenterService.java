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

package com.dqgb.common.api.dataCenter;

import com.dqgb.common.response.ResponseData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

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
	 * @Description:根据需求获取树接口 该方法可以根据parentDataId和treeChildNameFieldValue对数据进行筛选
	 *
	 * @author wenzhang
	 * @date:2018年2月2日 下午4:52:48
	 * @Title:findTreeData
	 * @param page
	 *            页码
	 * @param size
	 *           分页大小
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
	 <pre>
	<b>请求地址</b>：/wikin-datacenter/treeNodesData
	<b>请求方式</b>: get
	<b>请求案例</b>：
	page:0	===>当前请求页
	size:1	===>分页大小
	childSortProperty:id	===>子表排序字段
	childSortDerect:ASC		===>子表升序(ASC)/降序(DESC)
	parentSortProperty:id		===>父表排序字段
	parentSortDerect:ASC	===> 父表升序(ASC)/降序(DESC)
	modelParentCode:department	===>模型编码
	treeParentNameField:department_name	===>子模型编码
	</pre>
	 * @param parentDataId
	 * @return ResponseData:{resCode:"操作是否成功编码",resMsg:"返回信息",data:"返回数据"}
	 <b>1.没有对应数据表</b>
	{
	"rspCode": "000000",
	"rspMsg": "操作成功",
	"data": "获取层级数据失败, department无对应数据表"
	}
	<b>2.有数据</b>
	{
	"rspCode": "000000",	===>响应编码
	"rspMsg": "操作成功",	===>相应提示信息
	"data": [
	{
	"nodeld": "0f7f257fb9e549f6b4522bf04a3005b8",
	"nodeName": "大庆金桥",
	"nodeCode": null,
	"nodeType": "department",
	"list": null,		===>子数据行会放在在这里
	"leaf": true	===>是否是叶子节点
	}
	]
	}
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
	 <pre>
	<b>请求地址</b>：/wikin-datacenter/data
	<b>请求方式</b>: get
	<b>请求案例</b>：
	page: 1
	size: 10
	modelId:8af2c9f05ea308f2015ea30a3b200002 	===>模板对象Id
	modeCode:user	===>模板编码
	filterJson:"USER_SEX": "男","IS_DISABLED":"1" 	===>“:”使用like 默认使用and多个条件字段,相同字段字段多值以“,”查询时使用or连接。可以在字段后明确指定and或来改变多字段连接
	fields:ID,USER_NAME,REAL_NAME,USER_SEX	===>查询字段fields多个之间用英文逗号隔开，关联表的字段同样用 父表编码.父表字段名 的形式，如：字段1,字段2,父表编码.父表字段......。
	sortDerect:ASC	===>排序方式
	sortProperty:USER_ONLINE,USER_AGE ===>排序字段
	<b>注意：</b>
	filterJson，fields，sortProperty均为数据表的字段名
	</pre>
	 * @return
	 <pre>
	<b>响应案例</b>：
	{
	"rspCode": "000000",
	"rspMsg": "操作成功",
	"data": {
	"content": [	===>数据行 显示的内容由fields决定
	{
	"USER_SEX": "男",
	"ID": "f0d39ddfabe24ddab6674c465a7dfaf4",
	"USER_NAME": "hew1",
	"REAL_NAME": "何伟"
	}
	],
	"totalPages": 1,
	"last": true,
	"totalElements": 2666,
	"numberOfElements": 10,
	"first": true,
	"sort": null,
	"size": 0,
	"number": 0
	}
	}
	</pre>
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
	 * @Description:当传入父表code和父表ID时，查询与其匹配的子表数据Id.
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
	<pre>
	<b>请求地址</b>：/wikin-datacenter/data/childrenDatas
	<b>请求方式</b>: get
	<b>请求案例</b>：
	page: 1
	size: 10
	sortProperty:MODIFY_DATE
	sortDerect:ASC
	modelCode:department
	parentDataId:8aa48a906469678601646995e967000f  ===>多个可以以","分割
	fields:
	</pre>
	 * @return ResponseData 查询结果
	 <pre>
	{
	"rspCode": "000000",
	"rspMsg": "操作成功",
	"data": [	===>返回子对象的Id
	"8aa48a906469678601646995e967000f"
	]
	}
	</pre>
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
	 <pre>
	该方法不能通过浏览器直接请求，可一个通过feign调用
	String dataJson = "{\"ID\":\"" + user.getUserId() + "\",\"PASSWORD\":\"" + password + "\",\"IS_UP_PWD\":\"" + 1 + "\"}";	===>注意：这里一定要指定ID，因为修改会根据这个来
	dataCenterService.save("user", dataJson);
	</pre>
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
	<pre>
	<b>请求地址</b>：/wikin-datacenter/data/childrenDatas
	<b>请求方式</b>: get
	<b>请求案例</b>：查询部门与人的树
	page:0
	size:10
	childSortProperty:DATA_USER.CREATETIME
	childSortDerect:DESC
	parentSortProperty:DATA_DEPARTMENT.SORT
	parentSortDerect:ASC
	modelParentCode:department
	modelChildCode:user
	treeParentNameField:department_name
	treeChildNameField:real_name
	</pre>
	 * @return ResponseData
	<b>响应案例</b>:
	<pre>
	{
	"rspCode": "000000",
	"rspMsg": "操作成功",
	"data": [
	{
	"nodeld": "5603ea3adaea4d5688ec991fe70c5efb",
	"nodeName": "生产六部",
	"nodeCode": null,
	"nodeType": "department",	===>部门数据
	"list": [
	{
	"nodeld": "8aa48a90695083bf01695da486f003d5",
	"nodeName": "刘俊磊",	===>这个是由treeChildNameField字段决定的
	"nodeCode": null,
	"nodeType": "user",	===>部门的人员数据
	"list": null,
	"leaf": true
	}
	],
	"leaf": true
	}
	]
	}</pre>
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
