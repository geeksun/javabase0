package com.geeks.thread;

//���ȶ���ӵ�к�������(���ñ���)�ͼ�����������
class Hm { //p227--����������
	static Object box = new Object(); //������Object,��Ϊwait��notify��Object����
	static int totalMater1 = 30; //ԭ������(�����ɲ�Ʒ����)
	static int totalMater2 = 40;
	static int produce1 = 20;
	static int produce2 = 30;
	static int sales = 0;
	/*static int sales1=0;
	static int sales2=0;*/
}

class Hsalesman extends Thread { //ӪҵԱ
	void sale() {
		synchronized (Hm.box) {
			if ((Hm.produce1 + Hm.produce2) == Hm.sales) {
				System.out.println("ӪҵԱ:sorry,please wait a little");
				try {
					Hm.box.wait(); //������Ϣ,�ȴ�����
				} catch (Exception e) {
				}
			}
			if ((Hm.produce1 + Hm.produce2) > Hm.sales) {
				Hm.sales++; //��������
				System.out.println("ӪҵԱ:Hm come,����������" + Hm.sales + "��"); //�����龰ģ��
				/*  if(Hm.produce1>Hm.sales1){
				     Hm.sales1++;                                     //��������
				System.out.println("ӪҵԱ:Hm come,A����������"+Hm.sales1+"��");   //�����龰ģ��
				  }
				  if(Hm.produce2>Hm.sales2){
					 Hm.sales2++;
				System.out.println("ӪҵԱ:Hm come,B����������"+Hm.sales2+"��");        
				  }*/
			}
		}
	}

	public void run() {
		while (Hm.sales < (Hm.totalMater1 + Hm.totalMater2)) {
			System.out.println("�˿�˵:��һ������"); // �˿�Ҫ�򺺱�
			sale();
			try {
				sleep(100); //sleepҪ��try-catch�������
			} catch (Exception e) {
			}
		}
	}
}

class HMake1 extends Thread { //��ʦA
	void make() {
		synchronized (Hm.box) { //ͬ����
			Hm.produce1++;
			System.out.println(getName() + ":here is a Hm,A��"
					+ (Hm.produce1 + "��"));

			Hm.box.notify(); //��������--֪ͨӪҵԱ
		}
	}

	public void run() {
		while (Hm.produce1 < Hm.totalMater1) { //������ԭ�Ͽ�������ʱ
			try {
				sleep(300); //��A��Ʒ��ʱ��
			} catch (Exception e) {
			}
			make(); //������
		}
	}
}

class HMake2 extends Thread { //��ʦB
	void make() {
		synchronized (Hm.box) { //ͬ����
			Hm.produce2++;
			System.out.println(getName() + ":here is a Hm,B��" + Hm.produce2
					+ "��");

			Hm.box.notify(); //��������--֪ͨӪҵԱ
		}
	}

	public void run() {
		while (Hm.produce2 < Hm.totalMater2) { //������ԭ�Ͽ�������ʱ
			try {
				sleep(400); //��B��Ʒ��ʱ��
			} catch (Exception e) {
			}
			make(); //������
		}
	}
}

/**
 * Synchronized����
 * @author ��־ǿ
 *  2008-3-1
 */
public class SynchronizedTest { //p227--����������
	public static void main(String[] args) {
		Hsalesman hh = new Hsalesman(); //ӪҵԱ
		HMake1 m1 = new HMake1(); //��ʦA
		HMake2 m2 = new HMake2(); //��ʦB
		m1.setName("��");
		m2.setName("��");
		m1.start();
		m2.start();
		hh.start();
	}
}
