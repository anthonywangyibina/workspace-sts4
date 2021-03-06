/**  
* @文件名 Const.java
* @版权 Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
* @描述 系统常量
* @修改人 Mr.Wang
* @修改时间 2017年5月11日 下午2:47:12
* @修改内容 新增
*/
package com.dqgb.common.constant;

import org.springframework.stereotype.Component;

/**
 * 系统常量
 * 
 * @author Mr.Wang
 * @version V1.0,2017年5月11日 下午2:47:12
 * @see [相关类/方法]
 * @since V1.0
 * 
 */
@Component
public class CommonConst {

	/**
	 * cookie中存令牌的KEY
	 */
	public static final String COOKIE_KEY_JWT_TOKEN = "jwtToken";

	/**
	 * cookie中存租户标识
	 */
	public static final String COOKIE_KEY_TENANT = "tenantCookie";
	
	/**
	 * cookie中存放语言
	 */
	public static final String COOKIE_KEY_LANGUAGE = "language";

	/**
	 * swagger path
	 */
	public static final String SWAGGER_PATH = "/v2/api-docs";

	/**
	 * 项目路径
	 */
	public static String BASE_PATH;

	/**
	 * 计数 ClassName: INT_NUMBER <br/>
	 * Function: 内部类，数字类型计数 <br/>
	 * date: 2018年2月11日 上午10:37:10 <br/>
	 *
	 * @author wenzhang
	 * @version Const
	 * @see [相关类/方法]
	 * @Description:
	 * @since JDK 1.8
	 */
	public static final class INT_NUMBER {
		/**
		 * 0
		 */
		public static final int _ZERO = 0;
		/**
		 * 1
		 */
		public static final int _ONE = 1;
		/**
		 * 2
		 */
		public static final int _TWO = 2;
		/**
		 * 3
		 */
		public static final int _THREE = 3;
		/**
		 * 4
		 */
		public static final int _FOUR = 4;
		/**
		 * 5
		 */
		public static final int _FIVE = 5;
		/**
		 * 6
		 */
		public static final int _SIX = 6;
		/**
		 * 7
		 */
		public static final int _SEVEN = 7;
		/**
		 * 8
		 */
		public static final int _EIGHT = 8;
		/**
		 * 9
		 */
		public static final int _NINE = 9;
		/**
		 * 10
		 */
		public static final int _TEN = 10;
	}

	/**
	 * 
	 * ClassName: STRING_NUMBER <br/>
	 * Function: 内部类，字符串类型计数. <br/>
	 * date: 2018年2月11日 上午10:38:45 <br/>
	 *
	 * @author wenzhang
	 * @version Const
	 * @see [相关类/方法]
	 * @Description:
	 * @since JDK 1.8
	 */
	public static final class STRING_NUMBER {
		/**
		 * 0
		 */
		public static final String _ZERO = "0";
		/**
		 * 1
		 */
		public static final String _ONE = "1";
		/**
		 * 2
		 */
		public static final String _TWO = "2";
		/**
		 * 3
		 */
		public static final String _THREE = "3";
		/**
		 * 4
		 */
		public static final String _FOUR = "4";
		/**
		 * 5
		 */
		public static final String _FIVE = "5";
		/**
		 * 6
		 */
		public static final String _SIX = "6";
		/**
		 * 7
		 */
		public static final String _SEVEN = "7";
		/**
		 * 8
		 */
		public static final String _EIGHT = "8";
		/**
		 * 9
		 */
		public static final String _NINE = "9";
		/**
		 * 10
		 */
		public static final String _TEN = "10";
	}

	/**
	 * 
	 * ClassName: WEEK <br/>
	 * Function: 内部类 ，星期计数<br/>
	 * date: 2018年2月11日 上午10:40:02 <br/>
	 *
	 * @author wenzhang
	 * @version Const
	 * @see [相关类/方法]
	 * @Description:
	 * @since JDK 1.8
	 */
	public static final class WEEK {
		/**
		 * 周日
		 */
		public static final String _SUNDAY = "SUNDAY";
		/**
		 * 周一
		 */
		public static final String _MONDAY = "MONDAY";
		/**
		 * 周二
		 */
		public static final String _TUESDAY = "TUESDAY";
		/**
		 * 周三
		 */
		public static final String _WEDNESDAY = "WEDNESDAY";
		/**
		 * 周四
		 */
		public static final String _THURSDAY = "THURSDAY";
		/**
		 * 周五
		 */
		public static final String _FRIDAY = "FRIDAY";
		/**
		 * 周六
		 */
		public static final String _SATURDAY = "SATURDAY";
	}

	/**
	 * 
	 * ClassName: RESPONSE_MSG <br/>
	 * Function: 内部类.数据使用情况 <br/>
	 * date: 2018年2月11日 上午10:41:59 <br/>
	 *
	 * @author wenzhang
	 * @version Const
	 * @see [相关类/方法]
	 * @Description:
	 * @since JDK 1.8
	 */
	public static class RESPONSE_MSG {
		/**
		 * 
		 * ClassName: SUCESS_NOTICE <br/>
		 * date: 2018年2月11日 上午10:42:24 <br/>
		 *
		 * @author wenzhang
		 * @version Const.RESPONSE_MSG
		 * @see [相关类/方法]
		 * @Description:
		 * @since JDK 1.8
		 */
		public static class SUCESS_NOTICE {
			/**
			 * 
			 */
			public static final String _OBJ_AVAILABLE = "可以使用";
			/**
			 * 
			 */
			public static final String _NUMOF_BEEN_DELETED = "条数据已被删除";
		}
	}

	/**
	 * 
	 * ClassName: OPERATION <br/>
	 * Function: 内部类，成功代码. <br/>
	 * date: 2018年2月11日 上午10:42:39 <br/>
	 *
	 * @author wenzhang
	 * @version Const
	 * @see [相关类/方法]
	 * @Description:
	 * @since JDK 1.8
	 */
	public static class OPERATION {
		/**
		 * 成功
		 */
		public static final String _SUCCESSFUL = "Successful ";
		/**
		 * 失败
		 */
		public static final String _FAILED = "Failed ";
	}

	/**
	 * 
	 * ClassName: LOG_TYPE <br/>
	 * Function: 内部类，日志类型. <br/>
	 * date: 2018年2月11日 上午10:43:14 <br/>
	 *
	 * @author wenzhang
	 * @version Const
	 * @see [相关类/方法]
	 * @Description:
	 * @since JDK 1.8
	 */
	public static final class LOG_TYPE {
		/**
		 * 
		 * ClassName: _SERVICE <br/>
		 * date: 2018年2月11日 上午10:43:27 <br/>
		 *
		 * @author wenzhang
		 * @version Const.LOG_TYPE
		 * @see [相关类/方法]
		 * @Description:
		 * @since JDK 1.8
		 */
		public static final class _SERVICE {
			/**
			 * 添加日志
			 */
			public static final String _ADD = "Service Log(ADD) ";
			/**
			 * 删除日志
			 */
			public static final String _DELETE = "Service Log(DELETE) ";
			/**
			 * 修改日志
			 */
			public static final String _MODIFY = "Service Log(MODIFY) ";
			/**
			 * 查询日志
			 */
			public static final String _SEARCH = "Service Log(SEARCH) ";
		}

		/**
		 * 
		 * ClassName: _RUNTIME <br/>
		 * date: 2018年2月11日 上午10:44:06 <br/>
		 *
		 * @author wenzhang
		 * @version Const.LOG_TYPE
		 * @see [相关类/方法]
		 * @Description:
		 * @since JDK 1.8
		 */
		public static final class _RUNTIME {
			/**
			 * 错误日志
			 */
			public static final String _Error = "Runtime Log(Error) ";
		}
	}
	/**
	 * 资源类型
	 * @author yangmaoli
	 * @version V1.0,2018年2月9日 上午9:03:29
	 * @see [相关类/方法]
	 * @since V1.0
	 * 
	*/ 
	public static final class RESOURCE_TYPE{
		//应用
		public static final String APPLICATION ="01";
		//模块
		public static final  String MODULE = "02";
		//菜单
		public static final String MENU = "03";
		//api
		public static final String API = "04";
		//按钮
		public static final String BUTTON = "05";
	}
	/**
	 * 登录方式常量
	 * @author zhangzy
	 * @version V1.0,2019年4月17日 下午3:03:11
	 * @see [相关类/方法]
	 * @since V1.0
	 *
	 */
	public  static  final class LoginType{
		public static final String DEFAULT ="00";//默认登录方式
		public static final String SSO="01";//单点登录
		public static final String MAPPED="02";//登录映射
		public static final String IDENTY="03";//"windows域认证
		public static final String OTHER="04";//其他方式
		
	}
	 
	public static final class INTERNATION{
		//中文
		public static final String _CHINESE = "zh_CN";
		//英文
		public static final String _ENGLISH = "en_US";
	}
}
