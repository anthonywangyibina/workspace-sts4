/**
 * @项目名:wikin-common
 * @文件名:UtilController.java
 * @包名:com.dqgb.common.web
 * @描述 UtilController.java
 * @修改人 wenzhang
 * @修改时间:2018年3月6日下午4:16:08
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dqgb.common.domain.BusinessLog;
import com.dqgb.common.domain.Email;
import com.dqgb.common.response.ResponseData;
import com.dqgb.common.service.IApiService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * ClassName:UtilController <br/>
 * Function: 公用方法路径controller. <br/>
 * Reason: 各个服务引用common中的路径进行后台数据调取. <br/>
 * Date: 2018年3月6日 下午4:16:08 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
@Controller
@EnableAutoConfiguration
@RestController
@RequestMapping(value = "api")
public class ApiController extends BaseController {

	@Autowired
	private IApiService apiService;

	/**
	 * 
	 * @Description:调用文件中心服务，下载多个文件和目录.
	 *
	 * @author wenzhang
	 * @date:2018年3月6日 下午5:29:49
	 * @Title:downFiles
	 * @param ids
	 * @since JDK 1.8
	 */
	@ApiOperation(value = "下载多个文件和目录", notes = "传入的参数可能包含文件夹id集合，文件id集合，下载文件和目录（包含其下按层级所有目录和文件）放入压缩包统一下载")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "ids", dataType = "List<String>", value = "需要下载的文件id集合") })
	@RequestMapping(value = "/downFiles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void downFiles(@RequestParam(value = "ids") List<String> ids) {
		apiService.downFiles(ids);
	}

	/**
	 * @Description:传入业务id，下载文件和目录（包含其下按层级所有目录和文件）放入压缩包统一下载.
	 * @author wenzhang
	 * @date:2018年3月7日 上午9:19:31
	 * @Title:download
	 * @param businessIds
	 *            业务id集合
	 * @since JDK 1.8
	 */
	@ApiOperation(value = "其他程序调用下载接口", notes = "传入业务id，下载文件和目录（包含其下按层级所有目录和文件）放入压缩包统一下载")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "businessIds", dataType = "List<String>", value = "下载文件id集合") })
	@RequestMapping(value = "/download", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void download(@RequestParam(value = "businessIds") List<String> businessIds) {
		apiService.download(businessIds);
	}

	/**
	 * 
	 * @Description:调用文件中心上传文件外部接口.
	 *
	 * @author wenzhang
	 * @date:2018年3月7日 上午9:14:05
	 * @Title:uploadFiles
	 * @param filePath
	 *            文件保存路径
	 * @param userId
	 *            上传人id
	 * @param businessId
	 *            业务id
	 * @param description
	 *            文件描述
	 * @param type
	 *            区分web端和手持端 web端：web；手持端：android
	 * @param request
	 *            请求
	 * @return 上传成功文件，{id：文件id，name：文件名称，是否上传成功}
	 * @since JDK 1.8
	 */
	@ApiOperation(value = "其他程序调用文件上传接口", notes = "其他程序调用文件上传接口，将文件信息存入数据表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "filePath", dataType = "String", value = "文件存储路径"),
			@ApiImplicitParam(paramType = "query", name = "userId", dataType = "String", value = "上传人id"),
			@ApiImplicitParam(paramType = "query", name = "businessId", dataType = "String", value = "业务id"),
			@ApiImplicitParam(paramType = "query", name = "description", dataType = "String", value = "附件描述"),
			@ApiImplicitParam(paramType = "query", name = "type", dataType = "String", value = "web端或手持端标识") })
	@RequestMapping(value = "/uploadFiles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData uploadFiles(@RequestParam(value = "filePath") String filePath,
			@RequestParam(value = "userId") String userId, @RequestParam(value = "businessId") String businessId,
			@RequestParam(value = "description") String description, @RequestParam(value = "type") String type) {
		return apiService.uploadFiles(filePath, userId, businessId, description, type, request());
	}

	/**
	 * 调用文件中心接口获取文件详情接口
	 * 
	 * @Title getFileDetail
	 * @author 文章
	 * @Description: 其他程序获取文件详情接口
	 * @date 2018年3月7日 上午9:25:58
	 * @param businessId
	 *            业务id
	 * @param page
	 *            页码
	 * @param size
	 *            每页个数
	 * @return ResponseData:{data:[{"text":"文件目录名","id":"目录id","nodes":[子目录],"selectable":是否可查...按钮显示控制...}]}
	 */
	@ApiOperation(value = "其他程序获取文件详情接口", notes = "其他程序获取文件详情接口，分页查询")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "businessId", dataType = "String", value = "业务id"),
			@ApiImplicitParam(paramType = "query", name = "page", dataType = "int", value = "页码"),
			@ApiImplicitParam(paramType = "query", name = "size", dataType = "int", value = "每页个数") })
	@RequestMapping(value = "/fileDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData getFileDetail(@RequestParam(value = "businessId") String businessId,
			@RequestParam(value = "page") int page, @RequestParam(value = "size") int size) {
		return apiService.getFileDetail(businessId, page, size);
	}

	/**
	 * @Description:其他程序传入多个业务id，获取文件详情接口，不分页查询.
	 * @author wenzhang
	 * @date:2018年3月7日 上午9:26:25
	 * @Title:getFileDetails
	 * @param businessIds
	 *            业务id集合
	 * @return 文件对象集合
	 * @since JDK 1.8
	 */
	@ApiOperation(value = "其他程序传入多个业务id，获取文件详情接口", notes = "其他程序获取文件详情接口，不分页查询")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "businessIds", dataType = "List<String>", value = "业务id集合") })
	@RequestMapping(value = "/fileDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData getFileDetails(@RequestParam(value = "businessIds") List<String> businessIds) {
		return apiService.getFileDetails(businessIds);
	}

	/**
	 * 
	 * @Description:发送邮件
	 *
	 * @author wenzhang
	 * @date:2018年3月7日 上午9:46:50
	 * @Title:sendEmail
	 * @param email
	 *            邮件对象
	 * @return ResponseData:{rspMsg:"操作结果",data:"新增邮件id"}
	 * @since JDK 1.8
	 */
	@ApiOperation(value = "发送邮件", notes = "发送邮件")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", name = "email", dataType = "Email", value = "邮件对象") })
	@RequestMapping(value = "/emails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData sendEmail(@RequestBody Email email) {
		return apiService.sendEmail(email);
	}

	/**
	 * 
	 * @Description:异步保存日志
	 *
	 * @author wenzhang
	 * @date:2018年3月7日 上午9:54:32
	 * @Title:saveLog
	 * @param businessLog
	 *            日志对象
	 * @param tenant
	 *            租户标识
	 * @since JDK 1.8
	 */
	@ApiOperation(value = "发送邮件", notes = "发送邮件")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", name = "email", dataType = "Email", value = "邮件对象") })
	@RequestMapping(value = "/businessLog", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void saveLog(@RequestBody BusinessLog businessLog) {
		apiService.saveLog(businessLog);
	}

	/**
	 * 
	 * @Description:查询层级结构数据.
	 *
	 * @author wenzhang
	 * @date:2018年3月7日 上午10:14:22
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
	@ApiOperation(value = "查询层级结构数据", notes = "当传入父表code和子表code时，查询有层级关系的数据（包括父表与子表两重）", response = Model.class, responseContainer = "List")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "page", dataType = "Integer", value = "当前页", defaultValue = "0", required = false),
			@ApiImplicitParam(paramType = "query", name = "size", dataType = "Integer", value = "每页显示的条数", defaultValue = "15", required = false),
			@ApiImplicitParam(paramType = "query", name = "childSortProperty", dataType = "String", value = "子表排序字段", defaultValue = "id"),
			@ApiImplicitParam(paramType = "query", name = "childSortDerect", dataType = "String", value = "子表升序(ASC)/降序(DESC)", defaultValue = "ASC"),
			@ApiImplicitParam(paramType = "query", name = "parentSortProperty", dataType = "String", value = "父表排序字段", defaultValue = "id"),
			@ApiImplicitParam(paramType = "query", name = "parentSortDerect", dataType = "String", value = "父表升序(ASC)/降序(DESC)", defaultValue = "ASC"),
			@ApiImplicitParam(paramType = "query", name = "modelParentCode", dataType = "String", value = "模型编码", required = true, defaultValue = ""),
			@ApiImplicitParam(paramType = "query", name = "modelChildCode", dataType = "String", value = "子模型编码", defaultValue = ""),
			@ApiImplicitParam(paramType = "query", name = "treeParentNameField", dataType = "String", value = "父对象的名称字段", required = true, defaultValue = ""),
			@ApiImplicitParam(paramType = "query", name = "treeChildNameField", dataType = "String", value = "子对象的名称字段", defaultValue = ""),
			@ApiImplicitParam(paramType = "query", name = "treeChildNameFieldValue", dataType = "String", value = "子对象的名称LIKE查询值", defaultValue = ""),
			@ApiImplicitParam(paramType = "query", name = "parentDataId", dataType = "String", value = "父对象根节点数据ID", defaultValue = "") })
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
			@RequestParam(required = false, value = "parentDataId") String parentDataId) {
		return apiService.findTreeData(page, size, childSortProperty, childSortDerect, parentSortProperty,
				parentSortDerect, modelParentCode, modelChildCode, treeParentNameField, treeChildNameField,
				treeChildNameFieldValue, parentDataId);
	}

	/**
	 * 
	 * @Description:当传入父表code和父表ID时，查询与其匹配的子表数据.
	 *
	 * @author wenzhang
	 * @date:2018年3月7日 上午10:19:06
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
	@ApiOperation(value = "查询子数据", notes = "查询树形结构数据，只查本表的数据", response = Model.class, responseContainer = "List")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "page", dataType = "Integer", value = "当前页", defaultValue = "0"),
			@ApiImplicitParam(paramType = "query", name = "size", dataType = "Integer", value = "每页显示的条数", defaultValue = "10000"),
			@ApiImplicitParam(paramType = "query", name = "sortProperty", dataType = "String", value = "排序字段", defaultValue = "CREATETIME", required = false),
			@ApiImplicitParam(paramType = "query", name = "sortDerect", dataType = "String", value = "升序(ASC)/降序(DESC)", required = false, defaultValue = "ASC"),
			@ApiImplicitParam(paramType = "query", name = "modelCode", dataType = "String", value = "数据对象编码", required = true, defaultValue = ""),
			@ApiImplicitParam(paramType = "query", name = "parentDataId", dataType = "String", value = "父数据的ID,多个以逗号隔开，默认为所有一级数据", required = false, defaultValue = ""),
			@ApiImplicitParam(paramType = "query", name = "fields", dataType = "String", value = "除ID以外的其它字段，默认只返回ID", required = false, defaultValue = "") })
	@RequestMapping(value = "/childrenData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData findChildrenByParentCode(
			@RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
			@RequestParam(required = false, defaultValue = "10000", value = "size") Integer size,
			@RequestParam(required = false, defaultValue = "CREATETIME", value = "sortProperty") String sortProperty,
			@RequestParam(required = false, defaultValue = "ASC", value = "sortDerect") String sortDerect,
			@RequestParam(value = "modelCode") String modelCode,
			@RequestParam(required = false, value = "parentDataId") String parentDataId,
			@RequestParam(required = false, value = "fields") String fields) {
		return apiService.findChildrenByParentCode(page, size, sortProperty, sortDerect, modelCode, parentDataId,
				fields);
	}
    /**
    * @Title findByStringFilter2
    * @author yangmaoli
    * @Description: 默认查询全部数据，当传入具体的一个或多个属性值时，
    * 则查询与其匹配的数据,默认以LIKE进行匹配查询，字段后添加等号则以等号匹配。
    * 过滤条件为字符串形式如：'real_name=':张三,李四;username:zhangsan,lisi
    * @date 2018年2月9日
    * @param page
    * @param size
    * @param sortProperty
    * @param sortDerect
    * @param modelId
    * @param modelCode
    * @param filterJson
    * @param fields
    * @return
    */ 
    @ApiOperation(value = "查询数据", notes = "默认查询全部数据，当传入具体的一个或多个属性值时，则查询与其匹配的数据，默认以LIKE进行匹配查询。"
    		+ "过滤条件filterJson为字符串形式如：'real_name=':'张三,李四','username':'zhangsan,lisi'。"
    		+ "1.以英文逗号隔开的多个值将以or的方式连接，如：'real_name=':'张三,李四'将匹配real_name=张三 或 real_name=李四 的数据"
    		+ "2.默认按照字段值模糊查询，多个条件字段间用 and 连接，如：'real_name':'张三','username':'zhangsan'将匹配real_name 包含 张三  并且 username 包含 zhangsan 的数据。"
    		+ "3.在字段后面跟 = 则按字段输入值相等方式匹配，如：'real_name=':'张三'将查询字段 real_name=张三  的数据。"
    		+ "4.在字段后面跟 or 则与后面的一个查询条件间以 or 的方式连接，如：'real_name or':'张三','username':'zhangsan'将匹配 real_name 包含 张三 或 username 包含 zhangsan的数据。"
    		+ "5.字段前添加startDate_则其值须为yyyy-MM-dd HH:mm:ss的日期字符串，查询该字段值>=传入值的数据，如'startDate_createTime':'2018-02-24 12:13:24'将匹配createTime>=2018-02-24 12:13:24的数据。"
    		+ "6.字段前添加endDate_则其值须为yyyy-MM-dd HH:mm:ss的日期字符串，查询该字段值<=传入值的数据，，如'endDate_createTime':'2018-02-24 12:13:24'将匹配createTime<=2018-02-24 12:13:24的数据。"
    		+ "7.如果值为 is not null或 is null将查询该字段值为非空或空的数据。"
    		+ "8.如果字段前面跟 ( 则该条件前会加上 ( ，如果字段包含 ) 则在该条件后加上 ) 。"
    		+ "9.如果查询条件为关联表父表的字段，则字段应以 字段编码.父表字段 的形式加入，如：根据部门编码查用户应写成 'FK_DET_ID.code':'dqgb'的形式。"
    		+ "查询字段fields多个之间用英文逗号隔开，关联表的字段同样用 父表编码.父表字段名 的形式，如：字段1,字段2,父表编码.父表字段......。"
    		+ "排序字段sortProperty：1.本数据对象的字段多个间用英文逗号隔开，默认为数据对象定义的排序字段及规则（如果没有则为createTime 降序）；"
    		+ "2.有父数据对象参与排序，则使用字符串 字段编码1.父表字段名 asc/desc,字段编码2.父表字段名 asc/desc 的形式，如：name desc,FK_DET_ID.sort asc。"
    		+ "排序规则sortDerect，当传入排序字段为空或不带数据对象编码时无用，其他时候按照 升序(ASC)/降序(DESC)的规则排序。"
    		,response = Model.class, responseContainer = "List")
    @ApiImplicitParams({
    	@ApiImplicitParam(paramType = "query", name = "page", dataType = "Integer", value = "当前页"),
    	@ApiImplicitParam(paramType = "query", name = "size", dataType = "Integer", value = "每页显示的条数"),
    	@ApiImplicitParam(paramType = "query", name = "sortProperty", dataType = "String", value = "排序字段，形如：字段编码 或 数据对象编码.字段编码 desc/asc"),
    	@ApiImplicitParam(paramType = "query", name = "sortDerect", dataType = "String", value = "升序(ASC)/降序(DESC)"),
    	@ApiImplicitParam(paramType = "query", name = "modelId", dataType = "String", value = "数据对象Id"),
    	@ApiImplicitParam(paramType = "query", name = "modelCode", dataType = "String", value = "数据对象编码"),
    	@ApiImplicitParam(paramType = "query", name = "filterJson", dataType = "String", value = "过滤条件", defaultValue = ""),
    	@ApiImplicitParam(paramType = "query", name = "fields", dataType = "String", value = "查询字段，形如：字段1,字段2,...")})
    @RequestMapping(value = "/data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData findByStringFilter(@RequestParam(required = false, defaultValue = "0") Integer page,
    		@RequestParam(required = false, defaultValue = "10000") Integer size,
    		@RequestParam(required = false, defaultValue = "") String sortProperty,
    		@RequestParam(required = false, defaultValue = "ASC") String sortDerect,
    		@RequestParam(required = false) String modelId,
    		@RequestParam(required = false) String modelCode,
    		@RequestParam(required = false) String filterJson,
    		@RequestParam(required = false) String fields){
		return apiService.findByStringFilter(page, size, sortProperty, sortDerect, modelId,modelCode,filterJson,fields);

    }

}
