package com.dqgb.common.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.dqgb.common.service.IBaseService;
import com.dqgb.common.utils.StringUtil;
import com.dqgb.common.vo.UserVo;
import net.sf.json.JSONObject;

/**
 * redis操作实现类
 * 
 * @author lzc
 * @version V1.0,2017年6月14日 下午3:22:20
 * @see [相关类/方法]
 * @since V1.0
 *
 */
@Component
@Service
public class BaseServiceImpl implements IBaseService {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;

	/*
	 * @Autowired private IWikinDatacenterService dataCenterService;
	 */

	@Override
	public String getUserIp() {
		String value = request.getHeader("X-Real-IP");
		if (StringUtil.isNotBlank(value) && !"unknown".equalsIgnoreCase(value)) {
			return value;
		} else {
			return request.getRemoteAddr();
		}
	}

	@Override
	public UserVo getUser() {
		String json = request.getHeader("userVo");
		if (StringUtil.isBlank(json)) {
			return null;
		}
		try {
			json = URLDecoder.decode(json, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		}

		JSONObject jsonObject = JSONObject.fromObject(json);
		UserVo user = (UserVo) JSONObject.toBean(jsonObject, UserVo.class);
		return user;
	}

	/**
	 * 获取当前环境语言
	 * @Title getLanguage
	 * @author :yangxi
	 * @Description 
	 * @date 2020年3月30日 下午3:53:23
	 * @return
	 */
	@Override
	public String getLanguage() {
		return  LocaleContextHolder.getLocale().getLanguage()+"_"+LocaleContextHolder.getLocale().getCountry();
	}
	

}
