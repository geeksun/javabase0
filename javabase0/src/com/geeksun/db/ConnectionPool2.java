package com.geeksun.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import java.util.Stack;

/**
 * ���������Ϣ:����Ϊһ�����ݿ����ӳ��࣬��һ����̬���࣬���ж����ݿ����ӵ���Ϣ
 * ������һ�������ļ��У����Խ��з��������***
 * ����޸�ʱ��:2006-1-12 10:30*********
 * @author �����http://blog.pfan.cn/ggbm/14768.html
 */
public class ConnectionPool2 {
	private int minConn; //����������
	private int maxConn; //���������
	private String user; //�û���
	private String password; //���ݿ�����
	private int connAmount; //�������Ӹ���
	private Stack connStack; //ʹ��Stack�������ݿ�����
	private String dry; //����
	private String connString; //�����ַ���   
	private static ConnectionPool2 connectionPool;
	private int waitTime; //æʱ�ĵȸ��ʱ��
	static ResourceBundle bundle = null; //�����ļ���ȡ

	/**
	 *����һ��ʵ��������ǵ�һ�ε��ô˷��������һ��ʵ��
	 */
	public static synchronized ConnectionPool2 getInstance() {
		if (connectionPool == null) {
			connectionPool = new ConnectionPool2();
		}
		return connectionPool;
	}

	/**
	 *�������ļ��õ����ݿ�������Ϣ�����ӳ���Ϣ
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
		System.out.println("��ʼ���ɹ�..........");

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
	 *�����ӳصõ�����
	 */
	public synchronized Connection getConnection() {
		Connection conn = null;
		System.out.println("user connection:" + this.connStack.size());
		if (!this.connStack.empty()) {
			conn = (Connection) connStack.pop();
			System.out.println("�õ�һ������");
		} else if (this.connAmount < this.maxConn) {
			conn = newConnection();
		} else {
			try {
				wait(this.waitTime);
				System.out.println("�ȴ�");
				return getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	/**
	 /*�ͷ�����
	 */
	public synchronized void freeConnection(Connection con) {
		this.connStack.push(con);
		System.out.println("�黹����");
		notifyAll();
	}

	/**
	 *����������
	 */
	public Connection newConnection() {
		Connection conn = null;
		try {

			conn = DriverManager.getConnection(this.connString, this.user,
					this.password);
			this.connAmount++;
			System.out.println("���ӳش���һ������" + conn.toString());
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
