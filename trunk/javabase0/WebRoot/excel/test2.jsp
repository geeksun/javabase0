<%@ page contentType="text/html;charset=gbk" import="java.util.*,java.io.*" %>
<%@ page import="org.apache.poi.poifs.filesystem.*,org.apache.poi.hssf.usermodel.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>插入资料至Excel档案</title>
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
  short i=4;
  row=sheet.createRow(i);
  //建立一个新的列，注意是第五列(列及储存格都是从0起算)
  cell=row.createCell((short)0);
  cell.setEncoding(HSSFCell.ENCODING_UTF_16);
  //设定这个储存格的字串要储存双位元 
  cell.setCellValue("显示卡");
  cell=row.createCell((short)1);
  cell.setCellValue(1700);
  cell=row.createCell((short)2);
  cell.setCellValue(8);
  cell=row.createCell((short)3);
  //设定这个储存格为公式储存格，并输入公式 
  cell.setCellFormula("B"+(i+1)+"*C"+(i+1));
  try
  {
    FileOutputStream fout=new FileOutputStream(application.getRealPath("/")+"excel/book1.xls");
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
