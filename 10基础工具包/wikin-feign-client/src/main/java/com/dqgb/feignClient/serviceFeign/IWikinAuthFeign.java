package com.dqgb.feignClient.serviceFeign;

import java.util.Date;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dqgb.common.response.ResponseData;
import com.dqgb.feignClient.domain.Resource;
import com.dqgb.feignClient.domain.RoleUser;

/**
 * wikin-auth原始接口
 * 
 * @className IWikinAuthFeign
 * @author :技术部-zhangjs
 * @Description
 * @date 2019年9月23日 下午2:12:35
 */

@FeignClient("wikin-auth")
public interface IWikinAuthFeign {

	/**
	 * 根据应用CODE和用户ID查询应用下角色
	 * @Title findRolesByAppCodeAndUserId
	 * @param appCode 应用编码
	 * @param userId 用户主键id
	 * @return ResponseData
	 */
	@RequestMapping(value = "/roles/findRolesByAppCodeAndUserId", method =RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findRolesByAppCodeAndUserId(@RequestParam(value = "appCode")String appCode,@RequestParam(value = "userId") String userId);
	/**
	 * 利用角色id查询，该角色下的所有用户，支持多id查询，多个id以”,”分隔
	 * @Title findDataByRoleIds
	 * @param roleIds 角色Id，支持多id查询，多个id以”,”分隔
	 * @return ResponseData
	 */
	@RequestMapping(value="/roleUser/users",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findDataByRoleIds(@RequestParam(value = "roleIds") String roleIds);
	/**
	 * 根据应用code查询部门数据范围
	 * @Title findTreeDataByCode
	 * @param code  应用编码
	 * @return ResponseData
	 */
	@RequestMapping(value="/userDepartment/treeDataByCode",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findTreeDataByCode(@RequestParam(value = "code") String code);

	
	/**
	 *    分页查找角色列表，包含模糊查询
	 * 默认查询全部角色数据，当传入具体的一个或多个属性值时，则查询与其匹配的数据
	 * @Title findRolesByExample
	 * @param roleName 角色名称
	 * @param page 当前页
	 * @param size 每页显示的条数
	 * @param sortProperty  排序字段
	 * @param sortOrder  升序(ASC)/降序(DESC)
	 * @return ResponseData
	 */
	@RequestMapping(value="/roles",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findRolesByExample(
			@RequestParam(value = "roleName",required = false) String roleName,
			@RequestParam(value="page",required=true) Integer page,
			@RequestParam(value = "size",required = true) Integer size,
			@RequestParam(value = "sortProperty",required = true) String sortProperty,
			@RequestParam(value = "sortOrder",required = true) String sortOrder);
	
	
	/**
	 * 查询用户包含的角色或者不包含的角色
	 * @param userId 用户Id
	 * @param type 0:查询用户拥有的角色,1:查询用户下未包含的角色
	 * @return ResponseData
	 */
	@RequestMapping(value="/roles/userId",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findRoleByUserId(@RequestParam(value = "userId") String userId,@RequestParam(value = "type") Integer type);

	/**
	 * 根据角色编码或者id查询角色,同时输入需同时满足编码与id两个条件
	 * @Title findRoleByRoleExamples
	 * @param code 角色编码
	 * @param id 角色主键id
	 * @return ResponseData
	 */
	@RequestMapping(value="/roles/role",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findRoleByRoleExamples(@RequestParam(value = "code",required = false) String code,@RequestParam(value = "id",required = false) String id);

	/**
	 * 根据用户角色模板查询用户与角色关联关系
	 *  默认查询全部数据，当传入具体的一个或多个属性值时，则查询与其匹配的数据
	 * @param roleUser 用户角色对象
	 * @return ResponseData
	 */
	
	//更新
	@RequestMapping(value = "/roleUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findRoleUserByExample(@ModelAttribute RoleUser roleUser, 
			@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size,
            @RequestParam(value = "sortProperty") String sortProperty,
            @RequestParam(value = "sortDerect") String sortDerect);
	
	/**
	 * 根据角色Id查询角色关联的菜单信息
	 * @param roleId 角色Id
	 * @return ResponseData
	 */
	@RequestMapping(value = "/roleMenu/{roleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findRoleMenuByRoleId(@PathVariable("roleId") String roleId);

	/**
	 * 查询用户在指定菜单下拥有的按钮的信息
	 * @param menuId 父资源ID(菜单ID)
	 * @param userId 用户Id,为空时，取当前登录用户
	 * @return ResponseData
	 */
	@RequestMapping(value = "/resources/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findUserBtnsByMenuIdAndUserId(@RequestParam("resPid") String menuId,
			@RequestParam("userId") String userId);

	
	/**
	 * 根据角色id和部门id查询用户id
	 * @date 2018年6月7日 下午4:43:58
	 * @param roleIds 角色Id集合，用逗号相隔
	 * @param departmentIds 部门Id集合，用逗号相隔
	 * @return ResponseData
	 */
	@RequestMapping(value = "/roleUsers/userIds", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData findUsersByRolesAndDepartmentIds(@RequestParam(value = "roleIds") String roleIds,
			@RequestParam(value = "departmentIds") String departmentIds);

	
	/**
	 * 获取应用-角色树.
	 * @author wenzhang
	 * @param userId
	 * @return ResponseData
	 */
	@RequestMapping(value = "/roles/roleTree", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ResponseData getRoleTree(@RequestParam("userId") String userId);


	
	/**
	 * 根据资源模板查询资源
	 *  默认查询全部数据，当传入具体的一个或多个属性值时，则查询与其匹配的数据
	 * @param resource 资源实体类
	 * @param page 当前页
	 * @param sortProperty 排序字段
	 * @param sortDerect 排序方式Asc/Desc
	 * @return ResponseData
	 */
	@RequestMapping(value = "/resources", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findMenu(@RequestBody Resource resource, @RequestParam(value = "page") Integer page,
			@RequestParam(value = "size") Integer size, @RequestParam(value = "sortProperty") String sortProperty,
			@RequestParam(value = "sortOrder") String sortDerect); 
	
	
	/**
	 * 根据角色id和资源名称，查询角色所拥有的应用
	 * @param roleId 角色id
	 * @param resourceName 资源名称
	 * @return ResponseData
	 */
	@RequestMapping(value = "/resources/applications", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findRoleApplication(@RequestParam("roleId") String roleId,
			@RequestParam(value="resourceName",required=false) String resourceName);
	/**
	 * 根据应用CODE查询应用下的角色
	 * @param appCode 应用编码
	 * @return ResponseData
	 */
	@RequestMapping(value = "/roles/findRolesByAppCode", method =RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findRolesByAppCode(@RequestParam("appCode") String appCode);

	/**
	 * 根据用户id获取当前用户的部门权限树结构
	 * @param userId 用户id
	 * @return
	 */
	@RequestMapping(value = "/userDepartment/treeDataByUserId", method =RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findTreeDataByUserId(@RequestParam("userId") String userId);
	/**
	 * 根据用户id和应用编码获取当前用户的部门权限树结构
	 * @param userId 用户id
	 * @return
	 */
	@RequestMapping(value = "/userDepartmentTree/findByUserAddAppCode", method =RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findTreeDataByUserIdAddAppCode(@RequestParam("userId") String userId,@RequestParam(value = "applicationCode",required = false) String applicationCode);
	/**
	 * 根据用户id和应用名称获取当前用户的部门权限树结构
	 * @Title findTreeDataByUserIdAndAppName
	 * @param userId 用户id
	 * @param applicationName 应用名称
	 * @return ResponseData
	 */
	@RequestMapping(value = "/userDepartment/treeDataByUserId", method =RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findTreeDataByUserIdAndAppName(@RequestParam(value = "userId",required = true) String userId,@RequestParam(value = "applicationName",required = false) String applicationName);
	/**
	 * 根据用户id获取当前用户的部门权限
	 * @param userIds 用户id
	 * @return
	 */
	@RequestMapping(value = "/userDepartment/departments",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findDepartmentByUserId(@RequestParam("userIds")String userIds);
	
	/**
	 * 查询用户权限
	 * @param userId 用户id
	 * @return
	 */
	@RequestMapping(value = "/roleUsers/userRights",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findUserRightsByUserId(@RequestParam("userId")String userId);
	/**
	 * 查询用户权限
	 * @param userId 用户id
	 * @param URL 资源url
	 * @param method 请求方法
	 * @return
	 */
	@RequestMapping(value = "/roleUsers/roleRights",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findRoleRightsByUserId(@RequestParam("userId")String userId,@RequestParam("URL")String URL,
			@RequestParam("method")String method);
	
	
	/**
	 *  利用模板查询角色部门数据
	 * @param page 当前页
	 * @param size 每页显示的条数
	 * @param sortProperty 排序字段
	 * @param sortDerect 升序(ASC)/降序(DESC)
	 * @param id 	主键ID
	 * @param roleID  角色ID
	 * @param departmentID 	组织ID
	 * @return
	 */
	@RequestMapping(value = "/roleDepartments", method =RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	ResponseData findRoleDepartmentByExample(@RequestParam(value="page",required=false,defaultValue="0") Integer page,
			@RequestParam(value="size",required=false,defaultValue="15") Integer size,
			@RequestParam(value="sortProperty",required=false,defaultValue="id") String sortProperty,
			@RequestParam(value="sortDerect",required=false,defaultValue="DESC") String sortDerect,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="roleID",required=false) String roleID,
			@RequestParam(value="departmentID",required=false) String departmentID);
	

}
