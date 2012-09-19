package com.base.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jzq
 * 测试对象的生成: 在for循环前声明对象为null, 然后在for中引用这个对象，这样只有一个引用，如果在for声明并生成对象，将有N多个引用，占用内存。
 * 2009-4-27
 */
public class TestGenerateObject {

	/**
	 * @param  args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		int count = 0;
		int count2 = 0;
		
		long start = System.currentTimeMillis();
		Map<String, Man> map3 = new HashMap<String, Man>();
		Man man = null;
		for(int i=0;i<7915;i++){
			man = new Man();
			man.setAge(10);
			man.setName("test");
			man.setAddress("hongkong"+i);
			String adr3 = man.getAddress();
			if(adr3!=null){
				adr3 = adr3.toLowerCase().trim();
				if("".equals(adr3)){
					++ count;
					System.out.println("空记录数1：" + count2);
				}else{
					map3.put(adr3, man);
				}
			}
		}
		long over = System.currentTimeMillis();
		System.out.print("\nAddress:" + map3.get("hongkong21").getAddress() +"||"+ map3.get("hongkong23").getAddress());
		System.out.print("\nfor前对象为Null所用时间：" + (over - start));
		
		
		Thread.sleep(1000);
		long begin = System.currentTimeMillis();
		Map<String, Man> map2 = new HashMap<String, Man>();
		for(int i=0;i<7915;i++){
			Man man3 = new Man();
			man3.setAge(10);
			man3.setName("test");
			man3.setAddress("hongkong"+i);
			String adr2 = man3.getAddress();
			if(adr2!=null){
				adr2 = adr2.toLowerCase().trim();
				if("".equals(adr2)){
					++ count;
					System.out.println("空记录数1：" + count2);
				}else{
					map2.put(adr2, man3);
				}
			}
			
		}
		long end = System.currentTimeMillis(); 
		System.out.print("\nAddress:" + map2.get("hongkong21").getAddress() +"||"+ map2.get("hongkong23").getAddress());
		System.out.print("\n在for中生成新对象所用时间：" + (end - begin));
		
		
		//不可用，因为最后所有 url 引用的是同一个对象，即不同的 url 引用的是同一个对象，如同一个 sington object.
		/*Thread.sleep(1000);
		
		long start2 = System.currentTimeMillis();
		Man man2 = new Man();
		Map<String, Man> map = new HashMap<String, Man>();
		for(int i=0;i<7915;i++){
			//man2.setAge(i+1);
			man2.setAge(i);
			man2.setName("test2");
			man2.setAddress("hongkong2"+i);
			//System.out.println("age3：" + man2.getAge());
			String adr = man2.getAddress();
			if(adr!=null){
				adr = adr.toLowerCase().trim();
				if("".equals(adr)){
					++ count;
					System.out.println("空记录数2：" + count);
				}else{
					//System.err.println(man2.getAge());
					map.put(adr, man2);
					//man2 = null;
				}
			}
		}
		long over2 = System.currentTimeMillis();
		System.out.print("\nAddress:" + map.get("hongkong21").getAddress() +"||"+ map.get("hongkong23").getAddress());
		System.out.println("\n在for前生成新对象所用时间：" + (over2 - start2));*/
		//不这样会下面输出在前
		Thread.sleep(1000);
		String systemName = System.getProperties().getProperty("os.name");
		System.err.print("\nSystem Name:" + systemName);
		
	}

}
