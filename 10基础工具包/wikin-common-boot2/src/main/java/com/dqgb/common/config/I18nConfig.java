package com.dqgb.common.config;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**  
* @描述 国际化配置类
* @文件名:I18nConfig.java
* @版权:Copyright 2018 版权所有：大庆金桥信息技术工程有限公司成都分公司
* @描述:I18nConfig.java
* @修改人:yangxi
* @修改时间:2019年4月29日 上午10:43:06
* @修改内容:新增
*/
@Configuration
public class I18nConfig extends WebMvcConfigurationSupport{
	
	/**
     * cookie区域解析器
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(HttpServletRequest request) {
    	Springboot2CookieLocaleResolver slr = new Springboot2CookieLocaleResolver();
        //设置默认区域,
       // slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        slr.setCookieName("language");  
        slr.setCookieMaxAge(Integer.MAX_VALUE);//设置cookie有效期.
        return slr;
    }
    
//    @Bean
//    public LocaleResolver localeResolver() {
//        final Springboot2LocaleResolver springboot2LocaleResolver = new Springboot2LocaleResolver();
//        return springboot2LocaleResolver;
//    }
    

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        // 设置请求地址的参数,默认为：locale
        lci.setParamName("lang");
        Locale locale = LocaleContextHolder.getLocale();
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

}
