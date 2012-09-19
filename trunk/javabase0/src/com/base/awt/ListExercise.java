package com.base.awt;

import java.awt.Frame;
import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 姜志强
 * @annotation: 利用List 组件，实现添加，删除功能。项目应该显示在List 组件上。 见书上第276页。
 */
public class ListExercise {

	public static void main(String[] args) throws IOException {
		Frame f = new Frame("List Experience");
		List list = new List(8);
		
		System.out.println("利用List组件，增加或删除项目（Item），格式为：add apple或remove apple");
		
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
			String aline;
			String[] str;
			label:while((aline=br.readLine())!=null){ 
				str = aline.split(" ");
				if(str[0].equals("add")){
					list.add(str[1]);
					f.add(list);
					f.pack();		//自动调整Frame的大小,使其可以显示其中所有的组件
					f.setVisible(true);
					System.err.println(str[1]+"添加完毕！");
					System.err.println("请继续进行操作：");
					continue label;
					/*break;*/
				}
				else if(str[0].equals("remove")){
					list.remove(str[1]);
					f.add(list);
					f.pack();
					f.setVisible(true);
					System.err.println(str[1]+"删除完毕");
					System.err.println("请继续进行操作：");
					continue label;
					//break;
				}
				else{
					System.err.println("格式不正确！");
					break;
				}
			}
			
			System.err.println("xun！");
		
	}

}
