package com.sun.sso;
import  java.io.File; 
import  java.io.FileOutputStream; 
import  java.io.PrintStream; 

/**
 * @author ��־ǿ
 * ������������ض���,һ������System.out�ᾭ�����ض���,��System.err���Ǿ������ض���,��������쳣������err�ȽϺ���
 */
public  class  B{ 
    /**
     * @param args
     *  ����������ļ���
     */
    public   static   void   main(String[]  args) { 
        try { 
            System.setOut(new  PrintStream(new  FileOutputStream(new  File( "d:/test.txt ")))); 
            System.out.println( "haha "); 
        }catch(Exception  e){ 
            e.printStackTrace(); 
        } 
    } 
} 

