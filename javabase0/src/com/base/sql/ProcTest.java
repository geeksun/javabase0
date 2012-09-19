package com.base.sql;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.base.db.DataBase;
/**
 * @author Administrator
 * @category : ���ô洢���� procedure
 */
public class ProcTest {
	Connection con = null;
	public ProcTest() throws Exception{
		con = DataBase.getConnection();
	}
	/**@demo ��JAVABEAN�е��ô洢����
	 * @throws Exception
	 * @version �洢����ʾ����create proc sun @startData,@endData as select * from testTable where data between 
	 * 					   @startData and @endData
	 */
	public void doStore() throws Exception{
		// ����һ�����Թ����ġ�ֻ���� SQL ������
		String sql = "{call domo_procedure(?,?,?)}";
		CallableStatement cs = con.prepareCall(sql);			//  CallableStatement ��һ��Ԥ������䣬���Ա����ʹ��
		
		//  �����������
		cs.setString(1,"aoekek3");
		cs.setInt(2,232);
		cs.setString(3,"ieiei");
		//  ִ�д洢����
		int i = cs.executeUpdate();
		
		//  -------- ��ʼ��һ���洢����----------
		cs.setString(23,"ieieis");
		cs.setInt(2,333);
		cs.setString(3,"argd1");
		cs.executeUpdate();										//  ִ�д洢����
		cs.close();
	}
}
