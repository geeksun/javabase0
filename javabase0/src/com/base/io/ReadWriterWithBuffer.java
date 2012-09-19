package com.base.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ��־ǿ 
 * ʹ��ϵͳ���ݻ����������I/0����Ч�� �� 649K�ļ���ȡ���� 2157:1203
 * �����������������������������ļ��������, �ַ�������������������ı��ļ����ı���Ϣ������Ϊ�������ļ���
 * 2009-5-9
 */
public class ReadWriterWithBuffer {
	
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
	 * ͨ��ϵͳ���������ȡ��д���ļ�
	 */
	public static void readWriteBuffer(String fileFrom, String fileTo)
			throws IOException {
		InputStream inBuffer = null;
		OutputStream outBuffer = null;
		try {
			InputStream in = new FileInputStream(fileFrom);
			//ϵͳ������
			inBuffer = new BufferedInputStream(in);
			OutputStream out = new FileOutputStream(fileTo);
			outBuffer = new BufferedOutputStream(out);
			while (true) {
				//��ȡһ���ֽ�
				int byteData = inBuffer.read();
				if (byteData == -1) {
					break;
				}
				out.write(byteData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inBuffer != null)
				inBuffer.close();
			if (outBuffer != null)
				outBuffer.close();
		}
	}

	public static void main(String[] args) {
		ReadWriterWithBuffer rw = new ReadWriterWithBuffer();
		try {
			long startTime = System.currentTimeMillis();
			rw.readWrite("e://test.txt", "e://test.err");
			long endTime = System.currentTimeMillis();
			System.out.println("ֱ�Ӷ�ȡ��д���ʱ��" + (endTime - startTime));

			long startTime1 = System.currentTimeMillis();
			rw.readWriteBuffer("e://test.txt", "e://test.err");
			long endTime1 = System.currentTimeMillis();
			System.out.println("ͨ��ϵͳ���������ȡ��д���ʱ��" + (endTime1 - startTime1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
