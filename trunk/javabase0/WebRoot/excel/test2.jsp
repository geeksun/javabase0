<%@ page contentType="text/html;charset=gbk" import="java.util.*,java.io.*" %>
<%@ page import="org.apache.poi.poifs.filesystem.*,org.apache.poi.hssf.usermodel.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>����������Excel����</title>
</head>
<body>
<%
  FileInputStream finput = new FileInputStream(application.getRealPath("/")+"excel/book1.xls" );
  //�趨FileINputStream��ȡExcel�� 
  POIFSFileSystem fs = new POIFSFileSystem( finput );
  HSSFWorkbook wb = new HSSFWorkbook(fs);
  HSSFSheet sheet = wb.getSheetAt(0);
  //��ȡ��һ��������������Ϊsheet 
  finput.close();
  HSSFRow row=null;
  //����һ�� 
  HSSFCell cell=null;
  //����һ�������
  short i=4;
  row=sheet.createRow(i);
  //����һ���µ��У�ע���ǵ�����(�м�������Ǵ�0����)
  cell=row.createCell((short)0);
  cell.setEncoding(HSSFCell.ENCODING_UTF_16);
  //�趨����������ִ�Ҫ����˫λԪ 
  cell.setCellValue("��ʾ��");
  cell=row.createCell((short)1);
  cell.setCellValue(1700);
  cell=row.createCell((short)2);
  cell.setCellValue(8);
  cell=row.createCell((short)3);
  //�趨��������Ϊ��ʽ����񣬲����빫ʽ 
  cell.setCellFormula("B"+(i+1)+"*C"+(i+1));
  try
  {
    FileOutputStream fout=new FileOutputStream(application.getRealPath("/")+"excel/book1.xls");
    wb.write(fout);
    //���� 
    fout.close();
    out.println("����ɹ�<a href='book1.xls'>book1.xls</a>");
  }
  catch(IOException e)
  {
    out.println("�������󣬴���ѶϢ��"+e.toString());
  }
%>
</body>
</html>
