package com.lifeopera.optimize;

import java.math.BigDecimal;

/**
 * @author 姜志强
 *  货币的运算: 要求精确度的地方，避免使用 float 和 double, 可用 BigDecimal or int,long
 *  2009-6-2
 */
public class Currency {

	public static void doubleTest(){
		double funds = 1.00;	//资金
		int itemBought = 0;
		
		for(double price=.10;funds>=price;price += .10){
			funds -= price;
			itemBought ++;
		}
		System.out.println(itemBought + " items bought.");
		System.out.println("Change:$" + funds);
	}
	
	public static void bigDecimal(){
		final BigDecimal TEN_CENTS = new BigDecimal(".10");
		
		int itemBought = 0;
		BigDecimal funds = new BigDecimal("1.00");
		for(BigDecimal price = TEN_CENTS;funds.compareTo(price)>=0;price = price.add(TEN_CENTS)){
			//System.out.println("price: " + price);
			itemBought ++;
			funds = funds.subtract(price);
			//System.out.println("funds: " + funds);
		}
		System.out.println(itemBought + " items bought.");
		System.out.println("Money left over :$" + funds);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(1.03 - 0.42);		//.42 == 0.42
		System.out.println(1.00 - 9*.10);
		doubleTest();
		bigDecimal();
	}

}
