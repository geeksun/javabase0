package com.base.algorithms;
/**
 *	雇员类,用来插入排序的对象
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
	 * @return name,这是用于搜索的关健字字段
	 */
	public String getName()
	{
		return name;
	}
}
/**
 *  对象的排序,不仅限于基本数据类型的排序
 *  用插入排序算法对对象排序
 */
public class ObjectSort {
	private Employee[] a;			//  此处为对象数组
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
	 *  显示数组中的元素的属性
	 */
	public void display()
	{
		for(int i=0;i<nElems;i++)
		{
			a[i].displayEmployee();	//  显示雇员的属性
		}
		System.out.println();
	}
	/**
	 *  对雇员进行插入排序
	 *  out 是一个区分标志
	 *  比较字符串或对象时用compareTo()方法
	 *  String的compareTo()根据两个String的字典顺序(字母序)返回不同的整数值,如果两字符串相同则返回0
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
