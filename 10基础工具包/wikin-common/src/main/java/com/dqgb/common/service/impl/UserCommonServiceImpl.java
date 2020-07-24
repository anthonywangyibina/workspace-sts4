/**
 * @项目名:wikin-bpm
 * @文件名:UserServiceImpl.java
 * @包名:com.dqgb.bpm.service.impl
 * @描述 UserServiceImpl.java
 * @修改人 wenzhang
 * @修改时间:2018年4月25日下午3:27:12
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dqgb.common.constant.CommonConst;
import com.dqgb.common.domain.BusinessLog;
import com.dqgb.common.response.ResponseData;
import com.dqgb.common.response.ResponseMsg;
import com.dqgb.common.service.IUserCommonService;
import com.dqgb.common.service.IWikinAuthService;
import com.dqgb.common.service.IWikinDatacenterService;
import com.dqgb.common.service.IWikinLogService;
import com.dqgb.common.service.impl.BaseServiceImpl;
import com.dqgb.common.utils.BusinessLogCreate;
import com.dqgb.common.utils.StringUtil;
import com.dqgb.common.vo.DepartmentVo;
import com.dqgb.common.vo.RoleVo;
import com.dqgb.common.vo.UserVo;

/**
 * ClassName:UserServiceImpl <br/>
 * Function: 和用户相关的调取服务层. <br/>
 * Date: 2018年4月25日 下午3:27:12 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
@Component
@Service
public class UserCommonServiceImpl extends BaseServiceImpl implements IUserCommonService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());// 日志

	@Autowired
	private IWikinAuthService authService;

	@Autowired
	private IWikinDatacenterService dataCenterService;

	@Autowired
	private IWikinLogService logService;

	/**
	 * 根据用户属性是否为空，返回值
	 * 
	 * @param obj
	 * @return
	 */
	private String objToString(Object obj) {
		return obj != null ? (String) obj : null;
	}

	@Override
	public List<UserVo> getUsersByFeign(int page, int size, String sortProperty, String sortDerect, String filterJson) {
		List<UserVo> voList = new ArrayList<UserVo>();
		try {
			ResponseData res = dataCenterService.findByStringFilter(page, size, sortProperty, sortDerect, null, "user",
					filterJson, null);
			Map<String, List<Map<String, Object>>> linesdata = (Map<String, List<Map<String, Object>>>) res.getData();
			// 解析feign返回值
			List<Map<String, Object>> list = linesdata.get("content");
			if (!list.isEmpty()) {
				UserVo user = null;
				for (Map<String, Object> map : list) {
					user = new UserVo();
					user.setUserId(objToString(map.get("ID")));
					user.setUserName(objToString(map.get("USER_NAME")));
					user.setRealName(objToString(map.get("REAL_NAME")));
					user.setPassword(objToString(map.get("PASSWORD")));
					user.setEmail(objToString(map.get("USEREMAIL")));
					user.setTelephone(objToString(map.get("TELEPHONE")));
					user.setDepartmentId(objToString(map.get("FK_DEPARTMENT_ID")));
					user.setDepartmentName(objToString(map.get("FK_DET_ID_DEPARTMENT_NAME")));
					user.setRfid(objToString(map.get("RFID")));
					user.setErpId(objToString(map.get("ERPID")));
					user.setTeamId(objToString(map.get("FK_TEAM_ID")));
					user.setTeamName(objToString(map.get("FK_TEAM_ID_TEAM_NAME")));
					user.setAddress(objToString(map.get("ADDRESS")));
					voList.add(user);
				}
			}
			return voList;
		} catch (Exception e) {
			logger.error(CommonConst.LOG_TYPE._SERVICE._SEARCH + CommonConst.OPERATION._FAILED + "批量获取用户时报错:" + filterJson, e);
			return voList;
		}
	}

	@Override
	public ResponseData getUserInfosBelongRoles(String roleIds) {
		// 根据多个角色id获取用户集合
		List<UserVo> list = getUserByRoles(roleIds);
		/*
		 * 对用户集合去重
		 */
		Map<String, UserVo> map = new HashMap<String, UserVo>();
		for (UserVo vo : list) {
			map.put(vo.getUserId(), vo);
		}
		if (map.size() > 0) {
			List<UserVo> voList = new ArrayList<UserVo>();
			for (String id : map.keySet()) {
				UserVo vo = map.get(id);
				voList.add(vo);
			}
			return new ResponseData(ResponseMsg.SUCCESS, voList);
		} else {
			logger.error(CommonConst.LOG_TYPE._SERVICE._SEARCH + CommonConst.OPERATION._FAILED + "批量根据角色获取用户时报错:" + roleIds);
			return new ResponseData(ResponseMsg.FAILED);
		}
	}

	/**
	 * 
	 * @Description:调用权限中心接口，返回用户集合.
	 *
	 * @author wenzhang
	 * @date:2018年4月24日 下午4:40:56
	 * @Title:getUsersByRole
	 * @param roleIds
	 *            多个角色id
	 * @return
	 * @since JDK 1.8
	 */
	private List<UserVo> getUserByRoles(String roleIds) {
		List<UserVo> voList = new ArrayList<UserVo>();
		try {
			ResponseData res = authService.findUserByRoleId(roleIds);
			List<Map<String, Object>> list = (List<Map<String, Object>>) res.getData();
			if (!list.isEmpty()) {
				UserVo user = null;
				for (Map<String, Object> map : list) {
					user = new UserVo();
					user.setUserId(objToString(map.get("userId")));
					user.setUserName(objToString(map.get("userName")));
					user.setRealName(objToString(map.get("realName")));
					user.setEmail(objToString(map.get("email")));
					user.setTelephone(objToString(map.get("telephone")));
					user.setDepartmentId(objToString(map.get("departmentId")));
					user.setDepartmentName(objToString(map.get("departmentName")));
					user.setTeamId(objToString(map.get("teamId")));
					user.setTeamName(objToString(map.get("teamName")));
					user.setRfid(objToString(map.get("rfid")));
					user.setErpId(objToString(map.get("erpId")));
					user.setAddress(objToString(map.get("address")));
					//user.setTenant(objToString(map.get("tenant")));
					voList.add(user);
				}
			}
			return voList;
		} catch (Exception e) {
			logger.error(CommonConst.LOG_TYPE._SERVICE._SEARCH + CommonConst.OPERATION._FAILED + "调取权限中心根据角色获取用户时报错:" + roleIds, e);
			return voList;
		}
	}

	@Override
	public ResponseData getUsersByRoleWithDepartment(String roleId, String departmentId) {
		ResponseData res = authService.findUsersByRolesAndDepartmentIds(roleId, departmentId);
		String data = objToString(res.getData());
		if (StringUtil.isEmpty(data)) {
			return new ResponseData(ResponseMsg.FAILED.getCode(), "未查询到相关人员");
		}
		List<UserVo> list = getUsersByFeign(0, 1000000, "createTime", "ASC", "ID:\"" + data + "\"");
		return !list.isEmpty() ? new ResponseData(ResponseMsg.SUCCESS, list) : new ResponseData(ResponseMsg.FAILED);
	}

	@Override
	public List<RoleVo> getRolesByFeign(int page, int size, String sortProperty, String sortOrder) {
		List<RoleVo> list = new ArrayList<RoleVo>();
		try {
			ResponseData res = authService.findRoleByExample(0, 100000, "createTime", "ASC");
			Map<String, List<Map<String, Object>>> linesdata = (Map<String, List<Map<String, Object>>>) res.getData();
			// 解析feign返回值
			List<Map<String, Object>> contents = linesdata.get("content");
			if (!contents.isEmpty()) {
				RoleVo role = null;
				for (Map<String, Object> map : contents) {
					role = new RoleVo();
					role.setId(objToString(map.get("id")));
					role.setRoleName(objToString(map.get("roleName")));
					role.setCode(objToString(map.get("code")));
					role.setRightsResource(objToString(map.get("rightsResource")));
					role.setRoleSys(objToString(map.get("roleSys")));
					role.setOperatePerson(objToString(map.get("operatePerson")));
					role.setDescription(objToString(map.get("description")));
					list.add(role);
				}
			}
			return list;
		} catch (Exception e) {
			logger.error(CommonConst.LOG_TYPE._SERVICE._SEARCH + CommonConst.OPERATION._FAILED + "调取权限中心获取全部角色时报错", e);
			return list;
		}
	}

	@Override
	public List<DepartmentVo> getDepartmentsByFeign(int page, int size, String sortProperty, String sortDerect,
			String filterJson) {
		List<DepartmentVo> list = new ArrayList<DepartmentVo>();
		try {
			ResponseData res = dataCenterService.findByStringFilter(page, size, sortProperty, sortDerect, null,
					"department", filterJson, null);
			Map<String, List<Map<String, Object>>> linesdata = (Map<String, List<Map<String, Object>>>) res.getData();
			// 解析feign返回值
			List<Map<String, Object>> contents = linesdata.get("content");
			if (!contents.isEmpty()) {
				DepartmentVo vo = null;
				for (Map<String, Object> map : contents) {
					vo = new DepartmentVo();
					vo.setId(objToString(map.get("ID")));
					vo.setName(objToString(map.get("DEPARTMENT_NAME")));
					vo.setCode(objToString(map.get("DEPARTMENT_CODE")));
					vo.setFkDepartmentId(objToString(map.get("FK_DEPARTMENT_ID")));
					vo.setFkDepartmentName(objToString(map.get("FK_DEP_DEPARTMENT_NAME")));
					vo.setDescription(objToString(map.get("DESCRIPTION")));
					vo.setLeaderId(objToString(map.get("FK_LEADER_USER_ID")));
					list.add(vo);
				}
			}
			return list;
		} catch (Exception e) {
			logger.error(CommonConst.LOG_TYPE._SERVICE._SEARCH + CommonConst.OPERATION._FAILED + "调取数据中心获取全部部门时报错", e);
			return list;
		}
	}

	@Override
	public ResponseData findTreeData(Integer page, Integer size, String childSortProperty, String childSortDerect,
			String parentSortProperty, String parentSortDerect, String modelParentCode, String modelChildCode,
			String treeParentNameField, String treeChildNameField) {
		return dataCenterService.findTreeData(page, size, childSortProperty, childSortDerect, parentSortProperty,
				parentSortDerect, modelParentCode, modelChildCode, treeParentNameField, treeChildNameField);
	}


	@Override
	public String getUserIdInBatch(String usernames) {
		String ids = "";
		try {
			Map<String, String> map = new HashMap<String, String>();
			List<UserVo> list = this.getUsersByFeign(0, 1000000, "createTime", "ASC",
					"\'USER_NAME=\':\'" + usernames + "\'");
			for (UserVo vo : list) {
				if (!map.containsKey(vo.getUserId())) {
					map.put(vo.getUserId(), vo.getUserName());
					ids += vo.getUserId() + ",";
				}
			}
			return ids;
		} catch (Exception e) {
			logger.error(
					CommonConst.LOG_TYPE._SERVICE._SEARCH + CommonConst.OPERATION._FAILED + "调取数据中心根据用户账号批量获取用户id报错:" + usernames,
					e);
			return ids;
		}
	}

	@Override
	public String getUsernameInBatch(String ids) {
		String usernames = "";
		try {
			Map<String, String> map = new HashMap<String, String>();
			List<UserVo> list = this.getUsersByFeign(0, 1000000, "createTime", "ASC", "\'ID=\':\'" + ids + "\'");
			for (UserVo vo : list) {
				if (!map.containsKey(vo.getUserId())) {
					map.put(vo.getUserId(), vo.getUserName());
					usernames += vo.getUserName() + ",";
				}
			}
			return usernames;
		} catch (Exception e) {
			logger.error(CommonConst.LOG_TYPE._SERVICE._SEARCH + CommonConst.OPERATION._FAILED + "调取数据中心根据用户id批量获取用户账号报错:" + ids,
					e);
			return usernames;
		}
	}

}
