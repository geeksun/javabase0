package com.base.util2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @author geeksun
 * @category : forfex(jian dao),cloth-wrappers,hammer play
 * computer's choice by Random
 * 石头，剪刀，布的游戏
 */
public class StonePlay {
	public static void main(String[] args) throws IOException {
		Random ran = new Random();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String select;
		String comp;
		
		label:while(true){
			System.out.println("Play begin");
			System.out.println("forfex(1),hammer(2),cloth-wrappers(3),which you choice?");
			select = br.readLine(); 
			
			if(select.equals("1")){
				comp = String.valueOf(ran.nextInt(3)+1);					// also replace Integer.toString(i)
				if(comp.equals("1")){
					System.out.println("<Result>");
					System.out.println("Player : forfex");
					System.out.println("Computer : forfex");
					System.out.println("dogfall");
					System.out.println("score: 0:0");
					System.out.println("Play continue?[y/n]");
				}
				else if(comp.equals("2")){
					System.out.println("<Result>");
					System.out.println("Player : forfex");
					System.out.println("Computer : hammer");
					System.out.println("computer win");
					System.out.println("score: 0:1");
					System.out.println("Play continue?[y/n]");
				}
				else if(comp.equals("3")){
					System.out.println("<Result>");
					System.out.println("Player : forfex");
					System.out.println("Computer : cloth-wrappers");
					System.out.println("player win");
					System.out.println("score: 1:0");
					System.out.println("Play continue?[y/n]");
				}
				select = br.readLine();
				if(select.equals("y")){
					continue label;
				}else if(select.equals("n"))
					break;
			}
			else if(select.equals("2")){
				comp = String.valueOf(ran.nextInt(3)+1);
				if(comp.equals("1")){
					System.out.println("<Result>");
					System.out.println("Player : hammer");
					System.out.println("Computer : forfex");
					System.out.println("Player win");
					System.out.println("score: 1:0");
					System.out.println("Play continue?[y/n]");
				}
				else if(comp.equals("2")){
					System.out.println("<Result>");
					System.out.println("Player : hammer");
					System.out.println("Computer : hammer");
					System.out.println("dogfall");
					System.out.println("score: 0:0");
					System.out.println("Play continue?[y/n]");
				}
				else if(comp.equals("3")){
					System.out.println("<Result>");
					System.out.println("Player : hammer");
					System.out.println("Computer : cloth-wrappers");
					System.out.println("Computer win");
					System.out.println("score: 0:1");
					System.out.println("Play continue?[y/n]");
				}
				select = br.readLine();
				if(select.equals("y")){
					continue label;
				}else if(select.equals("n"))
					break;
			}
			else if(select.equals("3")){
				comp = String.valueOf(ran.nextInt(3)+1);
				if(comp.equals("1")){
					System.out.println("<Result>");
					System.out.println("Player : cloth-wrappers");
					System.out.println("Computer : forfex");
					System.out.println("Computer win");
					System.out.println("score: 0:1");
					System.out.println("Play continue?[y/n]");
				}
				else if(comp.equals("2")){
					System.out.println("<Result>");
					System.out.println("Player : cloth-wrappers");
					System.out.println("Computer : hammer");
					System.out.println("Player win");
					System.out.println("score: 1:0");
					System.out.println("Play continue?[y/n]");
				}
				else if(comp.equals("3")){
					System.out.println("<Result>");
					System.out.println("Player : cloth-wrappers");
					System.out.println("Computer : cloth-wrappers");
					System.out.println("dogfall");
					System.out.println("score: 0:0");
					System.out.println("Play continue?[y/n]");
				}
				select = br.readLine();
				if(select.equals("y")){
					continue label;
				}else if(select.equals("n"))
					break;
			}
		}
	}
}
