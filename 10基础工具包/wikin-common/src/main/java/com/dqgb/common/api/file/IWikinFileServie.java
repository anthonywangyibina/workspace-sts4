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

package com.dqgb.common.api.file;

import com.dqgb.common.response.ResponseData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
public interface IWikinFileServie {

	/**
	 * 根据文件或目录Id下载文件
	 * @author wenzhang
	 * @date:2018年2月5日 下午4:57:48
	 * @Title:downloadFiles
	 * @param ids 文件或目录id集合
	 <pre>
	    <b>请求地址</b>：/wikin-file/files/files
	  	<b>请求方式</b>: get
	  	<b>请求案例</b>：   
	             ids:M00/00/00/CnJIgF0IeIeAaqDeABW4RAoYO2k29.docx	===>多个文件或目录以","分割
	</pre>
	 * @return 文件流当个文件直接下载，目录或多个文件压缩后再下载
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/files/files", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void downloadFilesById(@RequestParam(value = "ids") List<String> ids);

	/**
	 * @Description:其他程序调用文件上传接口并将文件业务信息存入数据表.
	 * @author wenzhang
	 * @date:2018年2月5日 下午5:00:14
	 * @Title:uploadFiles
	 * @param filePath
	 *            文件保存路径，例如：DQGB-wikin-通知通告。wikin：模块编码 通知通告：当前模块中文名
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
	 <pre>
	<b>请求地址</b>：/wikin-file/files/businessFiles
	<b>请求方式</b>: post
	<b>请求案例</b>：
	filePath:DQGB-wikin-通知通告	===>文件路径格式： 租户-模块编码-当前模块中文名
	userId:3594926a55c1436584e0c8319fb94c3c	===>上传人
	description:测试一下	===>文件描述
	businessId:ssasasasassa	===> 业务ID
	type:web	===> 区分web端和手持端 web端：web；手持端：android
	file:	===>二进制文件
	</pre>
	 * @return ResponseData[data:[上传文件信息，id，type，name]]
	 * <pre>
	 <b>1.没有上传文件时</b>
	{
	"rspCode": "999999",
	"rspMsg": "操作失败",
	"data": "请选择至少一个文件"
	}
	<b>2.上传成功</b>
	{
	"rspCode": "000000",
	"rspMsg": "操作成功",
	"data": [
	{
	"fileId": null,
	"fileName": "file",
	"upload": false
	}
	]
	}
	 * </pre>
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/files/businessFiles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData uploadFiles(@RequestParam(value = "filePath") String filePath,
                                    @RequestParam(value = "userId") String userId, @RequestParam(value = "businessId") String businessId,
                                    @RequestParam(value = "description") String description, @RequestParam(value = "type") String type,
                                    HttpServletRequest request);

	/**
	 * @Description:根据业务ID下载文件
	 * @author wenzhang
	 * @date:2018年2月5日 下午5:06:17
	 * @Title:download
	 * @param businessIds业务id集合
	<pre>
	<b>请求地址</b>：/wikin-file/files/businessFiles
	<b>请求方式</b>: get
	<b>请求案例</b>：
	businessId:4015eba554cc4790b150df9f9a6e9db0  ===>业务ID 多个以“,”分割
	</pre>
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/files/businessFiles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void downloadByBusinessIds(@RequestParam(value = "businessIds") List<String> businessIds);

	/**
	 * @Description:根据业务id查询文件详情
	 * @author wenzhang
	 * @date:2018年2月5日 下午5:11:00
	 * @Title:getFileDetail
	 * @param businessId
	 *            业务id
	 * @param page
	 *            页码
	 * @param size
	 *            页码大小
	<pre>
	<b>请求地址</b>：/wikin-file/files/fileDetail
	<b>请求方式</b>: get
	<b>请求案例</b>：
	businessId:4015eba554cc4790b150df9f9a6e9db0  ===>业务ID
	page:0  ===>当前所在页数
	size:1  ===>分页大小
	</pre>
	@return 文件对象集合分页信息
	 <pre>
	<b>响应案例</b>
	{
	"rspCode": "000000",  ===>响应编码
	"rspMsg": "操作成功",  ===>效应提示时间
	"data": {  ===>数据
	"content": [  ===>数据行
	{
	"businessId": "4015eba554cc4790b150df9f9a6e9db0",
	"fileId": "M00/00/01/CnJIgF0MgBOAaKoOAAHReXZku-U587.png",
	"name": "查看详情",
	"type": "png",
	"descrption": null,
	"downloadUrl": null,
	"readOnlineUrl": null,
	"pageCount": 1
	}
	],
	"last": true,  ===>是否最后一页
	"totalPages": 1,  ===>总页数
	"totalElements": 1,  ===>元素总数
	"first": true,  ===>是否是第一页
	"sort": [  ===>排序信息
	{
	"direction": "DESC",
	"property": "uploadTimeEnd",
	"ignoreCase": false,
	"nullHandling": "NATIVE",
	"descending": true,
	"ascending": false
	}
	],
	"numberOfElements": 1,  ===>当前页元素个数
	"size": 1,  ===>分页大小
	"number": 0  ===>当页页码
	}
	}
	</pre>
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/files/fileDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData getFileDetail(@RequestParam(value = "businessId") String businessId,
                                      @RequestParam(value = "page") int page, @RequestParam(value = "size") int size);

	/**
	 * @Description:根据业务id查询文件详情 不分页
	 * @author wenzhang
	 * @date:2018年2月5日 下午5:09:17
	 * @Title:getFileDetails
	 * @param businessIds
	 *            业务id集合
	   <pre>
	  	<b>请求地址</b>：/wikin-file/files/fileDetails
	  	<b>请求方式</b>: get
	  	<b>请求案例</b>：
	  	businessId:4015eba554cc4790b150df9f9a6e9db0  ===>业务ID 多个页业务以“,”分割
	   	</pre>
	 * @return 文件对象集合
	 <pre>
	<b>响应案例</b>
	{
	"rspCode": "000000",  ===>响应编码
	"rspMsg": "操作成功",  ===>响应提示信息
	"data": [  ===>响应行
	{
	"businessId": "4015eba554cc4790b150df9f9a6e9db0",
	"fileId": "M00/00/01/CnJIgF0MgBOAaKoOAAHReXZku-U587.png",
	"name": "查看详情",
	"type": "png",
	"descrption": null,
	"downloadUrl": null,
	"readOnlineUrl": null,
	"pageCount": 0
	}
	]
	}
	</pre>
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/files/fileDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData getFileDetails(@RequestParam(value = "businessIds") List<String> businessIds);
}
