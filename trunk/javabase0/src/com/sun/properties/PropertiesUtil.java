package com.sun.properties;

import java.io.*;
import java.util.Properties;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.jsp.*;

public class PropertiesUtil {

	private String fileName;
	private Properties p;
	private FileInputStream in;
	private FileOutputStream out;

	/**
	 * ���ݴ������ļ��������ļ�
	 * @param fileName String
	 */

	public PropertiesUtil(String fileName) {
		this.fileName = fileName;
		File file = new File(fileName);
		try {
			in = new FileInputStream(file);
			p = new Properties();
			
			//�����ļ�
			p.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			System.err.println("�����ļ�config.properties�Ҳ�������");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("��ȡ�����ļ�config.properties���󣡣�");
			e.printStackTrace();
		}
	}

	/**
	 * �����ļ�һ��Ϊconfig.propertities������ͳһ����webӦ�õĸ�Ŀ¼�¡�
	 * @return String
	 */

	public static String getConfigFile(HttpServlet hs) {
		return getConfigFile(hs, "config.properties");
	}

	/**
	 * ��servlet��ʹ��,ֱ����this��Ϊ����,HttpServlet����
	 * ���������ļ����ӵ�ǰwebӦ�õĸ�Ŀ¼���ҳ������ļ�
	 * @param hs HttpServlet
	 * @param configFileName String�����ļ�����
	 * @return String
	 */

	public static String getConfigFile(HttpServlet hs, String configFileName) {
		String configFile = "";
		ServletContext sc = hs.getServletContext();
		configFile = sc.getRealPath("/" + configFileName);
		if (configFile == null || configFile.equals("")) {
			configFile = "/" + configFileName;
		}
		return configFile;
	}

	/**
	 * jsp����pageContext������
	 * @param hs PageContext
	 * @param configFileName String �����ļ�����
	 * @return String
	 */

	public static String getConfigFile(PageContext hs, String configFileName) {
		String configFile = "";
		ServletContext sc = hs.getServletContext();
		configFile = sc.getRealPath("/" + configFileName);
		if (configFile == null || configFile.equals("")) {
			configFile = "/" + configFileName;
		}
		return configFile;
	}

	/**
	 * �г����е������ļ�����
	 */

	public void list() {
		p.list(System.out);
	}

	/**
	 * ָ�����������ƣ���������ֵ
	 * @param itemName String
	 * @return String
	 */

	public String getValue(String itemName) {
		return p.getProperty(itemName);
	}

	/**
	 * ָ�����������ƺ�Ĭ��ֵ����������ֵ
	 * @param itemName String
	 * @param defaultValue String
	 * @return String
	 */
	public String getValue(String itemName, String defaultValue) {
		return p.getProperty(itemName, defaultValue);
	}

	/**
	 * �������������Ƽ���ֵ
	 * @param itemName String
	 * @param value String
	 */
	public void setValue(String itemName, String value) {
		p.setProperty(itemName, value);
		return;
	}

	/**
	 * ���������ļ���ָ���ļ�����̧ͷ����
	 * @param fileName String
	 * @param description String
	 * @throws Exception
	 */
	public void saveFile(String fileName, String description) throws Exception {
		try {
			File f = new File(fileName);
			out = new FileOutputStream(f);
			p.store(out, description);//�����ļ�
			out.close();
		} catch (IOException ex) {
			throw new Exception("�޷�����ָ���������ļ�:" + fileName);
		}
	}

	/**
	 * ���������ļ���ָ���ļ���
	 * @param fileName String
	 * @throws Exception
	 */
	public void saveFile(String fileName) throws Exception {
		saveFile(fileName, "");
	}

	/**
	 * ���������ļ�������ԭ�ļ���
	 * @throws Exception
	 */
	public void saveFile() throws Exception {
		if (fileName.length() == 0)
			throw new Exception("��ָ������������ļ���");
		saveFile(fileName);
	}

	/**
	 * ɾ��һ������
	 * @param value String
	 */
	public void deleteValue(String value) {
		p.remove(value);
	}

	/**
	 * main method for test
	 * @param args String[]
	 */
	public static void main(String[] args) {
		String file = "f:\\p.properties";
		PropertiesUtil pu = new PropertiesUtil(file);
		pu.list();
	}
}
