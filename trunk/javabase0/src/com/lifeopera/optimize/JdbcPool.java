package com.lifeopera.optimize;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

/**
 * @author ��־ǿ
 *  ����أ�������󣬿������Ӧ�õ��ٶȣ������ڴ���Ҫ������Ϊ JDBC ���ӳ�.
 *  ����ϵͳ���ܣ���Լϵͳ�ڴ濪����ͨ���������������Ĺ�������ã�������Ӧ���̷߳����ؽ���װ�ض���Ĺ�������Ҫ��ʱ�䣬
 *  ����Ҳ��Ч������Ƶ���������մ����ľ޴�ϵͳ������
 *  
 *  ����ؾ����ԡ��ռ任ʱ�䡱�� һ�ֳ��û������, ����ġ�ʱ�䡱��ָ����ʱ��,�����Ҳ�����˶���ص����÷�Χ:
 *  ���һ�ֶ���Ĵ������̷ǳ���ʱ�Ļ�, ��ô��ʹ�ö����. �ڲ�ԭ��򵥵�˵, ���ǽ������Ķ���ŵ�һ��������, 
 *  ����֮�������ٶ����ٷŻظ�����, �������Ķ������, ������л��漰��һЩ�߼��ļ���, �����������, ���ƻ�ʱ����, 
 *  �����������ش�С����, �������û�п��ÿ��ж���ʱ�ȴ��ȵ�.
 *  2009-5-1
 */
public class JdbcPool extends ObjectPool{
	// ������δ����
	private Hashtable locked, unlocked;
	// ���ڴ�Ŷ���ĳ�
	private List<Connection> pool;
	// ����ʱ��
	private long expirationTime;
	// �����Ч������߳�
	ConnectionCleanUpThread cleaner;
	
	public JdbcPool(){
		unlocked = new Hashtable();
		//��ʼ�������
		//pool = new Vector<Connection>(); 
		
		//������Ч���Ӷ�����̣߳��ڶ���صĹ������б���ʼ��������
		cleaner = new ConnectionCleanUpThread(this, expirationTime);
		cleaner.start();
	}
	
	/* 
	 *  ��������
	 */
	Connection create(){
		try {
			/*return (DriverManager.getConnection(String url, String usr, String pwd));*/
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/abbcc?useUnicode=true&amp;characterEncoding=gbk",
					"root",
					""
			);
			//������ʵ�����浽��ϣ������ Vector ��
			unlocked.put(conn, conn);
			//pool.add(conn);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* 
	 * �������
	 */
	void expire(Object o){
		
	}
	
	/* 
	 * ������Ч����֤
	 */
	void validate(Object o){
		
	}
	
	/* 
	 * ��ȡ����
	 */
	synchronized Connection getObject(){
		try{
			return (Connection) super.getObject();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null; 
	}
	
	/* 
	 * �����ͷ�
	 */
	synchronized void freeObject(Object o){
		o = null;
	}
	
	/**
	 * @return ��ȡ���ݿ�����
	 */
	public Connection getConnection(){
		try{
			return (Connection) super.getObject();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null; 
	}
	
	public static void main(String[] args) {
		JdbcPool pool = new JdbcPool();
		long currentTime = System.currentTimeMillis();
		Connection conn = pool.create();
		Enumeration emumeration = pool.unlocked.keys();
		while(emumeration.hasMoreElements()){
			Connection con = (Connection) emumeration.nextElement();
			System.out.println(con);
			System.out.println(pool.unlocked.get(con));
			System.out.println(currentTime-((Long)pool.unlocked.get(con)).longValue());
			/*if((currentTime-((Long) unlocked.get(con)).longValue())>expirationTime){
				unlocked.remove(conn);
				expire(conn);
				//�ͷŶԸö��������
				conn = null;
			}*/
		}
		
	}
	

	/**
	 * @author ��־ǿ
	 *  ��һ���߳�����������ӳ��е��������Ӷ���
	 */
	class ConnectionCleanUpThread extends Thread {
		private ObjectPool pool;
		private long sleepTime;
		
		ConnectionCleanUpThread(ObjectPool pool, long sleepTime){
			this.pool = pool;
			this.sleepTime = sleepTime;
		}
		
		public void run(){
			while(true){
				try{
					sleep(sleepTime);
				}catch(Exception e){
					e.printStackTrace();
				}
				pool.cleanUp();
			}
		}
		
		/**
		 *  
		 */
		synchronized void cleanUp(){
			Connection conn;
			long currentTime = System.currentTimeMillis();
			Enumeration emumeration = unlocked.keys();
			
			while(emumeration.hasMoreElements()){
				conn = (Connection) emumeration.nextElement();
				
				if((currentTime-((Long) unlocked.get(conn)).longValue())>expirationTime){
					unlocked.remove(conn);
					expire(conn);
					//�ͷŶԸö��������
					conn = null;
				}
			}
			//ǿ��ϵͳ����������
			System.gc();
		}
		
	}

}

