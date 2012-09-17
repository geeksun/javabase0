package com.geeksun.test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jzq
 *  inputStream���read() ��read(byte[] buf,int off,int len) �ķ���ֵ
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
	 * ��һ���������ص���int,��2���������ص���byte����,������Ҫ�õ�2����ʱ��,��Ҫ�Ȱ�byteת��int,����������ȷ��ʾ.
	 * �� byte ����ת��������
	 * @param b     �ֽ�����
	 * @param iFrom ��ʼת��λ��
	 * @param iLen  Ҫת�����ֽ���
	 * @return ת������
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
