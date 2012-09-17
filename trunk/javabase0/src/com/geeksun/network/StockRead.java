package com.geeksun.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author 姜志强
 * 这个类的任务是连接到 Yahoo Quote 服务器，并从服务器上获取股票行情。它使用 Stock 类解析从服务器返回的字符串。
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
		//  使用 URL 连接进行输出时需要设置值
		connection.setDoOutput(true);
		
		//  输出流
		PrintWriter out = new PrintWriter(connection.getOutputStream());
		
		out.println("s=" + argv[0] + quoteFormat);
		out.close();
		
		//  输入流
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