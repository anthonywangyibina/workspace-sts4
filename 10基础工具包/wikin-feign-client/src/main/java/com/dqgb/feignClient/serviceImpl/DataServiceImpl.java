package com.dqgb.feignClient.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dqgb.common.response.ResponseData;
import com.dqgb.feignClient.service.DataService;
import com.dqgb.feignClient.serviceFeign.IWikinDataFeign;
@Service

public class DataServiceImpl implements DataService {
	
	@Autowired
	private IWikinDataFeign iWikinDataFeign;
	 
	/**  
	 * 通过部门id查询用户列表， 支持多id查询，id以","分隔  {'FK_DEPARTMENT_ID=':'0c99d5b572384437bf7660553bc7dc5c','0f7f257fb9e549f6b4522bf04a3005b8'}
	 * @Title findUserDataByFKDepartmentId
	 * @param fkDepartmentId 部门id，支持多id查询，id以","分隔
	 * @return ResponseData
	 */
	@Override
	public ResponseData findUserDataByFKDepartmentId(String fkDepartmentId) {
		return iWikinDataFeign.findData(null, null, null, null, null, "user", "{'FK_DEPARTMENT_ID=':'"+fkDepartmentId+"'}", null);
	}
	
	/**
	 * 通过id查询用户，支持多个id查询，以","隔开
	 * @Title findUserByIds
	 * @param Id 用户主键，支持多个id查询，以","隔开
	 * @return ResponseData
	 */
	@Override
	public ResponseData findUserByIds(String id) {
		return iWikinDataFeign.findData(null, null, null, null, null, "user", "{'ID=':'"+id+"'}", null);
	}

	
	/**
	 * 通过账号查询用户，支持多个账号查询，以","隔开
	 * @Title findUserByUserNames 
	 * @param userName 用户账号，支持多个账号查询，以","隔开
	 * @return ResponseData
	 */
	@Override
	public ResponseData findUserByUserNames(String userName) {
		return	iWikinDataFeign.findData(null, null, null, null, null, "user", "{'USER_NAME=':'"+userName+"'}", null);
	}

	
	
	
	
	
	
}
