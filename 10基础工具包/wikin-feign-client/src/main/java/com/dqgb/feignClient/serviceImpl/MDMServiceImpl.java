package com.dqgb.feignClient.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestParam;

import com.dqgb.common.response.ResponseData;
import com.dqgb.common.response.ResponseMsg;
import com.dqgb.feignClient.service.MDMService;
import com.dqgb.feignClient.serviceFeign.IWikinMDMFeign;

@Service
public class MDMServiceImpl implements MDMService{
	@Autowired
	private IWikinMDMFeign iWikinMDMFeign;
	/**
	 * 通过模型code和字典code(相当于一条数据的编码)查询字典数据
	 * @Title findDataByModelCodeAndCode
	 * @param modelCode 模型编码modelCode
	 * @param code 字典编码code
	 * @return ResponseData
	 */
	@Override
	public ResponseData findDataByModelCodeAndCode(String modelCode,String code) {
		return iWikinMDMFeign.findData(null, null, null, null, null, modelCode, "{'code=':'"+code+"'}", null);
	}
	
	/**
	 * 通过模型code查询字典数据,不分页
	 * @Title findDataByModelCode
	 * @param modelCode 模型编码
	 * @return ResponseData
	 */
	@Override
	public ResponseData findDataByModelCode(String modelCode) {
		 ResponseData response = iWikinMDMFeign.findData(null, Integer.MAX_VALUE, null, null, null, modelCode,null, null);
		 if (ObjectUtils.isEmpty(response)) {
			return new ResponseData(ResponseMsg.REF_OBJ_NOT_EXISIT);
		}
		 Map<String,List<Map<String,Object>>> resData=  (Map<String,List<Map<String,Object>>>)response.getData();
		 List<Map<String, Object>> cList = resData.get("content");
		 if (CollectionUtils.isEmpty(cList)) {
			return new ResponseData(ResponseMsg.REF_OBJ_NOT_EXISIT);
		}
		 return  new ResponseData(cList);
		 
	}
	
	/**
	 * 通过模型code分页查询字典数据
	 * @Title findDataByModelCodeAndByPages
	 * @param page
	 *            当前页
	 * @param size
	 *            每页显示的条数
	 * @param sortProperty
	 *            排序字段
	 * @param sortDerect
	 *            升序(ASC)/降序(DESC)
	 * @param modelCode 模型编码
	 * 
	 * @return ResponseData
	 * 
	 */
	@Override
	public ResponseData findDataByModelCodeAndByPages(Integer page, Integer size,String sortProperty,String sortDerect,String modelCode) {
		return iWikinMDMFeign.findData(page, size, sortProperty, sortDerect, null,modelCode, null, null);
	}
	
	/**
	 * 根据传入时间获取有改变的数据：包括新增add、修改update、删除delete
	 * @Title getMdmDataList
	 * @param dataType  数据对像编码  
	 * @param updateTime 更新时间:yyyy-MM-dd HH:mm:ss
	 * @param current 当前页
	 * @param pageSize 每页显示的条数
	 * @return ResponseData
	 */
	@Override
	public ResponseData getMdmDataList(String dataType,String updateTime,
			Integer current, Integer pageSize) {
		return iWikinMDMFeign.getMdmDataList(dataType, updateTime, current, pageSize);
	}
	


}
