package com.dqgb.common.config;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

public class Springboot2LocaleResolver implements LocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		 String l = request.getParameter("lang");
	        Locale locale = Locale.getDefault();
	        if (!StringUtils.isEmpty(l)) {
	            String[] strings = l.split("_|-");
	            locale = new Locale(strings[0], strings[1]);
	        }
	        return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		// TODO Auto-generated method stub
		
	}

}
