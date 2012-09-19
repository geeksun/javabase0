package com.base.algorithms;

/**
 *  ��ŵ������
 */
public class TowersApp {
	static int nDisks = 3;			//  ���ӵ�����
	/**
	 * @param topN : Ҫ�ƶ������ӵ�����
	 * @param from : Դ��A
	 * @param inter: �н���B
	 * @param to : Ŀ����C
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
