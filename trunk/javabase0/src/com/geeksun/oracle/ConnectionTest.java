package com.geeksun.oracle;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;																				

/**
 * @author geeksun
 * @see  Oracle connection example
 *  测试 Oracle 的数据库连接
 */
public class ConnectionTest {
	public static void main(String[] args){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			//  Oracle 版本为 8i ? NO 9i
			con = DriverManager.getConnection("jdbc:oracle:oci8:@geeksun","system","manager");
			st = con.createStatement();
			rs = st.executeQuery("select name from test");
			while(rs.next()){
				System.out.println(rs.getString(1)+" ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null)  rs.close();
				if(st!=null) st.close();
				if(con!=null) con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
}
