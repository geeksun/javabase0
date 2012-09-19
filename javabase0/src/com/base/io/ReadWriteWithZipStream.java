package com.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author 姜志强
 *  zip压缩流提高I/O效率: 296kb文件, 比为： 969：47， 在网络传输中也可以使用压缩流提高传输效率，节约带宽（网络资源）。
 *  2009-5-17
 */
public class ReadWriteWithZipStream {

	/**
	 * @param fileFrom: 源文件
	 * @param fileTo: 目的文件
	 * 直接通过文件输入输出流读取与写入文件
	 */
	public  static void readWrite(String fileFrom, String fileTo) throws Exception{
		InputStream in = null;
		OutputStream out = null; 
		try{
			in = new FileInputStream(fileFrom);
			out = new FileOutputStream(fileTo);
			while(true){
				int bytedata = in.read();
				if(bytedata==-1){
					break;
				}
				out.write(bytedata);
			}
		}finally{
			if(in!=null){
				in.close();
			}
			if(out!=null){
				out.close();
			}
		}
	}
	
	/**
	 * 通过压缩流读取与写入
	 * @param fileFrom: 源文件
	 * @param fileTo：目的文件
	 */
	public static void readWriteZip(String fileFrom, String fileTo) throws Exception{
		ZipOutputStream zipoutputstream = new ZipOutputStream(new FileOutputStream(fileTo));
		zipoutputstream.setMethod(ZipOutputStream.DEFLATED);
		File file = new File(fileFrom); 
		byte[] rgb = new byte[1000];
		int n;
		//创建一个 zip entry.
		ZipEntry zipentry = new ZipEntry(fileTo);
		//添加 zip entry 与相关数据
		zipoutputstream.putNextEntry(zipentry);
		
		FileInputStream fileInputStream = new FileInputStream(file);
		while((n=fileInputStream.read(rgb))>-1){
			zipoutputstream.write(rgb, 0, n);
		}
		fileInputStream.close();
		
		zipoutputstream.closeEntry();
		zipoutputstream = null;
		fileInputStream = null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReadWriteWithZipStream rw = new ReadWriteWithZipStream();
		try{
			long startTime = System.currentTimeMillis();
			rw.readWrite("D:/eclipselinks.zip", "D:/eclipselinks1.zip");
			long endTime = System.currentTimeMillis();
			System.out.println("直接读取与写入耗时：" + (endTime - startTime) + "ms");
			long startTime1 = System.currentTimeMillis();
			rw.readWriteZip("D:/eclipselinks.zip", "D:/eclipselinks1.zip");
			long endTime1 = System.currentTimeMillis();
			System.out.println("通过压缩流读取与写入耗时：" + (endTime1 - startTime1) + "ms");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
