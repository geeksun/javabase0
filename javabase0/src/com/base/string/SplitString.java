package com.base.string;						

import java.io.ByteArrayOutputStream;

public class SplitString {
	/**
	 * @param str
	 *  �ָ��ַ���
	 */
	public static String[] splitString(String str){
		String [] s = str.split(",");
		String [] t = new String[4];
		t[0] = s[0];
		s = s[1].split("\\|");
		t[1] = s[0];
		s = s[1].split("/"); 
		t[2] = s[0];
		t[3] = s[1];
		
		return t;
	}
	/**
	 *  ��дһ����ȡ�ַ����ĺ���������Ϊһ���ַ������ֽ��������Ϊ���ֽڽ�ȡ���ַ���������Ҫ��֤���ֲ����ذ����
	 *  ����"��ABC��DEF"��6��Ӧ�����Ϊ"��ABC"������"��ABC+���İ��"
	 */
	public static String subString(String src, int len){
        byte[] target = src.getBytes();
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        for (int i = 0; i < len; i++) {
            char b = (char) target[i];
            if (b > 128) {
                if (i < len - 1)            		// unicode �����Զ���һ���ַ�
                {
                    bs.write(b);
                    bs.write(target[++i]);
                }
            } else
                bs.write(b);
        }
        return new String(bs.toByteArray());
    }

	public static void main(String[] args) 
	{ 
		String s = "��ABC��DEF";
		System.out.println(subString(s,6));
		String st = "AB,CK|KD/id";
		String [] t = splitString(st);
		for(int i=0;i<t.length;i++){
			System.out.println(t[i]);
		}
	} 
}
