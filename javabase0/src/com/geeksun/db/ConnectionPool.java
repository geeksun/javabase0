package com.geeksun.db;

import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接池
 * @author 姜志强
 * 2010-9-19
 */
public class ConnectionPool {
	private static int minPoolSize;	// 最小连接数
	private static int maxPoolSize;	// 最大连接数
	private static int inUseSize;	// 正在使用的连接数
	private static Vector<Connection> pool;  // 连接容器，考虑到线程的安全性，也可以用Stack
	
	/**
	 *  初始化
	 */
	static void init() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");	 // 以MySql为例
		pool = new Vector();
		minPoolSize = 3;
		for(int i=0;i<minPoolSize;i++){
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?useUnicode=true&amp;characterEncoding=gbk",
					"root", "");
			pool.add(con);
		}
	}

	/**
	 * @return 
	 * @return 有效的数据库连接
	 * @throws Exception 
	 */
	public static synchronized Connection getPoolConnection() throws Exception{
		Connection con = null;
		if(pool!=null&&pool.size()>0){
			con = pool.get(0);
			pool.remove(0);
			if(con==null){
				con = getPoolConnection();
			}
		}else{
			if(maxPoolSize<inUseSize){	// 超过最大连接数，不再新建连接
				con = null;
			}else{
				con = newConnection();
				inUseSize++;
			}
		}
		
		return con;
	}
	
	/**
	 *  创建新连接
	 * @throws Exception 
	 */
	private static Connection newConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?useUnicode=true&amp;characterEncoding=gbk",
				"root", "");
		return con;
	}
	
	/**
	 *  释放连接
	 */
	private static void freeConnction(Connection con) {
		pool.add(con);		// 添加到空闲连接的末尾
		inUseSize++;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
