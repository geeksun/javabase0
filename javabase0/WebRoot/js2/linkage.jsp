<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'linkage.jsp' starting page</title>

  </head>
  
  <body>
	<%
response.write"1:"&Request.form("s1")&"<BR>"
response.write"2:"&Request.form("s2")&"<BR>"
response.write"3:"&Request.form("s3")&"<BR>"
%>

=========================================================

<!-- 三级联动菜单 开始 -->
<script language="JavaScript">
<!--
<%
'二级数据保存到数组
Dim count2,rsClass2,sqlClass2
set rsClass2=server.createobject("adodb.recordset")
sqlClass2="select * from aa" 
rsClass2.open sqlClass2,conn,1,1
%>
var subval2 = new Array();
//数组结构：一级根值,二级根值,二级显示值
<%
count2 = 0
do while not rsClass2.eof
%>
subval2[<%=count2%>] = new Array('<%=rsClass2("aID")%>','<%=rsClass2("ID")%>','<%=rsClass2("Name")%>')
<%
count2 = count2 + 1
rsClass2.movenext
loop
rsClass2.close
%>

<%
'三级数据保存到数组
Dim count3,rsClass3,sqlClass3
set rsClass3=server.createobject("adodb.recordset")
sqlClass3="select * from aaa" 
rsClass3.open sqlClass3,conn,1,1
%>
var subval3 = new Array();
//数组结构：二级根值,三级根值,三级显示值
<%
count3 = 0
do while not rsClass3.eof
%>
subval3[<%=count3%>] = new Array('<%=rsClass3("aaID")%>','<%=rsClass3("ID")%>','<%=rsClass3("Name")%>')
<%
count3 = count3 + 1
rsClass3.movenext
loop
rsClass3.close
%>

function changeselect1(locationid)
{
    document.form1.s2.length = 0;
    document.form1.s2.options[0] = new Option('==请选择类别==','');
    document.form1.s3.length = 0;
    document.form1.s3.options[0] = new Option('==请选择专题==','');
    for (i=0; i<subval2.length; i++)
    {
        if (subval2[i][0] == locationid)
        {document.form1.s2.options[document.form1.s2.length] = new Option(subval2[i][2],subval2[i][1]);}
    }
}

function changeselect2(locationid)
{
    document.form1.s3.length = 0;
    document.form1.s3.options[0] = new Option('==请选择专题==','');
    for (i=0; i<subval3.length; i++)
    {
        if (subval3[i][0] == locationid)
        {document.form1.s3.options[document.form1.s3.length] = new Option(subval3[i][2],subval3[i][1]);}
    }
}
//-->
</script>

<form name="form1" method="post" action="test1.asp">

三级联动：
<%
Dim count1,rsClass1,sqlClass1
set rsClass1=server.createobject("adodb.recordset")
sqlClass1="select * from a" 
rsClass1.open sqlClass1,conn,1,1
%>
<select name="s1" onChange="changeselect1(this.value)">
<option>==请选择频道==</option>
<%
count1 = 0
do while not rsClass1.eof
response.write"<option value="&rsClass1("ID")&">"&rsClass1("Name")&"</option>"
count1 = count1 + 1
rsClass1.movenext
loop
rsClass1.close
%>
</select>

<select name="s2"  onChange="changeselect2(this.value)"> 
<option>==请选择类别==</option>
</select>

<select name="s3"> 
<option>==请选择专题==</option>
</select>
<input type="submit" name="Submit" value="提交"></form>

<!-- 三级联动菜单 结束 -->

	
  </body>
</html>
