package com.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author ��־ǿ
 *  zipѹ�������I/OЧ��: 296kb�ļ�, ��Ϊ�� 969��47�� �����紫����Ҳ����ʹ��ѹ������ߴ���Ч�ʣ���Լ����������Դ����
 *  2009-5-17
 */
public class ReadWriteWithZipStream {

	/**
	 * @param fileFrom: Դ�ļ�
	 * @param fileTo: Ŀ���ļ�
	 * ֱ��ͨ���ļ������������ȡ��д���ļ�
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
	 * ͨ��ѹ������ȡ��д��
	 * @param fileFrom: Դ�ļ�
	 * @param fileTo��Ŀ���ļ�
	 */
	public static void readWriteZip(String fileFrom, String fileTo) throws Exception{
		ZipOutputStream zipoutputstream = new ZipOutputStream(new FileOutputStream(fileTo));
		zipoutputstream.setMethod(ZipOutputStream.DEFLATED);
		File file = new File(fileFrom); 
		byte[] rgb = new byte[1000];
		int n;
		//����һ�� zip entry.
		ZipEntry zipentry = new ZipEntry(fileTo);
		//��� zip entry ���������
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
			System.out.println("ֱ�Ӷ�ȡ��д���ʱ��" + (endTime - startTime) + "ms");
			long startTime1 = System.currentTimeMillis();
			rw.readWriteZip("D:/eclipselinks.zip", "D:/eclipselinks1.zip");
			long endTime1 = System.currentTimeMillis();
			System.out.println("ͨ��ѹ������ȡ��д���ʱ��" + (endTime1 - startTime1) + "ms");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
