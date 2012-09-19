package com.base.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author ��־ǿ ʹ�ø߲��API�ӿڣ�URL��
 * run:Ҫ������Ч��URL,�磺http://www.google.cn
 */
public class HighReadUrl {
	public static void main(String argv[]) throws Exception {
		if (argv.length != 1) {
			System.out.println("Usage: java ReadURL2 ");
			System.exit(0);
		}
		
		URL url = new URL(argv[0]);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String line;
		StringBuffer sb = new StringBuffer();
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}
		in.close();
		System.out.println(sb.toString());
	}
}
