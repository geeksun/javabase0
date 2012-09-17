package com.geeksun.test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jzq
 *  inputStream里的read() 和read(byte[] buf,int off,int len) 的返回值
 *  2009-5-7
 */
public class zipTest {

	public zipTest() {
	}

	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream("d://1.txt");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int num;
		byte[] buf = new byte[1];

		int a = in.read(buf);
		out.write(a);
		String str = new String(out.toByteArray());
		System.out.println(str);
		a = in.read(buf);
		out.write(a);

		str = new String(out.toByteArray());
		System.out.println(str);
		out.close();
		in.close();
	}

	/**  
	 * 第一个方法返回的是int,第2个方法返回的是byte数组,所以你要用第2个的时候,你要先把byte转成int,这样才能正确显示.
	 * 将 byte 数组转化成整数
	 * @param b     字节数组
	 * @param iFrom 开始转换位置
	 * @param iLen  要转换的字节数
	 * @return 转换后结果
	 */
	public static int b2i(byte[] b, int iFrom, int iLen) {
		int iRet = 0;
		int iTep;
		for (int i = iFrom; i < iFrom + iLen && i < b.length; i++) {
			iTep = b[i];
			if (iTep < 0) {
				iTep += 256;
			}
			//iTep = iTep &lt;&lt; (iLen-1-(i-iFrom)*8);
			//iRet = iRet | iTep;

			iRet = (iRet << 8) | iTep;
		}
		return iRet;
	}
	
	
}
