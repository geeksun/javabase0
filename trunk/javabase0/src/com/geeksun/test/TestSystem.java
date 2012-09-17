package com.geeksun.test;

public class TestSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		try{
			int test = 2/i;
		}catch(Exception e){
			System.err.print("\nException:" + e.getMessage());
			e.printStackTrace();
		}
	}

}
