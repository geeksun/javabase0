package com.base.util2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * @author Administrator
 * @category : 实现 List 接口的类有三个,ArrayList,Vector,LinkedList
 * 集合内的元素允许重复;集合内的数据有特定的顺序  
 * Vector 的方法是同步方法，是安全的  ------  此例提供了添加、删除、输出功能
 */
public class Vector2 {
	/**@category 遍历 Vector 中的 element
	 * @param v
	 */
	static void displayVector(Vector v){
		System.out.println("\n----------目录----------");
		for(int i=0;i<v.size();i++){
			System.out.print(v.elementAt(i)+" ");
		}
		System.out.println("\n------------------------\n");
	}
	public static void main(String[] args) throws IOException {
		Vector v = new Vector();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String select;
		
		while(true){
			System.out.println("<<1.添加2.删除3.退出>>");
			System.out.println("please select");
			select = br.readLine();
			if(select.equals("1")){
				System.out.println("Please input character string");
				v.add(br.readLine());
				displayVector(v);
			}
			else if(select.equals("2")){
				System.out.println("Please input element's serial number(from 0...)");
				v.removeElementAt(Integer.parseInt(br.readLine()));
				displayVector(v);
			}
			else if(select.equals("3")){
				break;
			}
		}
	}
}
