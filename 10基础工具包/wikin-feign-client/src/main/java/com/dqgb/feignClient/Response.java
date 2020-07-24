//package com.dqgb.feignClient;
//import java.util.Collection;
//
//import org.apache.commons.lang3.ArrayUtils;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.StringUtils;
//
//import com.dqgb.feignClient.constant.Const.ResponseMsg;
//
//import lombok.Data;
//
///**
// * 响应实体
// *@className Response
// *@author :技术部-zhangjs
// *@Description  
// *@date 2019年9月26日 下午9:18:15
// */
//@Data
//public class Response<T> {
//	/**
//	 * 返回的数据
//	 */
//	private T data;
//	/**
//	 * 返回编码
//	 */
//	private String rspCode = "000000";
//	/**
//	 * 返回信息
//	 */
//	private String rspMsg = "操作成功";
//
//
//	public Response(ResponseMsg msg) {
//		this.rspCode = msg.getCode();
//		this.rspMsg = msg.getMsg();
//	}
//
//	public Response(String rspCode) {
//		this.rspCode = rspCode;
//		this.rspMsg = "";
//	}
//
//	public Response(String rspCode, String rspMsg) {
//		this.rspCode = rspCode;
//		this.rspMsg = rspMsg;
//	}
//	public Response() {
//	}
//
//	public Response(T data) {
//		this.data = data;
//	}
//
//
//
//	public Response(String rspCode, String rspMsg, T data) {
//		this.rspCode=rspCode;
//		this.rspMsg=rspMsg;
//		this.data = data;
//	}
//
//	public Response(ResponseMsg msg, T data) {
//		this.rspCode=msg.getCode();
//		this.rspMsg=msg.getMsg();
//		this.data = data;
//	}
//	public boolean isSuccess(){
//		return ResponseMsg.SUCCESS.getCode().equals(rspCode);
//	}
//	public boolean isEmpty(){
//		if (isSuccess()){
//			if (data instanceof Collection){
//				return CollectionUtils.isEmpty((Collection<?>) data);
//			}
//			if (data instanceof String){
//				return StringUtils.isEmpty(data);
//			}
//			if (data.getClass().isArray()){
//				return ArrayUtils.isEmpty((boolean[]) data);
//			}
//			if (data instanceof Page){
//				@SuppressWarnings("unchecked")
//				Page<Object> page= (Page<Object>) data;
//				return page.isEmplty();
//			}
//			return data==null;
//		}
//		return false;
//	}
//	public boolean isNotEmpty(){
//		return !isEmpty();
//	}
//}
