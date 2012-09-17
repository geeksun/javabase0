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
	 * 根据传进的文件名载入文件
	 * @param fileName String
	 */

	public PropertiesUtil(String fileName) {
		this.fileName = fileName;
		File file = new File(fileName);
		try {
			in = new FileInputStream(file);
			p = new Properties();
			
			//载入文件
			p.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			System.err.println("配置文件config.properties找不到！！");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("读取配置文件config.properties错误！！");
			e.printStackTrace();
		}
	}

	/**
	 * 配置文件一律为config.propertities，并且统一放在web应用的根目录下。
	 * @return String
	 */

	public static String getConfigFile(HttpServlet hs) {
		return getConfigFile(hs, "config.properties");
	}

	/**
	 * 在servlet中使用,直接用this作为参数,HttpServlet类型
	 * 根据配置文件名从当前web应用的根目录下找出配置文件
	 * @param hs HttpServlet
	 * @param configFileName String配置文件名字
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
	 * jsp中用pageContext作参数
	 * @param hs PageContext
	 * @param configFileName String 配置文件名字
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
	 * 列出所有的配置文件内容
	 */

	public void list() {
		p.list(System.out);
	}

	/**
	 * 指定配置项名称，返回配置值
	 * @param itemName String
	 * @return String
	 */

	public String getValue(String itemName) {
		return p.getProperty(itemName);
	}

	/**
	 * 指定配置项名称和默认值，返回配置值
	 * @param itemName String
	 * @param defaultValue String
	 * @return String
	 */
	public String getValue(String itemName, String defaultValue) {
		return p.getProperty(itemName, defaultValue);
	}

	/**
	 * 设置配置项名称及其值
	 * @param itemName String
	 * @param value String
	 */
	public void setValue(String itemName, String value) {
		p.setProperty(itemName, value);
		return;
	}

	/**
	 * 保存配置文件，指定文件名和抬头描述
	 * @param fileName String
	 * @param description String
	 * @throws Exception
	 */
	public void saveFile(String fileName, String description) throws Exception {
		try {
			File f = new File(fileName);
			out = new FileOutputStream(f);
			p.store(out, description);//保存文件
			out.close();
		} catch (IOException ex) {
			throw new Exception("无法保存指定的配置文件:" + fileName);
		}
	}

	/**
	 * 保存配置文件，指定文件名
	 * @param fileName String
	 * @throws Exception
	 */
	public void saveFile(String fileName) throws Exception {
		saveFile(fileName, "");
	}

	/**
	 * 保存配置文件，采用原文件名
	 * @throws Exception
	 */
	public void saveFile() throws Exception {
		if (fileName.length() == 0)
			throw new Exception("需指定保存的配置文件名");
		saveFile(fileName);
	}

	/**
	 * 删除一个属性
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
