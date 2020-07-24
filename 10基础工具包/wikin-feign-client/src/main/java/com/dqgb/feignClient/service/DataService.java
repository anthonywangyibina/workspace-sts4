package com.dqgb.feignClient.service;


import com.dqgb.common.response.ResponseData;

public interface DataService {
	/**
	 * 通过部门id查询用户列表  支持多id查询，id以","分隔
	 * @Title findUserDataByFKDepartmentId
	 * @param fkEnterpriseId 部门id，支持多id查询，id以","分隔
	 * @return ResponseData
	 */
	public ResponseData findUserDataByFKDepartmentId(String fkEnterpriseId);
	
	/**
	 * 通过id查询用户，支持多个id查询，以","隔开
	 * @Title findUserByIds
	 * @param Id 用户主键，支持多个id查询，以","隔开
	 * @return ResponseData
	 */
	public ResponseData findUserByIds(String Id);
	
	/**
	 * 通过账号查询用户，支持多个账号查询，以","隔开
	 * @Title findUserByUserNames 
	 * @param userName 用户账号，支持多个账号查询，以","隔开
	 * @return ResponseData
	 */
	public ResponseData findUserByUserNames(String userName) ;
	
	
	
	
}
