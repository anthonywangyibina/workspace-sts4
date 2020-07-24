package com.dqgb.feignClient.serviceFeign;

import com.dqgb.common.domain.Email;
import com.dqgb.common.domain.Message;
import com.dqgb.common.response.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * wikin-notice原始接口
 *
 * @author :技术部-zhangjs
 * @className IWikinNoticeFeign
 * @Description
 * @date 2019年9月26日 下午11:11:00
 */
@FeignClient("wikin-notice")
public interface IWikinNoticeFeign {
    /**
     * 发送邮件信息
     *
     * @param email 邮件实体
     * @return ResponseData
     */
    @RequestMapping(value = "/notice/emails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseStatus
    ResponseData sendEmail(@RequestBody Email email);

    /**
     * 发送信息
     *
     * @param notice 通知实体
     * @return Response<String>
     * @Title sendMessage
     * @author :技术部-zhangjs
     * @Description
     */
    @RequestMapping(value = "/notice/messages", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    ResponseData sendMessage(@RequestBody Message  message);

    /**
     * 根据模板查询消息
     *
     * @param message 消息实体
     * @author :技术部-zhangjs
     */
    @RequestMapping(value = "/notice/messages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    ResponseData findNotice(@ModelAttribute  Message message, 
    		@RequestParam(value = "page",required = false) Integer page,
			@RequestParam(value = "size",required = false) Integer size,
			@RequestParam(value = "properties",required = false) String properties);
}
