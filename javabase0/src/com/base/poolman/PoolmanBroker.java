package com.base.poolman;

import java.io.File;
import java.sql.Connection;
import com.codestudio.util.SQLManager;
/**
 * @author 姜志强
 * poolman是一个优秀的连接池
 * this program have bug
 */
public class PoolmanBroker {
	 private static SQLManager sqlManager ; 
	 
	 public PoolmanBroker() 
	 { 
		System.out.println("2222222222222222222222");
		File f = new File("d://db.xml");
		String s = f.getAbsolutePath();
		System.out.println(s);
		if (sqlManager == null)
			sqlManager = SQLManager.getInstance(s);
		System.out.println("sqlManager creante");
	}

	public Connection getConnection() {
		Connection c = null;
		try {
			c = sqlManager.requestConnection();
		} catch (Exception e) {
			System.out.println(e); 
	 } 
	 System.out.println(c); 
	 return c; 
	} 

}
