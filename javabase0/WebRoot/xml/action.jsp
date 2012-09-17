<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="java.util.*,com.geeksun.xml.*"%>
<html>
<head>
<title>读取XML文件资料</title>
</head>
<body>
<h3 align="center">JDOM操作XML文件</h3>
<p align="center">读取XML文件中的所有资料</p>
<center>
<table border="1" cellpadding="0" cellspacing="1" style="border-collapse: collapse" width="80%" id="AutoNumber1">
<tr>
<td align="center" width="92">书名</td>
<td align="center" width="92">作者</td>
<td align="center" width="92">出版社</td>
<td align="center" width="92">价格</td>
<td align="center" width="92">出版日期</td>
<td align="center" width="94">操作</td>
</tr>
</table>
<%
String path = application.getRealPath("/test/xml/")+"testC.xml";
XmlOperate xml=new XmlOperate();
Vector xmlall=xml.LoadXML(path);
for(int i=0;i<xmlall.size();i++){
xml=(XmlOperate)xmlall.elementAt(i );
/**out.println("书名:"+xml.getbookname()+"<br>");
out.println("作者:"+xml.getauthor()+"<br>");
out.println("出版社:"+xml.getpub()+"<br>");
out.println("价格:"+xml.getprice()+"<br>");
out.println("出版日期:"+xml.getpubdate()+"<br><br>");
*/
%>
<table border="1" cellpadding="0" cellspacing="1" style="border-collapse: collapse" width="80%" id="AutoNumber2">
<tr>
<td align="center" width="92"><%=xml.getbookname()%></td>
<td align="center" width="92"><%=xml.getauthor()%></td>
<td align="center" width="92"><%=xml.getpub()%></td>
<td align="center" width="92"><%=xml.getprice()%></td>
<td align="center" width="92"><%=xml.getpubdate()%></td>
<td align="center" width="94"& gt;<a href="xmlok.jsp?act=del&id=<%=i%>&path=& lt;%=path%>">删除</a></td> 
</tr>
</table>
<%}%>
</center>
<form method="POST" action="xmlok.jsp">
<p align="center">
<input type="radio" value="add" checked name="act">添加资料 <input type="radio" value="edit" name="act">编辑资料
序 号:<select size="1" name="id">
<%for(int i=0;i<xmlall.size();i++){%>
<option value="<%=i%>">第<%=i+1%>条</option>
<%}%>
</select><br>
书 名:<input type="text" name="bookname" size="20"><br>
作 者:<input type="text" name="author" size="20"><br>
出版社:<input type="text" name="pub" size="20"><br>
价 格:<input type="text" name="price" size="20"><br>
日 期:<input type="text" name="pubdate" size="20"></p>
<input type="hidden" name="path" value="<%=path%>">
<p align="center"& gt;<input type="submit" value="提交" name="B1"><input type="reset" value="重置" name="B2"></p>
</form>
</body>
</html>