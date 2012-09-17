package com.sun.poolman;

import java.sql.*;

import javax.sql.DataSource;
import com.codestudio.sql.PoolMan;

/**
 * @author 姜志强
 * poolman:一个开源的连接池解决方案
 */
public class PoolmanTest {
	//  私有静态常量
	private static Connection con; 
	private static Statement st; 
	public Connection getConnection() throws ClassNotFoundException, SQLException { 
		con = null; 
		// 找到在 poolman.xml 中定义的数据源,poolman.xml 的位置在 src 下,classpath 下
		DataSource ds = PoolMan.findDataSource("sipo");  
		con = ds.getConnection(); 		
		// TYPE_SCROLL_INSENSITIVE:双向滚动,但不及时更新;CONCUR_UPDATABLE:能用结果集更新数据库中的表
		st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); 
		return con;
	} 
	public Connection getConnectionBySingle() throws SQLException
	{
		con = DriverManager.getConnection("jdbc:poolman://SIPO");
		return con; 
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		PoolmanTest pool = new PoolmanTest();
		con = pool.getConnectionBySingle();  		
		String sql = "select * from test";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			System.out.println("id: "+rs.getInt(1)+"-- name: "+rs.getString(2));
			
		}
		
	}
}
