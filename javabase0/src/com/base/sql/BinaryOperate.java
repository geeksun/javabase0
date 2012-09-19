package com.base.sql;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import oracle.jdbc.driver.OracleResultSet;
import oracle.sql.BLOB;

/**
 * @author Administrator
 * @category : 对二进制数据的操作，二进制数据有word\PDF\img\mp3等，在JDBC中操作二进制对象通常用输入、输出流的方式来读取和写入
 * 提供了一个表示二进制数据的类 oracle.sql.BLOB,可以通过这个类来操作二进制对象
 * java.sql.Blob,也可操作二进制数据
 */
public class BinaryOperate {
	Connection con = null;
	public BinaryOperate() throws Exception{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		con = DriverManager.getConnection("jdbc:oracle:thin:system@127.0.01:1521:hellking","system","manager");
		con.createStatement().execute("create table blobtable(blobvalue blob");
	}
	/** @category 写入Blob二进制数据到数据库
	 * @param fileName
	 * @throws Exception
	 */
	public void addBlob(String fileName) throws Exception{
		con.setAutoCommit(false);
		Statement st = con.createStatement();
		st.execute("insert into blobtable values (empty_blob())");
		ResultSet rs = st.executeQuery("select blobvalue from blobtable for update");
		
		BLOB blob = null;
		// Blob b = null;					java.sql.Blob class,used to operate binary data
		while(rs.next()){
			blob =  ((OracleResultSet)rs).getBLOB(1);			// getBLOB 为 OracleResultSet 的方法
			System.out.println(blob.length());
		}
		File binaryFile = new File(fileName);
		System.out.println(fileName+" s length = "+binaryFile.length());
		
	}
	public void readBlob(String fileName) throws Exception{
		con.setAutoCommit(false);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select blobvalue from blobtable");
		BLOB blob = null;
		while(rs.next()){
			blob = ((OracleResultSet)rs).getBLOB(1);
			System.out.println(blob.length());
		}
		
		FileOutputStream file_out = new FileOutputStream(new File(fileName));
		InputStream blob_in = blob.getBinaryStream();
		int temp;
		while((temp=blob_in.read())!=-1)
			file_out.write(temp);							//  读取数据，写入文件系统
		
		file_out.close();
		blob_in.close();
		con.commit();
	}
}
