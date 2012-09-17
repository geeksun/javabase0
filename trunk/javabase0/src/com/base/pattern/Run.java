package com.base.pattern;

public class Run implements Run3{
   public void run(){
	   System.out.println("A");
   }
   public void run2(){
	   System.out.println("B");
   }
   public void go(){
	   System.out.println("C");
   }
   public static void main(String[] args){
      Run run = new Run();
      run.run();
   }
}