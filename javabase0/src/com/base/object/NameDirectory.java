package com.base.object;

/**
 * @author ��־ǿ
 *  NameDirectory ������ܹ��洢20��������
 *  2009-4-27
 */
public class NameDirectory {
	String[] names;
	int nameCount;
	
	public NameDirectory(){
		names = new String[20];
		nameCount = 0;
	}
	
	public void addName(String name){
		if(nameCount<20){
			names[nameCount++] = name;
		}
	}
	

}
