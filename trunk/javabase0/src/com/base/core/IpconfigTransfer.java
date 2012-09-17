package com.base.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ��־ǿ
 * ����windows�µ�ipconfig�����ȡ�����������ַ
 */
public class IpconfigTransfer {
	/**
	 * @return  �����ַ
	 */
	public static String getMACAddress() {
		String address = "";
		String os = System.getProperty("os.name");
		if (os != null && os.startsWith("Windows")) {
			try {
				String command = "cmd.exe /c ipconfig /all";
				//  ִ������
				Process p = Runtime.getRuntime().exec(command);
				BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line;
				while ((line = br.readLine()) != null) {
					if (line.indexOf("Physical Address") > 0) {
						int index = line.indexOf(":");
						index += 2;
						address = line.substring(index);
						break;
					}
				}
				br.close();
				return address.trim();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return address;
	}
	static public void main(String [] args)
	{
		//IpconfigTransfer it = new IpconfigTransfer();
		System.out.print(getMACAddress());
	}
}
