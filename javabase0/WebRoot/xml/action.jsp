<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="java.util.*,com.geeksun.xml.*"%>
<html>
<head>
<title>��ȡXML�ļ�����</title>
</head>
<body>
<h3 align="center">JDOM����XML�ļ�</h3>
<p align="center">��ȡXML�ļ��е���������</p>
<center>
<table border="1" cellpadding="0" cellspacing="1" style="border-collapse: collapse" width="80%" id="AutoNumber1">
<tr>
<td align="center" width="92">����</td>
<td align="center" width="92">����</td>
<td align="center" width="92">������</td>
<td align="center" width="92">�۸�</td>
<td align="center" width="92">��������</td>
<td align="center" width="94">����</td>
</tr>
</table>
<%
String path = application.getRealPath("/test/xml/")+"testC.xml";
XmlOperate xml=new XmlOperate();
Vector xmlall=xml.LoadXML(path);
for(int i=0;i<xmlall.size();i++){
xml=(XmlOperate)xmlall.elementAt(i );
/**out.println("����:"+xml.getbookname()+"<br>");
out.println("����:"+xml.getauthor()+"<br>");
out.println("������:"+xml.getpub()+"<br>");
out.println("�۸�:"+xml.getprice()+"<br>");
out.println("��������:"+xml.getpubdate()+"<br><br>");
*/
%>
<table border="1" cellpadding="0" cellspacing="1" style="border-collapse: collapse" width="80%" id="AutoNumber2">
<tr>
<td align="center" width="92"><%=xml.getbookname()%></td>
<td align="center" width="92"><%=xml.getauthor()%></td>
<td align="center" width="92"><%=xml.getpub()%></td>
<td align="center" width="92"><%=xml.getprice()%></td>
<td align="center" width="92"><%=xml.getpubdate()%></td>
<td align="center" width="94"& gt;<a href="xmlok.jsp?act=del&id=<%=i%>&path=& lt;%=path%>">ɾ��</a></td> 
</tr>
</table>
<%}%>
</center>
<form method="POST" action="xmlok.jsp">
<p align="center">
<input type="radio" value="add" checked name="act">������� <input type="radio" value="edit" name="act">�༭����
�� ��:<select size="1" name="id">
<%for(int i=0;i<xmlall.size();i++){%>
<option value="<%=i%>">��<%=i+1%>��</option>
<%}%>
</select><br>
�� ��:<input type="text" name="bookname" size="20"><br>
�� ��:<input type="text" name="author" size="20"><br>
������:<input type="text" name="pub" size="20"><br>
�� ��:<input type="text" name="price" size="20"><br>
�� ��:<input type="text" name="pubdate" size="20"></p>
<input type="hidden" name="path" value="<%=path%>">
<p align="center"& gt;<input type="submit" value="�ύ" name="B1"><input type="reset" value="����" name="B2"></p>
</form>
</body>
</html>