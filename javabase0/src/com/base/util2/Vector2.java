package com.base.util2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * @author Administrator
 * @category : ʵ�� List �ӿڵ���������,ArrayList,Vector,LinkedList
 * �����ڵ�Ԫ�������ظ�;�����ڵ��������ض���˳��  
 * Vector �ķ�����ͬ���������ǰ�ȫ��  ------  �����ṩ����ӡ�ɾ�����������
 */
public class Vector2 {
	/**@category ���� Vector �е� element
	 * @param v
	 */
	static void displayVector(Vector v){
		System.out.println("\n----------Ŀ¼----------");
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
			System.out.println("<<1.���2.ɾ��3.�˳�>>");
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
