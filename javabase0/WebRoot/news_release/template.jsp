<%@ page contentType="text/html; charset=gb2312" import="java.util.*,java.io.*"%>
<%
try{
	String title="jsp���ɾ�̬html�ļ�";
	String content="С�������㲻���㣿";
	String editer="hpsoft";
	String filePath = "";
	filePath = request.getRealPath("/")+"template.htm";
	out.print(filePath);
	String templateContent="";
	FileInputStream fileinputstream = new FileInputStream(filePath);//��ȡģ���ļ�
	
	int lenght = fileinputstream.available();
	byte bytes[] = new byte[lenght];
	fileinputstream.read(bytes);
	fileinputstream.close();
	templateContent = new String(bytes);
	out.print(templateContent);
	templateContent=templateContent.replaceAll("###title###",title);
	templateContent=templateContent.replaceAll("###content###",content);
	templateContent=templateContent.replaceAll("###author###",editer);//�滻��ģ������Ӧ�ĵط�
	out.print(templateContent);
	// ����ʱ����ļ���
	Calendar calendar = Calendar.getInstance();
	String fileame = String.valueOf(calendar.getTimeInMillis()) +".html";
	fileame = request.getRealPath("/")+fileame;//���ɵ�html�ļ�����·��
	FileOutputStream fileoutputstream = new FileOutputStream(fileame);//�����ļ������
	out.print("�ļ����·��:<br>");
	out.print(fileame);
	byte tag_bytes[] = templateContent.getBytes();
	fileoutputstream.write(tag_bytes);
	fileoutputstream.close();
}catch(Exception e){
	out.print(e.toString());
}

%>