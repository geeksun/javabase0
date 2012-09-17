package com.geeksun.test;

public class TestClass {
	public static void main(String[] args) throws InterruptedException{
		long begin = System.currentTimeMillis();
		//Man man1 = null;
		for(int i=0;i<1000000;i++){
			Man man1 = new Man();
			man1.setAge(10);
			man1.setName("test");
		}
		long end = System.currentTimeMillis();
		System.out.println("所用时间1：" + (end - begin));
		
		Thread.sleep(1000);
		long start = System.currentTimeMillis();
		Man man = null;
		for(int i=0;i<1000000;i++){
			man = new Man();
			man.setAge(10);
			man.setName("test");
		}
		long over = System.currentTimeMillis();
		System.out.println("所用时间2：" + (over - start));
	}

}	

class Man{
	private int age;
	private String name;
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}