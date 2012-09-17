<%@ page contentType="text/html;charset=gbk" import="java.io.*"%>
<%@ page import="org.apache.poi.poifs.filesystem.*,org.apache.poi.hssf.usermodel.*"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<title>��ȡExcel����</title>
	</head>
	<body>
		<table border="1" width="100%">
			<%
				FileInputStream finput = new FileInputStream(application.getRealPath("/") + "excel/book1.xls");
				//�趨FileINputStream��ȡExcel�� 
				POIFSFileSystem fs = new POIFSFileSystem(finput);
				HSSFWorkbook wb = new HSSFWorkbook(fs);
				HSSFSheet sheet = wb.getSheetAt(0);
				//��ȡ��һ��������������Ϊsheet 
				finput.close();
				HSSFRow row = null;
				//����һ�� 
				HSSFCell cell = null;
				//����һ������� 
				short i = 0;
				short y = 0;
				//�Գ�״ޒȦ��ȡ���д�������� 
				for (i = 0; i <= sheet.getLastRowNum(); i++) {
					out.println("<tr>");
					row = sheet.getRow(i);
					for (y = 0; y < row.getLastCellNum(); y++) {
						cell = row.getCell(y);
						out.print("<td>");

						//�жϴ����ĸ�ʽ 
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_NUMERIC:
							out.print(cell.getNumericCellValue());
							//getNumericCellValue()��ش�doubleֵ������ϣ������С���㣬������ת��Ϊint 
							break;
						case HSSFCell.CELL_TYPE_STRING:
							out.print(cell.getStringCellValue());
							break;
						case HSSFCell.CELL_TYPE_FORMULA:
							out.print(cell.getNumericCellValue());
							//������ʽ�����������ֵ
							//��Ҫ������ʽ���ݣ�����cell.getCellFormula() 
							break;
						default:
							out.print("�����ĸ�ʽ");
							break;
						}
						out.println("</td>");
					}
					out.println("</tr>");
				}
			%>
		</table>
	</body>
</html>
