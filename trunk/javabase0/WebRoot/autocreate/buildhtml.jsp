<%@ page contentType="text/html; charset=gb2312" import="java.util.*,java.io.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>build html source</title>

  </head>
  
  <body>
	<%
	try{
		String title="jsp���ɾ�̬html�ĵ�";
		String content="С�������㲻������";
		String editer="webjxcom";
		String filePath = "";
		
		// filePath = request.getRealPath("/")+"template.html";
		filePath = "template.html";
		out.print(filePath);
		
		String templateContent="";
		FileInputStream fileinputstream = new FileInputStream(filePath);	//��ȡģ���ĵ�
		int lenght = fileinputstream.available();
		byte bytes[] = new byte[lenght];
		fileinputstream.read(bytes);
		fileinputstream.close();
		templateContent = new String(bytes);
		out.print(templateContent);
		
		templateContent=templateContent.replaceAll("###title###",title);
		templateContent=templateContent.replaceAll("###content###",content);
		templateContent=templateContent.replaceAll("###author###",editer);	//�滻��ģ������Ӧ�ĵط�
		out.print(templateContent);
		
		// ����ʱ����ĵ���
		Calendar calendar = Calendar.getInstance();
		String fileame = String.valueOf(calendar.getTimeInMillis()) +".html";
		fileame = request.getRealPath("/")+fileame;							//���ɵ�html�ĵ�����·��
		FileOutputStream fileoutputstream = new FileOutputStream(fileame);	//�����ĵ������
		out.print("�ĵ����·��:<br>");
		out.print(fileame);
		
		byte tag_bytes[] = templateContent.getBytes();
		fileoutputstream.write(tag_bytes);
		fileoutputstream.close();
	}
	catch(Exception e){
		out.print(e.toString());
	}
	%>

  </body>
