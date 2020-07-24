package com.dqgb.feignClient.serviceFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dqgb.common.response.ResponseData;
import com.dqgb.common.vo.UserVo;


/**
 * wikin-mdm原始接口
 * 
 * @author :技术部-zhangjs
 * @date 2019年9月23日 下午2:14:03
 */
@FeignClient("wikin-mdm")
public interface IWikinMDMFeign {
	/**
	 * 根据传入时间获取有改变的数据：包括新增add、修改update、删除delete
	 * @Title getMdmDataList
	 * @param dataType 	数据对像编码
	 * @param updateTime 更新时间:yyyy-MM-dd HH:mm:ss
	 * @param current 当前页
	 * @param pageSize 每页显示的条数
	 * @return ResponseData
	 */
	@RequestMapping(value="/getMdmDataList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData getMdmDataList(@RequestParam(value = "dataType") String dataType,@RequestParam(value = "updateTime") String updateTime,
			@RequestParam(value = "current") Integer current,@RequestParam(value = "pageSize") Integer pageSize);
	
	/**
	 * @Description:查询数据. 默认查询全部数据，当传入具体的一个或多个属性值时，则查询与其匹配的数据,过滤条件为字符串形式如：name:张三,李四;username:zhangsan,lisi
	 * 1）接口：通过模型code和字典code(相当于一条数据的编码)查询字典数据；参数： modelCode=模型code；filterJson={'code=':"+字典code+"};
	 * 2）接口：通过模型code查询字典数据,不分页；参数：modelCode=模型code；
	 * 3）接口：通过模型code分页查询字典数据；参数： page:当前页、size: 每页显示的条数、sortProperty:排序字段、sortDerect:升序(ASC)/降序(DESC)、modelCode:模型编码
	 * @Title findData
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
	public ResponseData save(
			@RequestHeader(name = "userVo", required = true) String userVo,
			@RequestBody String dataJson,
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

}
