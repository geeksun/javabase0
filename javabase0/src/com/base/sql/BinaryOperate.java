package com.base.sql;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import oracle.jdbc.driver.OracleResultSet;
import oracle.sql.BLOB;

/**
 * @author Administrator
 * @category : �Զ��������ݵĲ�����������������word\PDF\img\mp3�ȣ���JDBC�в��������ƶ���ͨ�������롢������ķ�ʽ����ȡ��д��
 * �ṩ��һ����ʾ���������ݵ��� oracle.sql.BLOB,����ͨ������������������ƶ���
 * java.sql.Blob,Ҳ�ɲ�������������
 */
public class BinaryOperate {
	Connection con = null;
	public BinaryOperate() throws Exception{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		con = DriverManager.getConnection("jdbc:oracle:thin:system@127.0.01:1521:hellking","system","manager");
		con.createStatement().execute("create table blobtable(blobvalue blob");
	}
	/** @category д��Blob���������ݵ����ݿ�
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
			blob =  ((OracleResultSet)rs).getBLOB(1);			// getBLOB Ϊ OracleResultSet �ķ���
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
			file_out.write(temp);							//  ��ȡ���ݣ�д���ļ�ϵͳ
		
		file_out.close();
		blob_in.close();
		con.commit();
	}
}
