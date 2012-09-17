package com.geeksun.oracle;
import java.sql.*;

public abstract class DaoKu {
	public static void main(String[] args) {
		Connection con1 = null;		
		Connection con2 = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
	 
		int temp = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			con1 =  DriverManager.getConnection("jdbc:oracle:oci8:@test","scott","tiger");  
			con2 =  DriverManager.getConnection("jdbc:mysql://localhost:3306/oracle","root","");
			
			stmt1 = con1.prepareStatement("select * from dept");
			stmt2 = con2.prepareStatement("insert into dept values(?,?,?)");

			int i = 1;
			    ResultSet rs = stmt1.executeQuery();
			    
			    while(rs.next()){
			    	
			    	stmt2.setInt(1, rs.getInt(1));
			    	stmt2.setString(2, rs.getString(2));
			    	stmt2.setString(3, rs.getString(3));
			    	
			    	stmt2.addBatch();
			    }
			    
			    int counts[] = stmt2.executeBatch();
				System.out.print("共处理了"+counts.length+"条数据");

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
				try {
					con1.close();
					con2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	    //关闭连接、释放资源
		/*EMP表
		 * stmt2 = con2.prepareStatement("insert into emp values(?,?,?,?,?,?,?,?)");
		while(rs.next()){
		    	stmt2.setInt(1, rs.getInt(1));
		    	stmt2.setString(2, rs.getString(2));
		    	stmt2.setString(3, rs.getString(3));
		    	stmt2.setInt(4, rs.getInt(4));
		    	stmt2.setString(5, rs.getString(5));
		    	stmt2.setInt(6, rs.getInt(6));
		    	stmt2.setInt(7, rs.getInt(7));
		    	stmt2.setInt(8, rs.getInt(8));
		    	
		    	stmt2.addBatch();
		    	
		    }*/

	}
}
