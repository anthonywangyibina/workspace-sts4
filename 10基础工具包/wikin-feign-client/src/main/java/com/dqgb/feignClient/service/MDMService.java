package com.dqgb.feignClient.service;

import com.dqgb.common.response.ResponseData;

public interface MDMService {
	/**
	 * 通过模型code和字典code查询字典数据
	 * @param modelCode 模型code
	 * @param code 字典code
	 * @return
	 */
	public ResponseData findDataByModelCodeAndCode(String modelCode,String code) ;
	/**
	 * 通过模型code查询字典数据（不分页）
	 * @param modelCode 模型code
	 * @return
	 */
	public ResponseData findDataByModelCode(String modelCode);
	
	/**
	 * 通过模型code分页查询字典数据
	 * @Title findDataByModelCodeAndByPages
	 * @param page 当前页
	 * @param size 每页显示的条数
	 * @param sortProperty 排序字段
	 * @param sortDerect 升序(ASC)/降序(DESC)
	 * @param modelCode 模型code
	 * @return ResponseData
	 */
	public ResponseData findDataByModelCodeAndByPages(Integer page, Integer size,String sortProperty,String sortDerect,String modelCode) ;
	
	/**
	 * 根据传入时间获取有改变的数据：包括新增add、修改update、删除delete
	 * @Title getMdmDataList
	 * @param dataType  数据对像编码   
	 * @param updateTime 更新时间:yyyy-MM-dd HH:mm:ss
	 * @param current 当前页
	 * @param pageSize 每页显示的条数
	 * @return
	 */
	public ResponseData getMdmDataList(String dataType,String updateTime,
			Integer current, Integer pageSize) ;

}
