package com.dqgb.feignClient.serviceFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqgb.common.response.ResponseData;


/**
 * wikin-datacenter原始接口
 * 
 * @className IWikinDataFeign
 * @author :技术部-zhangjs
 * @Description wikin-datacenter原始接口
 * @date 2019年9月23日 下午2:14:03
 */
@FeignClient("wikin-datacenter")
public interface IWikinDataFeign {
	
	
	/**
	 * 通过部门编码获取部门对象。
	 * @Title findDepByEnterpriseCode
	 * @param enterpriseCode  部门编码
	 * @return ResponseData
	 */
	@RequestMapping(value="/enterprise/enterprises", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData findDepByEnterpriseCode(@RequestParam("enterpriseCode") String enterpriseCode);
	
	
	/**
	 * 通过部门id获取部门对象 
	 * @Title findDepById 
	 * @param id 部门主键
	 * @return ResponseData
	 */
	@RequestMapping(value="/enterprise/enterprise", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData findDepById(@RequestParam("id") String id);
	
	/**
	 * @Description:查询数据. 默认查询全部数据，当传入具体的一个或多个属性值时，则查询与其匹配的数据,过滤条件为字符串形式如：name:张三,李四;username:zhangsan,lisi
	 *1）接口：通过部门id查询用户列表, 支持多id查询，id以","分隔；参数：modelCode=user;filterJson={'FK_DEPARTMENT_ID=':'"+部门Id+"'}
	 *2）接口：通过id查询用户，支持多个id查询，以","隔开；参数：modelCode=user;filterJson={'ID=':'"+用户id+"'}
	 *3）接口：通过账号查询用户，支持多个账号查询，以","隔开；参数：modelCode=user;filterJson={'USER_NAME=':'"+用户账号+"'}
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
	 * @return ResponseData
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public ResponseData findData(
			@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = "10000") Integer size,
			@RequestParam(value = "sortProperty", required = false, defaultValue = "id") String sortProperty,
			@RequestParam(value = "sortDerect", required = false, defaultValue = "asc") String sortDerect,
			@RequestParam(value = "modelId", required = false) String modelId,
			@RequestParam(value = "modelCode", required = false) String modelCode,
			@RequestParam(value = "filterJson", required = false) String filterJson,
			@RequestParam(value = "fields", required = false) String fields);
	

	/**
	 * 查询树结构的数据
	 * 
	 * @param page 当前页码 
	 * @param size 分页大小
	 * @param childSortProperty 子查询排序字段
	 * @param childSortDerect 子查询排序方式
	 * @param parentSortProperty 父查询排序字段
	 * @param parentSortDerect 父查询排序方式
	 * @param modelParentCode 	模型编码
	 * * @param modelChildCode 子模型编码
	 * @param treeParentNameField 父对象的名称字段
	 *  * @param treeChildNameField 子对象的名称字段
	 * * @param treeChildNameFieldValue 子对象的名称LIKE查询值
	 * @param parentDataId 	父对象根节点数据Id
	 * @return
	 */
	@RequestMapping(value = "/treeNodesData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData findTreeNodeData(
			@RequestParam(value="page",required=false,defaultValue="0") Integer page,
			@RequestParam(value="size",required=false,defaultValue="10000") Integer size,
			@RequestParam(value="childSortProperty",required=false,defaultValue="id") String childSortProperty,
			@RequestParam(value="childSortDerect",required=false,defaultValue="asc") String childSortDerect,
			@RequestParam(value="parentSortProperty",required=false,defaultValue="id") String parentSortProperty,
			@RequestParam(value="parentSortDerect",required=false,defaultValue="asc") String parentSortDerect,
			@RequestParam(value="modelParentCode") String modelParentCode,
			@RequestParam(value="modelChildCode",required=false) String modelChildCode,
			@RequestParam(value="treeParentNameField") String treeParentNameField,
			@RequestParam(value="treeChildNameField",required=false) String treeChildNameField,
			@RequestParam(value="treeChildNameFieldValue",required=false) String treeChildNameFieldValue,
			@RequestParam(value="parentDataId",required=false) String parentDataId);
	
	/**
	 * 根据传入的主键ID集合 ，批量删除相匹配的数据 。多个Id用","隔开
	 * @param ids  数据ID
	 * @param modelId 模型ID
	 * @return ResponseData
	 */
	@RequestMapping(value="/data", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData deleteByIds(@RequestParam("ids") String ids,
			@RequestParam("modelId") String modelId);
	
	/**
	 * 新增数据
	 * 按照传入的数据对象编码或则ID（modelCodeOrId）找到相应的数据表，并将数据信息（dataJson）存入该数据表中，
	 * dataJson形如：{"username":"zhangsan","real_name":"张三"}
	 * @param dataJson   拼接修改的字符串
	 * @param modelCodeOrId  模型编码或Id
	 * @return ResponseData
	 */
	@RequestMapping(value="/data/{modelCodeOrId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData save(@RequestBody String dataJson,
			@PathVariable("modelCodeOrId") String modelCodeOrId);
	
	/**
	 * 修改数据
	 * 按照传入的数据对象编码或则ID（modelCodeOrId）找到相应的数据表，并将数据信息（dataJson）修改入该数据表相匹配的数据，
	 * dataJson必须包含id值用于匹配原数据，形如：{"id":"fdgs54354667","real_name":"张三"}
	 * @param dataJson  拼接修改的字符串
	 * @param modelCodeOrId 模型编码或Id
	 * @return ResponseData
	 */
	@RequestMapping(value="/data/{modelCodeOrId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData update(@RequestBody String dataJson,
			@PathVariable("modelCodeOrId") String modelCodeOrId);
	/**
	 * 查询树形结构数据，只查本表的数据
	 * @param page 当前页
	 * @param size 每页显示条数
	 * @param sortProperty 排序字段
	 * @param sortDerect 升序(ASC)/降序(DESC)
	 * @param modelCode 数据对象编码
	 * @param parentDataId  父数据的ID,多个以逗号隔开，默认为所有一级数据
	 * @param fields 除ID以外的其它字段，默认只返回ID
	 * @return
	 */
	@RequestMapping(value = "/data/childrenDatas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData findChildrenDatas(
			@RequestParam(value="page",required=false,defaultValue="0") Integer page,
			@RequestParam(value="size",required=false,defaultValue="10000") Integer size,
			@RequestParam(value="sortProperty",required=false,defaultValue="CREATETIME") String sortProperty,
			@RequestParam(value="sortDerect",required=false,defaultValue="ASC") String sortDerect,
			@RequestParam(value="modelCode") String modelCode,
			@RequestParam(value="parentDataId",required=false) String parentDataId,
			@RequestParam(value="fields",required=false) String fields);
	
}
