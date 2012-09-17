package com.geeks.thread;

//首先定义拥有汉堡箱子(引用变量)和几个变量的类
class Hm { //p227--汉堡店流程
	static Object box = new Object(); //必须用Object,因为wait和notify是Object方法
	static int totalMater1 = 30; //原料总量(可做成产品的量)
	static int totalMater2 = 40;
	static int produce1 = 20;
	static int produce2 = 30;
	static int sales = 0;
	/*static int sales1=0;
	static int sales2=0;*/
}

class Hsalesman extends Thread { //营业员
	void sale() {
		synchronized (Hm.box) {
			if ((Hm.produce1 + Hm.produce2) == Hm.sales) {
				System.out.println("营业员:sorry,please wait a little");
				try {
					Hm.box.wait(); //箱子休息,等待被叫
				} catch (Exception e) {
				}
			}
			if ((Hm.produce1 + Hm.produce2) > Hm.sales) {
				Hm.sales++; //进行销售
				System.out.println("营业员:Hm come,汉堡总销售" + Hm.sales + "个"); //销售情景模拟
				/*  if(Hm.produce1>Hm.sales1){
				     Hm.sales1++;                                     //进行销售
				System.out.println("营业员:Hm come,A汉堡总销售"+Hm.sales1+"个");   //销售情景模拟
				  }
				  if(Hm.produce2>Hm.sales2){
					 Hm.sales2++;
				System.out.println("营业员:Hm come,B汉堡总销售"+Hm.sales2+"个");        
				  }*/
			}
		}
	}

	public void run() {
		while (Hm.sales < (Hm.totalMater1 + Hm.totalMater2)) {
			System.out.println("顾客说:来一个汉堡"); // 顾客要买汉堡
			sale();
			try {
				sleep(100); //sleep要在try-catch语句里面
			} catch (Exception e) {
			}
		}
	}
}

class HMake1 extends Thread { //厨师A
	void make() {
		synchronized (Hm.box) { //同步块
			Hm.produce1++;
			System.out.println(getName() + ":here is a Hm,A总"
					+ (Hm.produce1 + "个"));

			Hm.box.notify(); //叫醒箱子--通知营业员
		}
	}

	public void run() {
		while (Hm.produce1 < Hm.totalMater1) { //当还有原料可以生产时
			try {
				sleep(300); //做A产品的时间
			} catch (Exception e) {
			}
			make(); //做汉堡
		}
	}
}

class HMake2 extends Thread { //厨师B
	void make() {
		synchronized (Hm.box) { //同步块
			Hm.produce2++;
			System.out.println(getName() + ":here is a Hm,B总" + Hm.produce2
					+ "个");

			Hm.box.notify(); //叫醒箱子--通知营业员
		}
	}

	public void run() {
		while (Hm.produce2 < Hm.totalMater2) { //当还有原料可以生产时
			try {
				sleep(400); //做B产品的时间
			} catch (Exception e) {
			}
			make(); //做汉堡
		}
	}
}

/**
 * Synchronized测试
 * @author 姜志强
 *  2008-3-1
 */
public class SynchronizedTest { //p227--汉堡店流程
	public static void main(String[] args) {
		Hsalesman hh = new Hsalesman(); //营业员
		HMake1 m1 = new HMake1(); //厨师A
		HMake2 m2 = new HMake2(); //厨师B
		m1.setName("甲");
		m2.setName("乙");
		m1.start();
		m2.start();
		hh.start();
	}
}
