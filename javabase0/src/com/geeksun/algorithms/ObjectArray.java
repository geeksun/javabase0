package com.geeksun.algorithms;
/**
 *	职员类:在数组中要存储的对象
 */
class Person
{
	private String lastName;	// 姓
	private String firstName;	// 名
	private int age;
	public Person(String last,String first,int a)
	{
		lastName = last;
		firstName = first;
		age = a;
	}
	public void displayPerson()
	{
		System.out.print(lastName+" "+firstName+" "+age);
		System.out.println();
	}
	/**
	 * @return Person的姓,这是用于搜索的关健字字段(外国人的名字是"名+姓"的结构)
	 */
	public String getLast()
	{
		return lastName;
	}
}
/**
 *  用数组存储对象,因为数组通常用来存储对象,而不仅限于基本数据类型
 */
public class ObjectArray {
	private Person[] a;
	private int nElems;		// number of data items
	public ObjectArray(int max)
	{
		a = new Person[max];
		nElems = 0;			// no items yet
	}
	/**
	 * @param searchName
	 * @按姓进行搜索,return Person对象
	 */
	public Person find(String searchName)
	{
		int j;
		for(j=0;j<nElems;j++)
			if(a[j].getLast().equals(searchName))
				break;
		if(j==nElems)		//  not find it
			return null;
		else
			return a[j];
	}
	/**
	 * @param last
	 * @param first
	 * @param age
	 *  在对象数组里增加一个对象元素
	 */
	public void insert(String last,String first,int age)
	{
		Person p = new Person(last,first,age);
		a[nElems] = p;
		// a[nElems] = new Person(last,first,age);
		nElems++;			// increment size
	}
	/**
	 * @param searchName,删除 lastName 为 searchName 的 Person
	 * @return
	 */
	public boolean delete(String searchName)
	{
		int j;
		for(j=0;j<nElems;j++)				//  look for it
			if(a[j].getLast().equals(searchName))
				break;
		if(j==nElems)						//  can't find it
			return false;
		else
		{
			for(int k=j;k<nElems;k++)
				a[k] = a[k+1];
			nElems--;
			return true;
		}
	}
	/**
	 *  显示 ObjectArray 的元素
	 */
	public void displayObjectArray()
	{
		for(int j=0;j<nElems;j++)
			a[j].displayPerson();
	}
	public static void main(String[] args) {
		int maxSize = 100;
		ObjectArray oa = new ObjectArray(maxSize);
		
		oa.insert("Yee","Patty",18);
		oa.insert("Smith", "Tom",28);
		oa.insert("Leo","sun",27);
		
		oa.displayObjectArray();
		
		String searchName = "Smith";
		Person p = oa.find(searchName);
		if(p!=null)
		{
			System.out.println("Found ");
			p.displayPerson();
		}
		else
			System.out.println("Can't find "+searchName);
		
		System.out.println("Deleting Smith...");
		oa.delete("Smith");
		
		oa.displayObjectArray();
	}
}
