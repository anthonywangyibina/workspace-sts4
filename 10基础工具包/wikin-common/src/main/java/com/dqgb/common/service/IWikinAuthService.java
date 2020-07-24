package com.dqgb.common.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dqgb.common.response.ResponseData;
/**
 * 调用权限中心接口
 *@className IWikinAuthService
 *@author wenzhang
 *@Description  调用权限中心接口
 *@date 2018年6月7日 下午4:41:39
 */
@FeignClient("wikin-auth")
public interface IWikinAuthService {
	/**
	 * 查询用户权限
	 * @Title findUserRights
	 * @author ly
	 * @Description 查询用户权限
	 * @date 2018年6月7日 下午4:41:53
	 * @param userId
	 * @return ResponseData
	 */
	@RequestMapping(value = "/roleUsers/userRights", method = RequestMethod.GET)
	public ResponseData findUserRights(@RequestParam(required = false, value = "userId") String userId);

	/**
	 * 根据权限编码查询用户
	 * @Title findUsersByResourceCode
	 * @author lk-pc
	 * @Description 根据权限编码查询用户
	 * @date 2018年6月7日 下午4:42:28
	 * @param resourceCode
	 * @param tenant
	 * @return ResponseData
	 */
	@RequestMapping(value = "/resources/resourceUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData findUsersByResourceCode(@RequestParam(value = "resourceCode") String resourceCode);

	/**
	 * 查询角色对象.
	 * @Title findRoleByExample
	 * @author wenzhang
	 * @Description 查询角色对象.
	 * @date 2018年6月7日 下午4:42:43
	 * @param page 页码
	 * @param size 每页显示个数
	 * @param sortProperty 排序字段
	 * @param sortOrder 升序/降序
	 * @return ResponseData
	 */
	@RequestMapping(value = "/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData findRoleByExample(@RequestParam(value = "page") Integer page,
			@RequestParam(value = "size") Integer size, @RequestParam(value = "sortProperty") String sortProperty,
			@RequestParam(value = "sortOrder") String sortOrder);

	/**
	 * 根据角色id查询相关人员.
	 * @Title findUserByRoleId
	 * @author wenzhang
	 * @Description 根据角色id查询相关人员.
	 * @date 2018年6月7日 下午4:43:17
	 * @param roleIds
	 * @return ResponseData
	 */
	@RequestMapping(value = "/roleUser/users", method = RequestMethod.GET)
	public ResponseData findUserByRoleId(@RequestParam("roleIds") String roleIds);
	/**
	 * 获取当前登录用户的应用信息
	 * @Title findAppByLoginUser
	 * @author yangmaoli
	 * @Description 获取当前登录用户的应用信息
	 * @date 2018年6月7日 下午4:43:41
	 * @return ResponseData
	 */
	@RequestMapping(value = "/userApplication/applications", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData findAppByLoginUser();

	/**
	 * 根据角色id和部门id查询用户id.
	 * @Title findUsersByRolesAndDepartmentIds
	 * @author wenzhang
	 * @Description 根据角色id和部门id查询用户id.
	 * @date 2018年6月7日 下午4:43:58
	 * @param roleIds
	 * @param departmentIds
	 * @return ResponseData
	 */
	@RequestMapping(value = "/roleUsers/userIds", method = RequestMethod.GET)
	public ResponseData findUsersByRolesAndDepartmentIds(@RequestParam(value = "roleIds") String roleIds,
			@RequestParam(value = "departmentIds") String departmentIds);

	/**
	 * 获取应用-角色树.
	 * @Title getRoleTree
	 * @author wenzhang
	 * @Description 获取应用-角色树.
	 * @date 2018年6月7日 下午4:44:19
	 * @param userId
	 * @return ResponseData
	 */
	@RequestMapping(value = "/roles/roleTree", method = RequestMethod.GET)
	public ResponseData getRoleTree(@RequestParam("userId") String userId);
}
