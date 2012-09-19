package com.base.network;

/**
 * @author 姜志强 
 * 工具类
 * 与URL进行交互,使用 openConnection 建立到 URL 的连接 连接到 Yahoo Quote 服务器，
 * 并从服务器上获取股票行情 将从 Yahoo Quote 服务器获得的字符串解析成字段 (例如股票名称、价格和日期)。
 */
public class Stock {
	private static String name, time, price;

	// Given a quote（报价） from the server, retrieve（取回） the name, price, and date of the stock
	public static void parse(String data) {
		//System.out.println("data: "+data);
		//"IBM","Jul 17 - <b>126.52</b>",0.00,"97.04 - 129.99",N/A,126.52
		int index = data.indexOf('"');
		name = data.substring(++index, (index = data.indexOf('"', index)));
		index += 3;
		time = data.substring(index, (index = data.indexOf('-', index)) - 1);
		index += 5;
		price = data.substring(index, (index = data.indexOf('<', index)));
	}

	// Get the name of the stock from
	public static String getName(String record) {
		parse(record);
		return (name);
	}

	// Get the price of the stock from
	public static String getPrice(String record) {
		parse(record);
		return (price);
	}

	// Get the date of the stock
	public static String getDate(String record) {
		parse(record);
		return time;
	}
}
