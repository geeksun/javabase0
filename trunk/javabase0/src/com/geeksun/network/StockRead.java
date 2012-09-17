package com.geeksun.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author ��־ǿ
 * ���������������ӵ� Yahoo Quote �����������ӷ������ϻ�ȡ��Ʊ���顣��ʹ�� Stock ������ӷ��������ص��ַ�����
 * 
 */
public class StockRead {
	public static void main(String argv[]) throws Exception {
		String quoteFormat = "&f=slc1wop";
		
		if (argv.length != 1) {
			System.err.println("Usage:  java StockReader ");
			System.exit(1);
		}
		
		URL url = new URL("http://quote.yahoo.com/d/quotes.csv?"+"s="+argv[0]+quoteFormat); 
		URLConnection  connection = url.openConnection();
		//  ʹ�� URL ���ӽ������ʱ��Ҫ����ֵ
		connection.setDoOutput(true);
		
		//  �����
		PrintWriter out = new PrintWriter(connection.getOutputStream());
		
		out.println("s=" + argv[0] + quoteFormat);
		out.close();
		
		//  ������
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = in.readLine(); 
		in.close();   
		/*while ((line = in.readLine()) != null) {           
			System.out.println("Got: "+ line);          
		} */      
		
		System.out.println("Name: " + Stock.getName(line));
		System.out.println("Price: " + Stock.getPrice(line));
		System.out.println("Date: " + Stock.getDate(line));
		
	}
}