/**
 * @项目名:wikin-common
 * @文件名:IWikinFileServie.java
 * @包名:com.dqgb.common.service
 * @描述 IWikinFileServie.java
 * @修改人 wenzhang
 * @修改时间:2018年2月5日下午4:53:16
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.feignClient.serviceFeign;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dqgb.common.response.ResponseData;

/**
 * ClassName:IWikinFileServie <br/>
 * Function: 公用文件中心路径方法 <br/>
 * Reason: 统一路径，调用公用. <br/>
 * Date: 2018年2月5日 下午4:53:16 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
@FeignClient("wikin-file")
public interface IWikinFileFeign {

	/**
	 * 多个文件且或目录下载. 单个文件id，则下载文件本身。多个文件或目录id则以压缩包的形式下载
	 * @param ids
	 *            文件或目录id集合
	 * @param progressBarsKey
	 *            
	 */
	@RequestMapping(value = "/files/files", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public void downloadFiles(@RequestParam(value = "ids") List<String> ids,
			@RequestParam(value = "progressBarsKey") String progressBarsKey);

	/**
	 * 其他程序调用文件上传接口，将文件信息存入数据表.
	 * @param filePath
	 *            文件保存路径，例如：DQGB-wikin-通知通告。DQGB:租户标识 wikin：模块编码 通知通告：当前模块中文名
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
	 * @return ResponseData[data:[上传文件信息，id，type，name]]
	 */
	@RequestMapping(value = "/files/businessFiles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData uploadFiles(@RequestParam(value = "filePath") String filePath,
			@RequestParam(value = "userId") String userId, @RequestParam(value = "businessId") String businessId,
			@RequestParam(value = "description") String description, @RequestParam(value = "type") String type,
			HttpServletRequest request);

	/**
	 * 传入业务id，下载文件和目录（包含其下按层级所有目录和文件）放入压缩包统一下载.
	 * @param businessIds
	 *            业务id集合
	 */
	@RequestMapping(value = "/files/businessFiles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public void download(@RequestParam(value = "businessIds") List<String> businessIds);

	/**
	 * 传入单个业务id，分页查询文件详情.
	 * @param businessId
	 *            业务id
	 * @param page
	 *            页码
	 * @param size
	 *            每页个数
	 * @return 文件对象集合分页信息
	 */
	@RequestMapping(value = "/files/fileDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData getFileDetail(@RequestParam(value = "businessId") String businessId,
			@RequestParam(value = "page") int page, @RequestParam(value = "size") int size);

	/**
	 * 其他程序传入多个业务id，获取文件详情接口，不分页查询.
	 * @param businessIds
	 *            业务id集合
	 * @return 文件对象集合
	 */
	@RequestMapping(value = "/files/fileDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData getFileDetails(@RequestParam(value = "businessIds") List<String> businessIds);
}
