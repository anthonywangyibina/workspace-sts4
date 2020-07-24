/**
 * @项目名:wikin-bpm
 * @文件名:IUserService.java
 * @包名:com.dqgb.bpm.service
 * @描述 IUserService.java
 * @修改人 wenzhang
 * @修改时间:2018年4月25日下午3:26:23
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.service;

import java.util.List;

import com.dqgb.common.response.ResponseData;
import com.dqgb.common.vo.DepartmentVo;
import com.dqgb.common.vo.RoleVo;
import com.dqgb.common.vo.UserVo;
/**
 * 查询用户信息公用service.
 *@className IUserService
 *@author wenzhang
 *@Description  查询用户信息公用service.
 *@date 2018年6月7日 下午4:37:01
 */
public interface IUserCommonService {
	/**
	 * 根据条件去数据中心获取用户信息（多人）.
	 * @Title getUsersByFeign
	 * @author wenzhang
	 * @Description 根据条件去数据中心获取用户信息（多人）.
	 * @date 2018年6月7日 下午4:37:21
	 * @param page 当前页
	 * @param size 每个个数
	 * @param sortProperty
	 * @param sortDerect
	 * @param filterJson
	 * @return List<UserVo>
	 */
	public List<UserVo> getUsersByFeign(int page, int size, String sortProperty, String sortDerect, String filterJson);
	/**
	 * 根据多个角色id获取用户信息.
	 * @Title getUserInfosBelongRoles
	 * @author wenzhang
	 * @Description 根据多个角色id获取用户信息.
	 * @date 2018年6月7日 下午4:37:51
	 * @param roleIds
	 * @return ResponseData
	 */
	public ResponseData getUserInfosBelongRoles(String roleIds);
	/**
	 * 根据角色和部门，联合查询出用户.
	 * @Title getUsersByRoleWithDepartment
	 * @author wenzhang
	 * @Description 根据角色和部门，联合查询出用户.
	 * @date 2018年6月7日 下午4:38:25
	 * @param roleId
	 * @param departmentId
	 * @return ResponseData
	 */
	public ResponseData getUsersByRoleWithDepartment(String roleId, String departmentId);

	/**
	 * 通过feign调用，获取角色集合.
	 * @Title getRolesByFeign
	 * @author wenzhang
	 * @Description 通过feign调用，获取角色集合.
	 * @date 2018年6月7日 下午4:38:46
	 * @param page
	 * @param size
	 * @param sortProperty
	 * @param sortOrder
	 * @return List<RoleVo>
	 */
	public List<RoleVo> getRolesByFeign(int page, int size, String sortProperty, String sortOrder);
	/**
	 * 调用数据中心获取部门信息.
	 * @Title getDepartmentsByFeign
	 * @author wenzhang
	 * @Description 调用数据中心获取部门信息.
	 * @date 2018年6月7日 下午4:39:03
	 * @param page
	 * @param size
	 * @param sortProperty
	 * @param sortDerect
	 * @param filterJson
	 * @return List<DepartmentVo>
	 */
	public List<DepartmentVo> getDepartmentsByFeign(int page, int size, String sortProperty, String sortDerect,
			String filterJson);
	/**
	 * 调取数据中心结构，获取树结构.
	 * @Title findTreeData
	 * @author wenzhang
	 * @Description 调取数据中心结构，获取树结构.
	 * @date 2018年6月7日 下午4:39:24
	 * @param page 当前页
	 * @param size 每页条数
	 * @param childSortProperty
	 * @param childSortDerect
	 * @param parentSortProperty
	 * @param parentSortDerect
	 * @param modelParentCode
	 * @param modelChildCode
	 * @param treeParentNameField
	 * @param treeChildNameField
	 * @return ResponseData
	 */
	public ResponseData findTreeData(Integer page, Integer size, String childSortProperty, String childSortDerect,
			String parentSortProperty, String parentSortDerect, String modelParentCode, String modelChildCode,
			String treeParentNameField, String treeChildNameField);

	/**
	 * 根据用户账号，批量查询用户id，以,相连..
	 * @Title getUserIdInBatch
	 * @author wenzhang
	 * @Description 根据用户账号，批量查询用户id，以,相连..
	 * @date 2018年6月7日 下午4:40:31
	 * @param usernames
	 * @return String
	 */
	public String getUserIdInBatch(String usernames);
	/**
	 * 根据用户id，批量查询用户账号，以,相连.
	 * @Title getUsernameInBatch
	 * @author wenzhang
	 * @Description 根据用户id，批量查询用户账号，以,相连.
	 * @date 2018年6月7日 下午4:40:47
	 * @param ids
	 * @return String
	 */
	public String getUsernameInBatch(String ids);

}
