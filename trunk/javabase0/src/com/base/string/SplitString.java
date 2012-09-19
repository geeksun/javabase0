package com.base.string;						

import java.io.ByteArrayOutputStream;

public class SplitString {
	/**
	 * @param str
	 *  分割字符串
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
	 *  编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。但是要保证汉字不被截半个，
	 *  输入"我ABC汉DEF"，6，应该输出为"我ABC"而不是"我ABC+汉的半个"
	 */
	public static String subString(String src, int len){
        byte[] target = src.getBytes();
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        for (int i = 0; i < len; i++) {
            char b = (char) target[i];
            if (b > 128) {
                if (i < len - 1)            		// unicode 还可以读下一个字符
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
		String s = "我ABC汉DEF";
		System.out.println(subString(s,6));
		String st = "AB,CK|KD/id";
		String [] t = splitString(st);
		for(int i=0;i<t.length;i++){
			System.out.println(t[i]);
		}
	} 
}
