package com.base.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ��־ǿ 
 * ʹ���Զ��建���������I/0����Ч�� �� 649K�ļ���ȡ���� 2187:31
 * 2009-5-9
 */
public class ReadWriteWithArray {
	
	/**
	 * @param fileFrom
	 * @param fileTo
	 *            ֱ��ͨ���ļ������������ȡ��д���ļ�
	 * @throws IOException
	 */
	public static void readWrite(String fileFrom, String fileTo)
			throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(fileFrom);
			out = new FileOutputStream(fileTo);
			while (true) {
				//һ�ζ�ȡһ���ֽ�
				int byteData = in.read();
				if (byteData == -1) {
					break;
				}
				out.write(byteData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

	/**
	 * @param fileFrom
	 * @param fileTo
	 * @throws IOException
	 * ͨ���Զ��建�������ȡ��д���ļ�
	 */
	public static void readWriteArray(String fileFrom, String fileTo)
			throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(fileFrom);
			out = new FileOutputStream(fileTo);
			int availableLength = in.available();
			
			byte[] totalBytes = new byte[availableLength];
			
			//һ�����ֻ�ܶ�ȡ 1k ����, 1024 byte
			int byteData = in.read(totalBytes);
			
			//totalBytes ����� 512 �ı���, ���������ٶȿ�һЩ
			out.write(totalBytes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

	public static void main(String[] args) {
		ReadWriteWithArray rw = new ReadWriteWithArray();
		try {
			long startTime = System.currentTimeMillis();
			rw.readWrite("e://test.txt", "e://test.err");
			long endTime = System.currentTimeMillis();
			System.out.println("ֱ�Ӷ�ȡ��д���ʱ��" + (endTime - startTime));

			long startTime1 = System.currentTimeMillis();
			rw.readWriteArray("e://test.txt", "e://test.err");
			long endTime1 = System.currentTimeMillis();
			System.out.println("ͨ���Զ��建�������ȡ��д���ʱ��" + (endTime1 - startTime1));
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}

}
