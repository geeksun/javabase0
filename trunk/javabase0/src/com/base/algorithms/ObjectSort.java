package com.base.algorithms;
/**
 *	��Ա��,������������Ķ���
 */
class Employee
{
	private String name;
	private String address;
	private int age;
	public Employee(String n,String add,int ag)
	{
		name = n;
		address = add;
		age = ag;
	}
	public void displayEmployee()
	{
		System.out.println(name+" "+address+" "+age);
	}
	/**
	 * @return name,�������������Ĺؽ����ֶ�
	 */
	public String getName()
	{
		return name;
	}
}
/**
 *  ���������,�������ڻ����������͵�����
 *  �ò��������㷨�Զ�������
 */
public class ObjectSort {
	private Employee[] a;			//  �˴�Ϊ��������
	private int nElems;
	public ObjectSort(int max)
	{
		a = new Employee[max];
		nElems = 0;
	}
	/**put Employee into array
	 * @param name
	 * @param address
	 * @param age
	 */
	public void insert(String name,String address,int age)
	{
		a[nElems] = new Employee(name,address,age);
		nElems++;					//  increment size
	}
	/**
	 *  ��ʾ�����е�Ԫ�ص�����
	 */
	public void display()
	{
		for(int i=0;i<nElems;i++)
		{
			a[i].displayEmployee();	//  ��ʾ��Ա������
		}
		System.out.println();
	}
	/**
	 *  �Թ�Ա���в�������
	 *  out ��һ�����ֱ�־
	 *  �Ƚ��ַ��������ʱ��compareTo()����
	 *  String��compareTo()��������String���ֵ�˳��(��ĸ��)���ز�ͬ������ֵ,������ַ�����ͬ�򷵻�0
	 */
	public void insertSort()
	{
		int in,out;			
		for(out=1;out<nElems;out++)
		{
			Employee temp = a[out];
			in = out;
			//  "abc">"aaa" "a"<"b"
			while(in>0&&a[in-1].getName().compareTo(temp.getName())>0)
			{
				a[in] = a[in-1];
				--in;
			}
			a[in] = temp;
		}
	}
	public static void main(String[] args) {
		int maxSize = 100;
		ObjectSort os = new ObjectSort(maxSize);
		
		os.insert("test","hb",29);
		os.insert("green","sh",23);
		os.insert("java","bj",92);
		os.insert("blue","sx",18);
		os.insert("green","sz",28);
		
		os.display();
		os.insertSort();
		os.display();
	}
}
