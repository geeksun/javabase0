<%@ page contentType="text/html;charset=gbk" import="java.io.*" %>
<%@ page import="org.apache.poi.poifs.filesystem.*,org.apache.poi.hssf.usermodel.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>删除、修改资料至Excel档案</title>
</head>
<body>
<%
  FileInputStream finput = new FileInputStream(application.getRealPath("/")+"excel/book1.xls" );
  //设定FileINputStream读取Excel档
  POIFSFileSystem fs = new POIFSFileSystem( finput );
  HSSFWorkbook wb = new HSSFWorkbook(fs);
  HSSFSheet sheet = wb.getSheetAt(0);
  //读取第一个工作表，宣告其为sheet 
  finput.close();
  HSSFRow row=null;
  //宣告一列 
  HSSFCell cell=null;
  //宣告一个储存格
  row=sheet.getRow((short)4);
  //取出第五列
  if (row!=null)
     sheet.removeRow(row);
  //先侦测第五列存不存在，若在的话将第五列删除
  row=sheet.getRow((short)3);
  //取出第四列
  cell=row.getCell((short)2);
  //取出第三个储存格 
  cell.setCellValue(7);
  //设定该储存格值为7
  cell=row.getCell((short)3);
  
  cell.setCellFormula(cell.getCellFormula());		//  ??
  //上两行为取出公式储存格，并重新计算(因为刚才更新过计算公式的值)
  //如果不做，公式计算後的值不会更新 
  try
  {
    FileOutputStream fout=new FileOutputStream(application.getRealPath("/")+"book1.xls");
    wb.write(fout);
    //储存 
    fout.close();
    out.println("储存成功<a href='book1.xls'>book1.xls</a>");
  }
  catch(IOException e)
  {
    out.println("产生错误，错误讯息："+e.toString());
  }
%>
</body>
</html>
