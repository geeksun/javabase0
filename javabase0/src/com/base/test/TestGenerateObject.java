package com.base.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jzq
 * ���Զ��������: ��forѭ��ǰ��������Ϊnull, Ȼ����for�����������������ֻ��һ�����ã������for���������ɶ��󣬽���N������ã�ռ���ڴ档
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
					System.out.println("�ռ�¼��1��" + count2);
				}else{
					map3.put(adr3, man);
				}
			}
		}
		long over = System.currentTimeMillis();
		System.out.print("\nAddress:" + map3.get("hongkong21").getAddress() +"||"+ map3.get("hongkong23").getAddress());
		System.out.print("\nforǰ����ΪNull����ʱ�䣺" + (over - start));
		
		
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
					System.out.println("�ռ�¼��1��" + count2);
				}else{
					map2.put(adr2, man3);
				}
			}
			
		}
		long end = System.currentTimeMillis(); 
		System.out.print("\nAddress:" + map2.get("hongkong21").getAddress() +"||"+ map2.get("hongkong23").getAddress());
		System.out.print("\n��for�������¶�������ʱ�䣺" + (end - begin));
		
		
		//�����ã���Ϊ������� url ���õ���ͬһ�����󣬼���ͬ�� url ���õ���ͬһ��������ͬһ�� sington object.
		/*Thread.sleep(1000);
		
		long start2 = System.currentTimeMillis();
		Man man2 = new Man();
		Map<String, Man> map = new HashMap<String, Man>();
		for(int i=0;i<7915;i++){
			//man2.setAge(i+1);
			man2.setAge(i);
			man2.setName("test2");
			man2.setAddress("hongkong2"+i);
			//System.out.println("age3��" + man2.getAge());
			String adr = man2.getAddress();
			if(adr!=null){
				adr = adr.toLowerCase().trim();
				if("".equals(adr)){
					++ count;
					System.out.println("�ռ�¼��2��" + count);
				}else{
					//System.err.println(man2.getAge());
					map.put(adr, man2);
					//man2 = null;
				}
			}
		}
		long over2 = System.currentTimeMillis();
		System.out.print("\nAddress:" + map.get("hongkong21").getAddress() +"||"+ map.get("hongkong23").getAddress());
		System.out.println("\n��forǰ�����¶�������ʱ�䣺" + (over2 - start2));*/
		//�����������������ǰ
		Thread.sleep(1000);
		String systemName = System.getProperties().getProperty("os.name");
		System.err.print("\nSystem Name:" + systemName);
		
	}

}
