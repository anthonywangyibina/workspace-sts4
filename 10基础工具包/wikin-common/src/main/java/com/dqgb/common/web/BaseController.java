package com.dqgb.common.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dqgb.common.constant.CommonConst;
import com.dqgb.common.response.Response;
import com.dqgb.common.response.ResponseMsg;
import com.dqgb.common.utils.StringUtil;
import com.dqgb.common.vo.UserVo;

import net.sf.json.JSONObject;

@Controller
public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	private static ThreadLocal<ServletRequest> currentRequest = new ThreadLocal<ServletRequest>();
	private static ThreadLocal<ServletResponse> currentResponse = new ThreadLocal<ServletResponse>();

	@Value("${spring.application.name}")
	protected String appName;

	@Value("${system.code}")
	private String systemCode;

	@Value("${system.name}")
	private String systemName;

	/**
	 * @author wenzhang
	 * @date:2018年2月9日 上午11:07:35
	 * @Title:initReqAndRep
	 * @param request
	 * @param response
	 * @since JDK 1.8
	 */
	@ModelAttribute
	public void initReqAndRep(HttpServletRequest request, HttpServletResponse response) {
		currentRequest.set(request);
		currentResponse.set(response);
	}

	protected Response result(ResponseMsg msg) {
		return new Response(msg);
	}

	protected Response result() {
		return new Response();
	}

	/**
	 * 
	 * @Description:公共方法，获取request
	 *
	 * @author wenzhang
	 * @date:2018年2月9日 上午11:07:13
	 * @Title:request
	 * @return HttpServletRequest
	 * @since JDK 1.8
	 */
	public HttpServletRequest request() {
		return (HttpServletRequest) currentRequest.get();
	}

	/**
	 * 
	 * @Description:公共方法，获取response
	 *
	 * @author wenzhang
	 * @date:2018年2月9日 上午11:06:56
	 * @Title:response
	 * @return HttpServletResponse
	 * @since JDK 1.8
	 */
	public HttpServletResponse response() {
		return (HttpServletResponse) currentResponse.get();
	}

	protected String getUserIp() {
		String value = request().getHeader("x-forwarded-for");
		if (StringUtil.isNotBlank(value) && !"unknown".equalsIgnoreCase(value)) {
			return value;
		} else {
			return request().getRemoteAddr();
		}
	}

	protected String getUsername() {
		return request().getParameter("username");
	}
	/**
	 * 获取语言
	 * @return
	 */
	protected String getLanguage() {
		return  LocaleContextHolder.getLocale().getLanguage()+"_"+LocaleContextHolder.getLocale().getCountry();
	}
	
	protected UserVo getUser() {
		String json = request().getHeader("userVo");
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

	protected Map<String, String> getApplication() {
		try {
			Map<String, String> map = new HashMap<String, String>();
			String[] codeArr = systemCode.split(",");
			String[] nameArr = systemName.split(",");
			if (null != codeArr && codeArr.length > 0) {
				for (int i = 0; i < codeArr.length; i++) {
					/*
					 * byte[] t_iso; String ut_utf8=""; try { t_iso =
					 * nameArr[i].getBytes("ISO8859-1"); ut_utf8 = new
					 * String(t_iso, "UTF-8"); } catch
					 * (UnsupportedEncodingException e) { e.printStackTrace(); }
					 */
					map.put(codeArr[i], nameArr[i]);
				}
			}
			return map;
		} catch (Exception e) {
			return null;
		}
	}
}
