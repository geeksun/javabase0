package com.base.optimize;

import java.sql.Connection;
import java.util.Hashtable;

/**
 * @author ��־ǿ
 *  ����ز���
 *  2009-5-1
 */
public class TestPool { 
	private static Hashtable locked;
	private Hashtable unlocked;
	
	public static void main(String[] args){
		JdbcPool pool = new JdbcPool();
		Connection conn = pool.create();
		
		System.out.println(locked.get("con"));
		
	}
}
