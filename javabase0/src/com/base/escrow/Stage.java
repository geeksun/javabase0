package com.base.escrow;

/**
 * @author ��־ǿ
 *  �����ַ���
 *  
 */
public class Stage {
	
	/**
	 *  ����ת���ַ����ķ����ֺ���ĸ�ַ�Ϊ ��-�� ,
	 */
	public static void convert(){
		String str = "  Pate't   tes.ie  ";
		char c;
		String s;
		int index;
		int len = str.length();
		for(int i=0;i<len;i++){		//ת���ַ����ķ����ֺ���ĸ�ַ�Ϊ ��-��
			c = str.charAt(i);
			s = String.valueOf(c);
			//if(!s.matches("[a-zA-Z]")&&!s.matches("[0-9]")){
			if(!s.matches("\\w")){
				str = str.replace(s, "-");
			}
		}
		System.out.println(str);
		
		for(int i=0;i<str.length();i++){	//����ж����-��, ת��Ϊһ����-��
			c = str.charAt(i);
			if(c=='-'){
				//index = str.indexOf("-");	
				if(i<str.length()-1){
					c = str.charAt(i+1);
					if(c=='-'){
						if(i>1){
							str = str.substring(0, i-1) + str.substring(i);
						}
					}
				}
			}			
		}
		System.out.println(str);
		if(str.startsWith("-")){	//ȥ��ǰ��� "-"
			str = str.substring(1);
		}
		if(str.endsWith("-")){
			str = str.substring(0, str.length()-1);
		}
		System.out.println(str);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		convert();
		
	}

}
