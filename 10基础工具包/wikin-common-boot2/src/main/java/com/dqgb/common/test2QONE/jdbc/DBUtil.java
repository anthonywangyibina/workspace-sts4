package com.dqgb.common.test2QONE.jdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import io.reactivex.netty.client.ConnectionPool;

/**
 * @描述 获取QONE的数据库连接
 * @文件名:DBUtil.java
 * @版权:Copyright 2018 版权所有：大庆金桥信息技术工程有限公司成都分公司
 * @描述:DBUtil.java
 * @修改人:技术部-文章
 * @修改时间:2018年8月6日 下午4:16:10
 * @修改内容:新增
 */
public class DBUtil {

	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;

	static {
		Properties props = new Properties();
		InputStream in = null;
		try {
			in = ConnectionPool.class.getClassLoader().getResourceAsStream("qone.properties");
			props.load(in);
			driver = props.getProperty("qone.driver").trim();
			url = props.getProperty("qone.url").trim();
			username = props.getProperty("qone.username").trim();
			password = props.getProperty("qone.password").trim();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void delConn(Connection conn) {
		try {
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
