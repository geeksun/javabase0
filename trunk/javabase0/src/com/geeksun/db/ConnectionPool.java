package com.geeksun.db;

import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ����ӳ�
 * @author ��־ǿ
 * 2010-9-19
 */
public class ConnectionPool {
	private static int minPoolSize;	// ��С������
	private static int maxPoolSize;	// ���������
	private static int inUseSize;	// ����ʹ�õ�������
	private static Vector<Connection> pool;  // �������������ǵ��̵߳İ�ȫ�ԣ�Ҳ������Stack
	
	/**
	 *  ��ʼ��
	 */
	static void init() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");	 // ��MySqlΪ��
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
	 * @return ��Ч�����ݿ�����
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
			if(maxPoolSize<inUseSize){	// ��������������������½�����
				con = null;
			}else{
				con = newConnection();
				inUseSize++;
			}
		}
		
		return con;
	}
	
	/**
	 *  ����������
	 * @throws Exception 
	 */
	private static Connection newConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?useUnicode=true&amp;characterEncoding=gbk",
				"root", "");
		return con;
	}
	
	/**
	 *  �ͷ�����
	 */
	private static void freeConnction(Connection con) {
		pool.add(con);		// ��ӵ��������ӵ�ĩβ
		inUseSize++;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
