<%@ page contentType="text/html;charset=gbk" import="java.io.*" %>
<%@ page import="org.apache.poi.poifs.filesystem.*,org.apache.poi.hssf.usermodel.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>ɾ�����޸�������Excel����</title>
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
  row=sheet.getRow((short)4);
  //ȡ��������
  if (row!=null)
     sheet.removeRow(row);
  //���������д治���ڣ����ڵĻ���������ɾ��
  row=sheet.getRow((short)3);
  //ȡ��������
  cell=row.getCell((short)2);
  //ȡ������������� 
  cell.setCellValue(7);
  //�趨�ô����ֵΪ7
  cell=row.getCell((short)3);
  
  cell.setCellFormula(cell.getCellFormula());		//  ??
  //������Ϊȡ����ʽ����񣬲����¼���(��Ϊ�ղŸ��¹����㹫ʽ��ֵ)
  //�����������ʽ�������ֵ������� 
  try
  {
    FileOutputStream fout=new FileOutputStream(application.getRealPath("/")+"book1.xls");
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
