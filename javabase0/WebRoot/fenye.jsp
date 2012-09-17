<%@ page language="java" import="java.util.*,java.sql.*,com.db.DataBase" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>fenye Test</title>
  </head>
  
  <body>
    <%
    	int sumPage;
    	int curPage ;
    	int sumRows = 0;
    	int rows = 5;
    	
    		Connection con = DataBase.getConnection();
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("select count(*) from student");
    		while(rs.next()){
    			sumRows = rs.getInt(1);
    		}
    		sumPage = sumRows/rows == 0?sumRows/rows:sumRows/rows+1;	
    	%>
    
    	<%
    	int pp = Integer.parseInt(request.getParameter("pages"));
    	if(pp == 0){
    		curPage = 1;
    	}
    	else if(pp > sumPage){
    		curPage = sumPage;
    	}
    	else{
    		curPage = pp;
    	}
    	
    	 %>

    	 <% 
    	 rs = st.executeQuery("select * from student limit "+rows*(curPage-1)+","+rows);    
     %>
     <form action="#" method="get">
     <table border=1 align=center>  
     <tr>
     <th>ID</th><th>Name</th>
     </tr>
     <%
     		while(rs.next()){              
     			int id = rs.getInt(1);
     			String name = rs.getString(2);
      %>
     <tr>
     <td><%=id %></td><td><%=name %></td>
       </tr>
      <%
      	} 
       %>
       <tr>
       <td colspan=2>
       <a href="fenye.jsp?pages=1">首页</a>
       <a href="fenye.jsp?pages=<%=curPage-1%>">上一页</a> 
       <a href="fenye.jsp?pages=<%=curPage+1%>">下一页</a>
       <a href="fenye.jsp?pages=<%=sumPage %>">末页</a>
       </td>
       </tr>
      </table>
      </form>
      <%
      	con.close();
       %>
  </body>
</html>
