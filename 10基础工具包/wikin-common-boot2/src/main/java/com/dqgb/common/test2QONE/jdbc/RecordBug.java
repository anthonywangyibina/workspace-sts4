package com.dqgb.common.test2QONE.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dqgb.common.test2QONE.ErrorTestInformation;

/**
 * @描述
 * @文件名:RecordBug.java
 * @版权:Copyright 2018 版权所有：大庆金桥信息技术工程有限公司成都分公司
 * @描述:RecordBug.java
 * @修改人:技术部-文章
 * @修改时间:2018年8月6日 下午4:33:02
 * @修改内容:新增
 */
public class RecordBug {

	/**
	 * 
	 * @Title addTestBug
	 * @author :技术部-文章
	 * @Description 调用存储过程，将出错的单元测试提交至qone
	 * @date 2018年8月7日 上午9:00:22
	 * @param informations
	 *            报错的单元测试信息
	 */
	public static void addTestBug(List<ErrorTestInformation> informations) {
		Connection conn = null;
		CallableStatement cstm = null;
		try {
			conn = DBUtil.getConn();
			String sql = "{CALL addbug(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			cstm = conn.prepareCall(sql);
			for (ErrorTestInformation error : informations) {
				cstm.setString(1, error.getContent());// 方法内容
				cstm.setString(2, error.getEnviroment());// 环境
				cstm.setInt(3, error.getUser());// 方法编写人id
				cstm.setInt(4, error.getJobId());// 任务id
				cstm.setInt(5, error.getBugLevel());// bug级别
				cstm.setInt(6, error.getPriority());// 优先级
				cstm.setInt(7, error.getSeverity());// 严重程度
				cstm.setInt(8, error.getStage());// 检出阶段
				cstm.setString(9, error.getAdditionalInformation());// 附加信息
				cstm.setInt(10, error.getModulesId());// 模板id
				cstm.setString(11, error.getOperateStep());// 操作步骤
				cstm.setInt(12, error.getQualityReportId());// 质量报告id
				cstm.setString(13, error.getTitle());// 标题
				// 执行存储过程
				cstm.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.delConn(conn);
			try {
				if (null != cstm) {
					cstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
