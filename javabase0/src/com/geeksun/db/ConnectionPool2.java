package com.geeksun.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import java.util.Stack;

/**
 * 类的描述信息:此类为一个数据库连接池类，是一个单态的类，其中对数据库连接的信息
 * 都放在一个属性文件中，可以进行方便的设置***
 * 最后修改时间:2006-1-12 10:30*********
 * @author 李国庆http://blog.pfan.cn/ggbm/14768.html
 */
public class ConnectionPool2 {
	private int minConn; //最少连接数
	private int maxConn; //最大连接数
	private String user; //用户名
	private String password; //数据库密码
	private int connAmount; //现有连接个数
	private Stack connStack; //使用Stack保存数据库连接
	private String dry; //驱动
	private String connString; //连接字符串   
	private static ConnectionPool2 connectionPool;
	private int waitTime; //忙时的等告待时间
	static ResourceBundle bundle = null; //属性文件读取

	/**
	 *返回一个实例。如果是第一次调用此方法则个建一个实例
	 */
	public static synchronized ConnectionPool2 getInstance() {
		if (connectionPool == null) {
			connectionPool = new ConnectionPool2();
		}
		return connectionPool;
	}

	/**
	 *读属性文件得到数据库连接信息及连接池信息
	 */
	public void readProperties() {

		try {
			bundle = ResourceBundle.getBundle("properties.mypool");
			this.user = bundle.getString("user");
			this.password = bundle.getString("password");
			this.connString = bundle.getString("connString");
			this.dry = bundle.getString("dry");

			this.minConn = Integer.parseInt(bundle.getString("minConn"));
			System.out.println("this  mincon:" + this.minConn);
			this.maxConn = Integer.parseInt(bundle.getString("maxConn"));
			this.waitTime = Integer.parseInt(bundle.getString("waitTime"));

		} catch (Exception w) {
			w.toString();
		}
		System.out.println("初始化成功..........");

	}

	private ConnectionPool2() {
		readProperties();
		this.connStack = new Stack();
		System.out.println(this.dry);
		try {
			Class.forName(this.dry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < this.minConn; i++) {
			System.out.println("myPool:" + i);
			connStack.push(newConnection());
		}
	}

	/**
	 *从连接池得到连接
	 */
	public synchronized Connection getConnection() {
		Connection conn = null;
		System.out.println("user connection:" + this.connStack.size());
		if (!this.connStack.empty()) {
			conn = (Connection) connStack.pop();
			System.out.println("得到一个连接");
		} else if (this.connAmount < this.maxConn) {
			conn = newConnection();
		} else {
			try {
				wait(this.waitTime);
				System.out.println("等待");
				return getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	/**
	 /*释放连接
	 */
	public synchronized void freeConnection(Connection con) {
		this.connStack.push(con);
		System.out.println("归还连接");
		notifyAll();
	}

	/**
	 *创建新连接
	 */
	public Connection newConnection() {
		Connection conn = null;
		try {

			conn = DriverManager.getConnection(this.connString, this.user,
					this.password);
			this.connAmount++;
			System.out.println("连接池创建一个连接" + conn.toString());
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
