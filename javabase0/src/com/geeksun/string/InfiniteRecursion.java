package com.geeksun.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ��־ǿ
 *  ����ʶ�ĵݹ�
 *  2009-12-12
 */
public class InfiniteRecursion {

	/**
	 * @see java.lang.Object#toString()
	 * ��ӡ������ڴ��ַ��������this, ��Ϊ��this�ĵط��������Զ�����ת��, ��Ϊ����������һ��String����������һ����+��, ������Ķ���this������String, ���Ǳ��������Ž�thisת����һ��
	 * String, ת�������ǵ���this��toString(), �����ͷ����˵ݹ���á���ȷ�����ǵ��� Object.toString();
	 */
	public String toString(){
		//return "InfiniteRecursion address:" + this + "\n";		// ����
		return super.toString();									// ��ȷ
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for(int i=0;i<10;i++){
			v.add(new InfiniteRecursion());
		}
		System.out.println(v);

	}

}
