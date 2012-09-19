package com.base.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 姜志强
 * 转化片断
 * 2010-10-27
 */
public class RevertFragment {
	
	static void handleSentense(String fileName) throws IOException{
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		String s;
		while((s=br.readLine())!=null){
			String regex = "[u4e00-u9fa5]";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(s);
			if(m.matches()){
				System.err.println(s);
			}
			
			System.out.println(s);
		}
		
		br.close();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			handleSentense("g://company_cer_spe.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
