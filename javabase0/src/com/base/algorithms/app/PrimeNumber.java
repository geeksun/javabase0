package com.base.algorithms.app;

import java.util.ArrayList;
import java.util.List;

/**
 * 求100以内的质数:除了被1和本身可以整除外，其他数字都不能整除
 * @author 姜志强
 * 2010-9-19
 */
public class PrimeNumber {
	
	public static void getPrimeNumber(){
		List<Integer> list = new ArrayList<Integer>();;
		for(int i=2;i<100;i++){
			list.add(i);
			for(int j=2;j<i;j++){
				if(i!=j){
					if(i%j==0){
						list.remove(Integer.valueOf(i));
						break;
					}
					if(i==j){
						System.out.println(i);
					}
				}
			}
		}
		for(Integer i:list){
			System.out.println(i);
		}
	}
	
	static void prime(){
		int i,j;
		for(i=1;i<100;i++){
			for(j=2;j<i;j++){
				if(i%j==0){
					break;
				}
			}
			if(i<=j){
				System.out.println(i);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//getPrimeNumber();
		//test();
		prime();
	}

}
