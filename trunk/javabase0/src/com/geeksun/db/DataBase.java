package com.geeksun.db;

import java.sql.*;

/**
 * @author 姜志强
 *  JDBC 里的事务是由 Connection 控制的
 *  2009-5-17
 */
public class DataBase {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost/test?useUnicode=true&amp;characterEncoding=gbk",
							"root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		getConnection();

	}
	
}
