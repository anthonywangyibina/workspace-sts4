package com.dqgb.feignClient.serviceFeign;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import com.dqgb.common.response.ResponseData;
import com.dqgb.feignClient.domain.FileInfo;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
/**
 * 
 * @author test
 *
 */
@FeignClient(name = "wikin-fastdfs", configuration = {IWikinFastDFSFeign.MyConfig.class})
public interface IWikinFastDFSFeign {

    @Configuration
	class MyConfig{
		  @Autowired
		  private ObjectFactory<HttpMessageConverters> messageConverters;
		 @Bean
		  public Encoder feignFormEncoder () {
		    return new SpringFormEncoder(new SpringEncoder(messageConverters));
		  }
		
	}
	
	
	/**
	 * 文件上传返回文件信息
	 * @param file 文件信息
	 * @param fileInfo 文件信息实体
	 * @return
	 */
	@RequestMapping(value="/files", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	public ResponseData upload(@RequestPart(value = "file") MultipartFile file,@SpringQueryMap FileInfo fileInfo);
	
	/**
	 * 文件上传返回id
	 * @param file 
	 * @param fileInfo 文件信息实体
	 * @return
	 */
	@RequestMapping(value="/file", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	public ResponseData uploadFile(@RequestPart(value = "file") MultipartFile file,@SpringQueryMap FileInfo fileInfo);
	
	/**
	 * 分页
	 * @param Pageable  分页
	 * @param fileInfo 文件信息实体
	 * @return
	 */
	@RequestMapping(value="/page", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData findByPage(@SpringQueryMap FileInfo fileInfo,   
			@RequestParam(value="page",required=true) Integer page,
			@RequestParam(value = "size",required = true) Integer size);
			
			
	/**
	 * 根据文件id组批量删除
	 * @param fileId 文件id
	 * @return
	 */
	@RequestMapping(value="/file", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData deleteByFileIdArr(@RequestParam("fileId") String[] fileId);
	/**
	 * 根据文件id查询，以","隔开
	 * @param fileId 文件id
	 * @return
	 */
	@RequestMapping(value="/file", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData findByFileId(@RequestParam("id") String fileId);
	
	
}
