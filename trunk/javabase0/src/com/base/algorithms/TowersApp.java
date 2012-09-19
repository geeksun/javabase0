package com.base.algorithms;

/**
 *  汉诺塔问题
 */
public class TowersApp {
	static int nDisks = 3;			//  盘子的数量
	/**
	 * @param topN : 要移动的盘子的数量
	 * @param from : 源塔A
	 * @param inter: 中介塔B
	 * @param to : 目标塔C
	 */
	public static void doTowers(int topN,char from,char inter,char to)
	{
		if(topN==1)
			System.out.println("Disk 1 from "+from+" to "+to);
		else
		{
			doTowers(topN-1,from,to,inter);			//  from --> inter
			System.out.println("Disk "+topN+" from "+from+" to "+to);
			doTowers(topN-1,inter,from,to);			//  inter --> to
		}
	}
	public static void main(String[] args) {
		doTowers(nDisks,'A','B','C');
	}
}
