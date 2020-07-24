package com.dqgb.common.api.auth;

import com.dqgb.common.response.ResponseData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	 * @param userId 用户Id </br>
     *  <pre>
     * 	<b>请求地址</b>：/wikin-auth/roleUsers/userRights
     * 	<b>请求方式</b>: get
     * 	<b>请求案例</b>：
     *               userId:dc3c31737ed54462a544222917533f86
     *</pre>
	 * @return ResponseData
     * <pre>
    {
    "rspCode": "000000",
    "rspMsg": "操作成功",
    "data": [
    {
    "id": "8af2c993610d2f6a01610d5f8885009f",
    "resourceModule": "文件中心",
    "resourcePid": "8af2c993610d2f6a01610d5f87fb008f",
    "resourceName": "手持端文件删除",
    "resourceCode": "FILE_API",
    "resourceUrl": "/wikin-file/files/mobileFiles",
    "resourceMethod": "POST",
    "resourceOrder": 0,
    "resourceIcon": null,
    "resourceType": "04",
    "resourceState": null,
    "className": "com.dqgb.fileCenter.web.FileController",
    "createTime": 1516347820000,
    "modifyTime": 1516347820000,
    "operatePerson": null,
    "isDeleted": 0,
    "english": null,
    "serviceCode": "wikin-file",
    "loadMethod": null,
    "type": null,
    "loginType": null,
    "reactUrl": null
    }
    ]
    }
     * </pre>
     *
	 */
	@RequestMapping(value = "/roleUsers/userRights", method = RequestMethod.GET)
	public ResponseData findUserRights(@RequestParam(required = true, value = "userId") String userId);

	/**
	 * 根据权限编码查询用户角色关联表
	 * @Title findUsersByResourceCode
	 * @author lk-pc
	 * @Description 根据权限编码查询用户角色关联表
	 * @date 2018年6月7日 下午4:42:28
	 * @param resourceCode 资源编码
     * <pre>
     *<b>请求地址</b>：/wikin-auth/resources/resourceUser
     *<b>请求方式</b>: get
     * <b>请求案例</b>：
     *                     resourceCode:AUTH_BUTTON
     * </pre>
	 * @return ResponseData
  <pre>
    {
    "rspCode": "000000",
    "rspMsg": "操作成功",
    "data": [
    {
    "id": "8af2c8ff6b0cf0fc016b406962c606d5",
    "roleID": "41F945F56C6F47EF92DFB8CC382E2D85",
    "userID": "15449eb3e710400a893e8b0c747ec7ec",
    "createTime": 1560124976000,
    "modifyTime": null,
    "operatePerson": null
    }
    ]
    }
    </pre>
	 */
	@RequestMapping(value = "/resources/resourceUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData findRoleUsersByResourceCode(@RequestParam(required = true, value = "resourceCode") String resourceCode);

	/**
	 * 查询当前用户的角色.
	 * @Title findRoleByExample
	 * @author wenzhang
	 * @Description 查询当前用户的角色.
	 * @date 2018年6月7日 下午4:42:43
	 * @param page 当前页码（0）
	 * @param size 分页大小（1-1000）
	 * @param sortProperty 排序字段
	 * @param sortOrder ASC(升序)/DESC(降序)
     * <pre>
     *<b>请求地址</b>：/wikin-auth/roles
     *<b>请求方式</b>: get
     * <b>请求案例</b>：
    page:0
    size:1
    sortProperty:createTime
    sortOrder:DESC
    </pre>
	 * @return ResponseData
     <pre>
    {
    "rspCode": "000000",
    "rspMsg": "操作成功",
    "data": {
    "content": [
    {
    "id": "8af2c8cd66152bf7016618cfb2c0003d",
    "roleName": "HSE一体化通知通告管理员",
    "code": "HSEYTH_NOTICE_admin",
    "rightsResource": null,
    "rightsSys": null,
    "roleSys": "HSE一体化",
    "roleIsSys": null,
    "createTime": null,
    "modifyTime": 1564457656000,
    "operatePerson": null,
    "description": "sss"
    }
    ],
    "last": false,
    "totalElements": 10495,
    "totalPages": 10495,
    "sort": [
    {
    "direction": "DESC",
    "property": "createTime",
    "ignoreCase": false,
    "nullHandling": "NATIVE",
    "descending": true,
    "ascending": false
    }
    ],
    "first": true,
    "numberOfElements": 1,
    "size": 1,
    "number": 0
    }
    }
    </pre>
	 */
	@RequestMapping(value = "/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData findPageRole(@RequestParam(required = true, value = "page") Integer page,
                                     @RequestParam(required = true, value = "size") Integer size, @RequestParam(required = true, value = "sortProperty") String sortProperty,
                                     @RequestParam(required = true, value = "sortOrder") String sortOrder);

	/**
	 * 根据角色id查询相关人员.
	 * @Title findUserByRoleId
	 * @author wenzhang
	 * @Description 根据角色id查询相关人员.
	 * @date 2018年6月7日 下午4:43:17
	 * @param roleIds 角色id 多个角色 用“,”分隔
     * <pre>
     *<b>请求地址</b>：/wikin-auth/roles
     *b>请求方式</b>: get
     * <b>请求案例</b>：
     *  roleIds:8af2c8ce6782f84d0167bad0dce80688,8af2c8cd679c90240167bad087c304f1
     * </pre>
	 * @return ResponseData
     * <pre>
     *     {
     *   "rspCode": "000000",
     *   "rspMsg": "操作成功",
     *   "data": [
     *     {
     *       "userId": "2d4631c9fadc4fe59c542886fd0accb3",
     *       "userName": "heqd",
     *       "realName": "何清弟",
     *       "password": null,
     *       "telephone": null,
     *       "email": "heqd@petrochina.com.cn",
     *       "departmentName": null,
     *       "departmentId": "8aa48a90646d171301646d4ca59b0006",
     *       "rfid": "",
     *       "erpId": "0",
     *       "teamId": null,
     *       "teamName": null,
     *       "address": null,
     *       "isRegionuser": null,
     *       "ip": null,
     *       "language": "zh_CN"
     *     }
     *   ]
     * }
     * </pre>
	 */
	@RequestMapping(value = "/roleUser/users", method = RequestMethod.GET)
	public ResponseData findUserByRoleId(@RequestParam(required = true, value = "roleIds") String roleIds);
	/**
	 * 获取当前登录用户的应用信息
	 * @Title findAppByLoginUser
	 * @author yangmaoli
	 * @Description 获取当前登录用户的应用信息

	 * @date 2018年6月7日 下午4:43:41
	 * @return ResponseData
     * <pre>
     *{
     *   "rspCode": "000000",
     *   "rspMsg": "操作成功",
     *   "data": [
     *     {
     *       "id": "8af2c993610d2f6a01610d2fc43d0000",
     *       "resourceModule": null,
     *       "resourcePid": null,
     *       "resourceName": "基础平台",
     *       "resourceCode": "wikin",
     *       "resourceUrl": null,
     *       "resourceMethod": null,
     *       "resourceOrder": 0,
     *       "resourceIcon": null,
     *       "resourceType": "01",
     *       "resourceState": null,
     *       "className": null,
     *       "createTime": 1516344689000,
     *       "modifyTime": 1516344689000,
     *       "operatePerson": null,
     *       "isDeleted": 0,
     *       "english": "basic platform",
     *       "serviceCode": null,
     *       "loadMethod": null,
     *       "type": null,
     *       "loginType": null,
     *       "reactUrl": null
     *     }
     *   ]
     * }
     * </pre>
	 */
	@RequestMapping(value = "/userApplication/applications", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData findAppByLoginUser();

	/**
	 * 根据角色id和部门id查询用户id.
	 * @Title findUsersByRolesAndDepartmentIds
	 * @author wenzhang
	 * @Description 根据角色id和部门id查询用户id.
	 * @date 2018年6月7日 下午4:43:58
	 * @param roleIds  角色id
     * @param departmentIds 部门id
     * <pre>
     *<b>请求地址</b>：/wikin-auth/roleUsers/userIds
     *b>请求方式</b>: get
     * <b>请求案例</b>：
     * roleIds:ce1db25c414c4975a1edaa274e7c67f6
     * departmentIds:0f7f257fb9e549f6b4522bf04a3005b8
     * </pre>
	 * @return ResponseData
     * <pre>
     *{
     *   "rspCode": "000000",
     *   "rspMsg": "操作成功",
     *   "data": "dc3c31737ed54462a544222917533f86"
     * }
     * </pre>
	 */
	@RequestMapping(value = "/roleUsers/userIds", method = RequestMethod.GET)
	public ResponseData findUsersByRolesAndDepartmentIds(@RequestParam(required = true, value = "roleIds") String roleIds,
                                                         @RequestParam(required = true, value = "departmentIds") String departmentIds);

	/**
	 * 根据用户Id-获取应用角色树.
	 * @Title getRoleTree
	 * @author wenzhang
	 * @Description 根据用户Id-获取应用角色树.
	 * @date 2018年6月7日 下午4:44:19
	 * @param userId
     *<b>请求地址</b>：/wikin-auth/roles/roleTree
     *b>请求方式</b>: get
     * <b>请求案例</b>
     * userId:dc3c31737ed54462a544222917533f86
     * </pre>

	 * @return ResponseData
     * <pre>
     <b>1.树为空</b>
    {
    "rspCode": "999999",
    "rspMsg": "操作失败",
    "data": "当前用户并无任何应用权限"
    }
     <b>2.树不为空</b>
    {
    "rspCode": "000000",
    "rspMsg": "操作成功",
    "data": [
    {
    "nodeld": "wikin",
    "nodeName": "基础平台",
    "nodeCode": null,
    "nodeType": null,
    "list": [
    {
    "nodeld": "ce1db25c414c4975a1edaa274e7c67f6",
    "nodeName": "管理员",
    "nodeCode": null,
    "nodeType": null,
    "list": null
    }
    ]
    }
    ]
    }
     * </pre>
	 */
	@RequestMapping(value = "/roles/roleTree", method = RequestMethod.GET)
	public ResponseData getAppRoleTreeByUserId(@RequestParam(required = true, value = "userId") String userId);
}
