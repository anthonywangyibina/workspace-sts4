/**
 * @项目名:wikin-common
 * @文件名:IWikinNoticeService.java
 * @包名:com.dqgb.common.service
 * @描述 IWikinNoticeService.java
 * @修改人 wenzhang
 * @修改时间:2018年2月5日下午5:20:06
 * @修改内容:新增
 * @版权:Copyright 2009-2017 版权所有：大庆金桥信息技术工程有限公司
 *
*/

package com.dqgb.common.api.notice;

import com.dqgb.common.domain.Email;
import com.dqgb.common.domain.Message;
import com.dqgb.common.response.ResponseData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:IWikinNoticeService <br/>
 * Function: 公用通知中心路径方法. <br/>
 * Reason: 统一路径，调用公用. <br/>
 * Date: 2018年2月5日 下午5:20:06 <br/>
 * 
 * @author wenzhang
 * @version
 * @since JDK 1.8
 * @see
 */
@FeignClient("wikin-notice")
public interface IWikinNoticeService {

	/**
	 * @Description:发送邮件.
	 * @author wenzhang
	 * @date:2018年2月5日 下午5:23:05
	 * @Title:sendEmail
	 * @param email
	 <pre>
	<b>请求类型</b>：Content-Type:application/json
	<b>请求地址</b>：/wikin-notice/notice/emails
	<b>请求方式</b>: POST
	<b>请求案例</b>：
	{
	"title": "标题",	===>标题
	"subject": "主题",   ===>主题
	"content": "内容/正文",  ===>内容/正文
	"senderAccount": "13280066aa@qq.com", ===>发送人邮箱地址
	"senderName": "发送人姓名", ===>发送人姓名
	"receiverAccounts": "21127481rr@qq.com", ===>邮箱接收人地址
	"ccAccounts": "21127481cc@qq.com",  ====>邮件抄送人地址
	"attachUrl": ""  ===>附件的绝对地址
	}
	</pre>
	 * @return
	 <pre>
	<b>1.操作失败</b>
	{
	"rspCode": "999999",
	"rspMsg": "操作失败",
	"data": null
	}
	<b>2.非法参数</b>
	{
	"rspCode": "000001",
	"rspMsg": "非法的参数",
	"data": null
	}
	<b>3.操作成功</b>
	{
	"rspCode": "000000",
	"rspMsg": "发送邮件",
	"data": "8af2c8fe6cacdd0b016cefefbd3254d6"  ===>返回消息的Id
	}
	</pre>
	 * @since JDK 1.8
	 */
	@ResponseBody
	@RequestMapping(value = "/notice/emails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData sendEmail(@RequestBody Email email);
	
	/**
	 * 发送站内信、短信
	 * @Title sendMessage
	 * @author wenzhang
	 * @Description 发送站内信、短信
	 * @date 2018年6月7日 下午4:47:57
	 * @param message
	 <pre>
	<b>请求类型</b>：Content-Type:application/json
	<b>请求地址</b>：/wikin-notice/notice/messages
	<b>请求方式</b>: POST
	<b>请求案例</b>：
	{
	"sender":7e229eac689a4d4f8d9a39523fc72e80	===>"发送人/号码",
	"senderName":张三SS11111111111	===>"发送人姓名",
	"receiverName":四川石化-生产三部生产三部生产11-张三SS11111111111	===>"接收人姓名",
	"content":"内容"	===>"内容",
	"catagery":1	===>"类别：0短信,1站内(私信)",
	"readerAccounts":7e229eac689a4d4f8d9a39523fc72e80	===>"读者账号集合 多个读者用“,”分割",
	"readerRoles":0	===>"读者应具有的角色编码，发送给所有角色用0表示",
	"readerOrgs":0	===>"读者所属的部门的编码，发给所有的部门用0表示；角色、组织之间按顺序维护一一对应的关系",
	"type":1	===>"读者范围选择的类型：1指定的人2指定的部门3指定的角色4指定的角色和部门（交集）",
	}
	</pre>
	 * @return
	 <pre>
	<b>1.发送信息失败</b>
	{
	"rspCode": "999999",
	"rspMsg": "发送信息",
	"data": null
	}
	<b>2.发送信息成功</b>
	{
	"rspCode": "000000",
	"rspMsg": "发送信息",
	"data": "8af2c8fe6cacdd0b016cf00bc10954ef"   ===>返回消息的id
	}
	</pre>
	 */
	@ResponseBody
	@RequestMapping(value = "/notice/messages", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData sendMessage(@RequestBody Message message);
}
