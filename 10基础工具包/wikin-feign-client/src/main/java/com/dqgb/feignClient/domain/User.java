package com.dqgb.feignClient.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 用户实体
 *@className User
 *@author :技术部-zhangjs
 *@Description   用户实体
 *@date 2019年9月23日 下午2:09:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	/**
	 * 主键
	 */
	@JsonProperty(value = "ID",required = false)
	private String userId;
	/**
	 * 是否禁用
	 */
	@JsonProperty(value = "IS_DISABLED",required = false)
	private String isDisabled;
	/**
	 * 用户账号
	 */
	@JsonProperty(value = "USER_NAME",required = false)
	private String userName;
	/**
	 * 所属部门
	 */
	@JsonProperty(value = "FK_DEPARTMENT_ID",required = false)
	private String departmentId;
	/**
	 * 密码
	 */
	@JsonProperty(value = "PASSWORD",required = false)
	private String password;
	/**
	 * 是否域用户
	 */
	@JsonProperty(value = "IS_REGIONUSER",required = false)
	private String isRegionUser;
	/**
	 * 邮箱
	 */
	@JsonProperty(value = "USEREMAIL",required = false)
	private String email;
	/**
	 * 电话
	 */
	@JsonProperty(value = "TELEPHONE",required = false)
	private String telephone;
	/**
	 * 姓名
	 */
	@JsonProperty(value = "REAL_NAME",required = false)
	private String realName;
	/**
	 * ERPID
	 */
	@JsonProperty(value = "ERPID",required = false)
	private String erpId;
	/**
	 * RFID
	 */
	@JsonProperty(value = "RFID",required = false)
	private String rfid;
	/**
	 * 班组ID
	 */
	@JsonProperty(value = "FK_TEAM_ID",required = false)
	private String teamId;
	/**
	 * 地址
	 */
	@JsonProperty(value = "ADDRESS",required = false)
	private String address;
	/**
	 * 年龄
	 */
	@JsonProperty(value = "USER_AGE",required = false)
	private String age;
	/**
	 * 性别
	 */
	@JsonProperty(value = "USER_SEX",required = false)
	private String sex;
	/**
	 * 籍贯
	 */
	@JsonProperty(value = "NATIVE_PLACE",required = false)
	private String nativePlace;
	/**
	 * 出生日期
	 */
	@JsonProperty(value = "BIRTHDAY",required = false)
	private String birthday;
	/**
	 * 卡号
	 */
	@JsonProperty(value = "CARD_CODE",required = false)
	private String CARD_CODE;
	/**
	 * 排序
	 */
	@JsonProperty(value = "DIS_ORDER",required = false)
	private String order;
	/**
	 * 电子签名
	 */
	@JsonProperty(value = "ELECTRONIC_SIGNATURE",required = false)
	private String electronicSignature;
	/**
	 * 身份证号
	 */
	@JsonProperty(value = "ID_CARD",required = false)
	private String idCard;
	/**
	 * 职务
	 */
	@JsonProperty(value = "JOB_DICT_CODE",required = false)
	private String jobDictCode;
	/**
	 * 职级
	 */
	@JsonProperty(value = "JOBLEVEL_DICT_CODE",required = false)
	private String jobLevelDictCode;
	/**
	 * 手机号码2
	 */
	@JsonProperty(value = "MOBILE_PHONE2",required = false)
	private String mobilePhone2;
	/**
	 * 个人头像
	 */
	@JsonProperty(value = "PERSONAL_IMAGE",required = false)
	private String personalImage;
	/**
	 * 座机号码
	 */
	@JsonProperty(value = "PHONE_NO",required = false)
	private String phoneNo;
	/**
	 * 职位
	 */
	@JsonProperty(value = "POST_DICT_CODE",required = false)
	private String postDictCode;
	/**
	 * 职称
	 */
	@JsonProperty(value = "POSTTITLE_DICT_CODE",required = false)
	private String postTitleDictCode;
	/**
	 * 集团短号1
	 */
	@JsonProperty(value = "SHORT_NO1",required = false)
	private String shortNo1;
	/**
	 * 集团短号2
	 */
	@JsonProperty(value = "SHORT_NO2",required = false)
	private String shortNo2;
	/**
	 * 上次登录时间
	 */
	@JsonProperty(value = "USER_ONLINE",required = false)
	private String userOnline;
	/**
	 * 创建人
	 */
	@JsonProperty(value = "CREATE_USER",required = false)
	private String createUser;
	/**
	 * 修改时间
	 */
	@JsonProperty(value = "MODIFY_DATE",required = false)
	private String modifyDate;
	/**
	 * 修改人
	 */
	@JsonProperty(value = "MODIFY_USER",required = false)
	private String modifyUser;
	/**
	 * 班组
	 */
	@JsonProperty(value = "TEAM_DICT_CODE",required = false)
	private String teamDictCode;
	/**
	 * 用户类型 类型：本地0, 中油用户1
	 */
	@JsonProperty(value = "TYPE",required = false)
	private String type;
	/**
	 * 是否修改密码 0:未修改密码，1:已修改密码
	 */
	@JsonProperty(value = "IS_UP_PWD",required = false)
	private String isUpPwd;
	/**
	 * 最近一次修改密码时间
	 */
	@JsonProperty(value = "UP_PWD_DATE",required = false)
	private String upPwdDate;
	/**
	 * 部门名称
	 */
	@JsonProperty(value = "FK_DET_ID_DEPARTMENT_NAME",required = false)
	private String departmentName;
	/**
	 * 班组名称
	 */
	@JsonProperty(value = "FK_TEAM_ID_TEAM_NAME",required = false)
	private String teamName;
}
