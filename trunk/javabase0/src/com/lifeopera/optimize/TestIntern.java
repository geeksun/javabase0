package com.lifeopera.optimize;

/**
 * @author ��־ǿ
 *  intern(): �ַ���פ�������ַ�����ӵ�פ���ַ�������; �ڲ�����Ҫ����� equals()���ַ����Ƚ�ʱ�����Բ����ַ���פ���ķ�����
 *  �����ϵͳ���ܡ���Ϊequals() ���۱ȵ��� "==" ��.
 *  פ���ص���Ҫ���þ���: ��פ�����ַ����˴�֮�����ͨ��"=="���Ƚϲ���,��equals()�������ٶȸ���. 
 *  2009-5-1
 */
public class TestIntern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = new String("��־ǿ");
		//String str = "��־ǿ";
		//û����פ������
		if(str == "��־ǿ"){
			System.out.println("��ͬ");
		}else{
			System.out.println("��ͬ");
		}
		
		//����פ������ ���ַ�����ӵ�פ������
		str = str.intern();
		if(str == "��־ǿ"){
			System.out.println("��ͬ");
		}else{
			System.out.println("��ͬ");
		}
	}

}
