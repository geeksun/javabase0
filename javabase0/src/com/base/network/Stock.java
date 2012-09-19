package com.base.network;

/**
 * @author ��־ǿ 
 * ������
 * ��URL���н���,ʹ�� openConnection ������ URL ������ ���ӵ� Yahoo Quote ��������
 * ���ӷ������ϻ�ȡ��Ʊ���� ���� Yahoo Quote ��������õ��ַ����������ֶ� (�����Ʊ���ơ��۸������)��
 */
public class Stock {
	private static String name, time, price;

	// Given a quote�����ۣ� from the server, retrieve��ȡ�أ� the name, price, and date of the stock
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
