package com.dqgb.common.autolayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dqgb.common.service.IBpmBusinessCallbackService;

/**
 * 
 * 自动配置类
 * @author yangxi
 * @version V1.0,2018年12月29日 上午8:46:38
 * @see [相关类/方法]
 * @since V1.0
 *
 */
@Configuration
@ConditionalOnClass(IBpmBusinessCallbackService.class)
public class IBpmBusinessCallbackServiceAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(IBpmBusinessCallbackService.class)
    public IBpmBusinessCallbackService bpmcallbackService() {
    	IBpmBusinessCallbackService ibpmBusinessCallbackService = new IBpmBusinessCallbackService(){};
        return ibpmBusinessCallbackService;
    }
}
