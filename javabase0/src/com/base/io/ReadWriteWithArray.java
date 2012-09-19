package com.base.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author 姜志强 
 * 使用自定义缓冲区来提高I/0操作效率 ： 649K文件读取性能 2187:31
 * 2009-5-9
 */
public class ReadWriteWithArray {
	
	/**
	 * @param fileFrom
	 * @param fileTo
	 *            直接通过文件输入输出流读取与写入文件
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
				//一次读取一个字节
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
	 * 通过自定义缓冲区类读取与写入文件
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
			
			//一次最多只能读取 1k 数据, 1024 byte
			int byteData = in.read(totalBytes);
			
			//totalBytes 最好是 512 的倍数, 这样计算速度快一些
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
			System.out.println("直接读取与写入耗时：" + (endTime - startTime));

			long startTime1 = System.currentTimeMillis();
			rw.readWriteArray("e://test.txt", "e://test.err");
			long endTime1 = System.currentTimeMillis();
			System.out.println("通过自定义缓冲区类读取与写入耗时：" + (endTime1 - startTime1));
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}

}
