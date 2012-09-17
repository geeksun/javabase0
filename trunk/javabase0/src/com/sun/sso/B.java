package com.sun.sso;
import  java.io.File; 
import  java.io.FileOutputStream; 
import  java.io.PrintStream; 

/**
 * @author 姜志强
 * 输入输出可以重定向,一般来讲System.out会经常被重定向,而System.err则不是经常被重定向,所以输出异常还是用err比较合适
 */
public  class  B{ 
    /**
     * @param args
     *  定向输出到文件里
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

