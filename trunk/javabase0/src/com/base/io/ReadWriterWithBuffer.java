package com.base.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author 姜志强 
 * 使用系统数据缓冲流来提高I/0操作效率 ： 649K文件读取性能 2157:1203
 * 二进制输入输出流用来处理二进制文件或对象流, 字符数据输入输出流处理文本文件和文本信息。本案为二进制文件。
 * 2009-5-9
 */
public class ReadWriterWithBuffer {
	
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
	 * 通过系统缓冲区类读取与写入文件
	 */
	public static void readWriteBuffer(String fileFrom, String fileTo)
			throws IOException {
		InputStream inBuffer = null;
		OutputStream outBuffer = null;
		try {
			InputStream in = new FileInputStream(fileFrom);
			//系统缓冲流
			inBuffer = new BufferedInputStream(in);
			OutputStream out = new FileOutputStream(fileTo);
			outBuffer = new BufferedOutputStream(out);
			while (true) {
				//读取一个字节
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
			System.out.println("直接读取与写入耗时：" + (endTime - startTime));

			long startTime1 = System.currentTimeMillis();
			rw.readWriteBuffer("e://test.txt", "e://test.err");
			long endTime1 = System.currentTimeMillis();
			System.out.println("通过系统缓冲区类读取与写入耗时：" + (endTime1 - startTime1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
