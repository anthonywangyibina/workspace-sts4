package com.dqgb.common.config;

import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dqgb.common.constant.CommonConst;
import com.dqgb.common.utils.CookieUtil;
import com.dqgb.common.utils.StringUtil;

/**  
* @描述 国际化文件配置文件工具类
* @文件名:LocaleMessageSourceUtil.java
* @版权:Copyright 2018 版权所有：大庆金桥信息技术工程有限公司成都分公司
* @描述:LocaleMessageSourceUtil.java
* @修改人:yangxi
* @修改时间:2019年4月29日 上午10:49:09
* @修改内容:新增
*/
@Component
public class LocaleMessageSourceUtil {
		
		private static String basename="i18n/messages";
	
		private static long cacheMillis=-1L;
	
		private static String encoding="UTF-8";
	    private static  MessageSource messageSource;
	    
		private  final Logger LOGGER = LoggerFactory
				.getLogger(LocaleMessageSourceUtil.class);
	    public static String getMessage(String code) {
	        return getMessage(code, null);
	    }

	    /**
	     *
	     * @param code ：对应messages配置的key.
	     * @param args : 数组参数.
	     * @return
	     */
	    public static  String getMessage(String code, Object[] args){
	        return getMessage(code, args, "");
	    }

	    /**
	     *
	     * @param code ：对应messages配置的key.
	     * @param args : 数组参数.
	     * @param defaultMessage : 没有设置key的时候的默认值.
	     * @return
	     */
	    public static  String getMessage(String code,Object[] args,String defaultMessage){
	        //这里使用比较方便的方法，不依赖request.
	    	if(messageSource==null){
				messageSource=initMessageSource();
			}
	        Locale locale = LocaleContextHolder.getLocale();
	        return messageSource.getMessage(code, args, defaultMessage, locale);
	    }
	    
	    
	    private static MessageSource initMessageSource() { 
			ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
			messageSource.setBasename(basename); 
			messageSource.setDefaultEncoding(encoding); 
			messageSource.setCacheMillis(cacheMillis);
			return messageSource; 
		}
//	    @Value("${spring.messages.basename}") 
//		public  void setBasename(String basename) {
//			LocaleMessageSourceUtil.basename = basename;
//		}
//	    @Value("${spring.messages.cache-seconds}") 
//		public  void setCacheMillis(long cacheMillis) {
//			LocaleMessageSourceUtil.cacheMillis = cacheMillis;
//		}
//	    @Value("${spring.messages.encoding}")  
//	    
//		public  void setEncoding(String encoding) {
//			LocaleMessageSourceUtil.encoding = encoding;
//		}
	    
}
