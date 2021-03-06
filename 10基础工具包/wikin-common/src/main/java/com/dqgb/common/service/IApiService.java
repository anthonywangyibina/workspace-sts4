/**
 * @项目名:wikin-common
 * @文件名:IUtilService.java
 * @包名:com.dqgb.common.service
 * @描述 IUtilService.java
 * @修改人 wenzhang
 * @修改时间:2018年3月6日下午4:21:49
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;

import com.dqgb.common.domain.BusinessLog;
import com.dqgb.common.domain.Email;
import com.dqgb.common.response.ResponseData;

/**
 * ClassName:IUtilService <br/>
 * Function: 公用路径服务层. <br/>
 * Date: 2018年3月6日 下午4:21:49 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
public interface IApiService {

	/**
	 * 
	 * @Description:调用文件中心服务，下载多个文件和目录..
	 *
	 * @author wenzhang
	 * @date:2018年3月6日 下午5:30:28
	 * @Title:downFiles
	 * @param ids
	 *            需要下载的文件id集合
	 * @since JDK 1.8
	 */
	public void downFiles(List<String> ids);

	/**
	 * 
	 * @Description:传入业务id，下载文件和目录（包含其下按层级所有目录和文件）放入压缩包统一下载.
	 * @author wenzhang
	 * @date:2018年3月7日 上午9:21:12
	 * @Title:download
	 * @param businessIds
	 *            业务id集合
	 * @since JDK 1.8
	 */
	public void download(List<String> businessIds);

	/**
	 * 
	 * @Description:调用文件中心上传文件外部接口.
	 *
	 * @author wenzhang
	 * @date:2018年3月7日 上午9:16:02
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
	public ResponseData uploadFiles(String filePath, String userId, String businessId, String description, String type,
			HttpServletRequest request);

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
	public ResponseData getFileDetail(String businessId, int page, int size);

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
	public ResponseData getFileDetails(List<String> businessIds);

	/**
	 * 
	 * @Description:发送邮件.
	 * @author wenzhang
	 * @date:2018年3月7日 上午9:48:20
	 * @Title:sendEmail
	 * @param email
	 *            邮件对象
	 * @return ResponseData:{rspMsg:"操作结果",data:"新增邮件id"}
	 * @since JDK 1.8
	 */
	public ResponseData sendEmail(Email email);

	/**
	 * 
	 * @Description:异步存储日志
	 *
	 * @author wenzhang
	 * @date:2018年3月7日 上午9:51:15
	 * @Title:saveLog
	 * @param businessLog
	 *            日志对象
	 *            租户标识
	 * @return
	 * @since JDK 1.8
	 */
	public void saveLog(BusinessLog businessLog);

	/**
	 * 
	 * @Description:根据需求获取树接口
	 *
	 * @author wenzhang
	 * @date:2018年3月7日 上午9:59:45
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
	public ResponseData findTreeData(Integer page, Integer size, String childSortProperty, String childSortDerect,
			String parentSortProperty, String parentSortDerect, String modelParentCode, String modelChildCode,
			String treeParentNameField, String treeChildNameField, String treeChildNameFieldValue, String parentDataId);

	/**
	 * 
	 * @Description:当传入父表code和父表ID时，查询与其匹配的子表数据.
	 * @author wenzhang
	 * @date:2018年3月7日 上午9:59:45
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
	public ResponseData findChildrenByParentCode(
			@RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
			@RequestParam(required = false, defaultValue = "10000", value = "size") Integer size,
			@RequestParam(required = false, defaultValue = "CREATETIME", value = "sortProperty") String sortProperty,
			@RequestParam(required = false, defaultValue = "ASC", value = "sortDerect") String sortDerect,
			@RequestParam(value = "modelCode") String modelCode,
			@RequestParam(required = false, value = "parentDataId") String parentDataId,
			@RequestParam(required = false, value = "fields") String fields);

	/**
	* @Title findByStringFilter
	* @author yangmaoli
	* @Description: 根据输入条件查询数据
	* @date 2018年3月30日
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
	public ResponseData findByStringFilter(Integer page, Integer size, String sortProperty, String sortDerect,
			String modelId, String modelCode, String filterJson, String fields);

}
