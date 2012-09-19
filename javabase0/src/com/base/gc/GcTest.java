package com.base.gc;

public class GcTest {
	private String id;

	public GcTest(String id) {
		this.id = id;
		System.out.println(this + "  is  created.");
	}

	public String toString() {
		return this.id;
	}

	public void finalize() {
		System.out.println(this + " is  garbage  collected.");
	}

	public static void main(String[] args) {
		new GcTest("object  a");
		//or   rather:  
		//GCTest   a   =   new   GCTest("object   a");  
		//a   =   null;  
		GcTest b = new GcTest("object  b");
		System.gc();
	}
}
