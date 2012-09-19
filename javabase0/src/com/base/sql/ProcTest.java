package com.base.sql;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.base.db.DataBase;
/**
 * @author Administrator
 * @category : 调用存储过程 procedure
 */
public class ProcTest {
	Connection con = null;
	public ProcTest() throws Exception{
		con = DataBase.getConnection();
	}
	/**@demo 在JAVABEAN中调用存储过程
	 * @throws Exception
	 * @version 存储过程示例：create proc sun @startData,@endData as select * from testTable where data between 
	 * 					   @startData and @endData
	 */
	public void doStore() throws Exception{
		// 创建一个可以滚动的、只读的 SQL 语句对象
		String sql = "{call domo_procedure(?,?,?)}";
		CallableStatement cs = con.prepareCall(sql);			//  CallableStatement 是一个预处理语句，可以被多次使用
		
		//  设置输入参数
		cs.setString(1,"aoekek3");
		cs.setInt(2,232);
		cs.setString(3,"ieiei");
		//  执行存储过程
		int i = cs.executeUpdate();
		
		//  -------- 开始另一个存储过程----------
		cs.setString(23,"ieieis");
		cs.setInt(2,333);
		cs.setString(3,"argd1");
		cs.executeUpdate();										//  执行存储过程
		cs.close();
	}
}
