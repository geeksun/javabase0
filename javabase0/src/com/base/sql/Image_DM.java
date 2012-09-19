package com.base.sql;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author 姜志强
 *  向数据库插入图片
 */
public class Image_DM {
	private Connection con = null;
	public Image_DM() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			String url = "jdbc:mysql://localhost/img?user=root&password=&useUnicode=true&characterEncoding=gbk";
			con = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet exesql(String sql) throws Exception {
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rst = stmt.executeQuery(sql);
		return rst;

	}

	public int getAvailable() throws Exception {
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery("select count(*) as mycount from test_img");

		rset.next();
		int ret = rset.getInt("mycount");

		return ret;
	}

	public String getsql() throws Exception {
		String str = null;
		str = "select * from test_img order by 1";
		return str;
	}

	public void insert(String id, String photo) throws Exception {
		//插入数据库  
		String sql = "insert into test_img values (?,?,?)";
		//转换成file格式  
		java.io.File filename = new java.io.File(photo);

		//将文件的长度读出，并转换成Long型  
		long l1 = filename.length();
		int l2 = (int) l1;

		//以流的格式赋值  
		FileInputStream fis = new FileInputStream(filename);

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, filename.getName());
			ps.setBinaryStream(3, fis, l2);
			//ps.setBinaryStream(3,fis,fis.available());  
			ps.executeUpdate();
			//ps.execute();  
			ps.close();
			fis.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			throw e;
		}
	}

}
