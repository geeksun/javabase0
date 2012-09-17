<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'table.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <center> 
	<table width="350" border="1" cellspacing="0" cellpadding="2" align="CENTER"> 
	<caption>网页速成 八月份访客浏览器使用分析</caption> 
	     <tr align="CENTER"> 
	
	<th>Month</th> 
	
	<th>% of IE visitor</th> 
	
	<th>% of NC visitor</th> 
	     </tr> 
	     <tr align="CENTER"> 
	
	<td>August</td> 
	
	<td>61%</td> 
	
	<td>39%</td> 
	     </tr> 
	</table> 
	</center> 

  </body>
</html>
