package com.dqgb.common.service;

import com.dqgb.common.vo.UserVo;

/**
 * 
 * ClassName: IBaseService <br/>
 * Function: 公用项目服务层 <br/>
 * date: 2018年2月11日 上午10:53:31 <br/>
 *
 * @author wenzhang
 * @version
 * @see [相关类/方法]
 * @Description:
 * @since JDK 1.8
 */
public interface IBaseService {

	/**
	 * 
	 * @Description:获取user对象
	 *
	 * @author wenzhang
	 * @date:2018年2月11日 上午10:53:21
	 * @Title:getUser
	 * @return
	 * @since JDK 1.8
	 */
	UserVo getUser();

	/**
	 * 
	 * @Description:获取当前客户端ip
	 *
	 * @author wenzhang
	 * @date:2018年2月11日 上午10:53:45
	 * @Title:getUserIp
	 * @return
	 * @since JDK 1.8
	 */
	String getUserIp();
	/**
	 * 获取语言
	 * @return
	 */
	String getLanguage();

}
