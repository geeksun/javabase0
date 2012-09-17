<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="com.geeksun.xml.*"%>
<%if(request.getParameter("act")!=null && request.getParameter("act").equals("add")){
XmlOperate.AddXML(request);
out.println("<p align='center'><br><br>添加成功<br><br><a href=''>返回</a>");
}
else if(request.getParameter("act")!=null && request.getParameter("act").equals("del")){
XmlOperate.DelXML(request);
out.println("<p align='center'><br><br>删除成功<br><br><a href=''>返回</a>");
}
else if(request.getParameter("act")!=null && request.getParameter("act").equals("edit")){
XmlOperate.EditXML(request);
out.println("<p align='center'><br><br>修改成功<br><br><a href=''>返回</a>");
}
else{out.print("<p align='center'><br><br>非法操作<br><br><a href=''>返回</a>");} 