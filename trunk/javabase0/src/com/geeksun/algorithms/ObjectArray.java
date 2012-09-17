package com.geeksun.algorithms;
/**
 *	ְԱ��:��������Ҫ�洢�Ķ���
 */
class Person
{
	private String lastName;	// ��
	private String firstName;	// ��
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
	 * @return Person����,�������������Ĺؽ����ֶ�(����˵�������"��+��"�Ľṹ)
	 */
	public String getLast()
	{
		return lastName;
	}
}
/**
 *  ������洢����,��Ϊ����ͨ�������洢����,���������ڻ�����������
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
	 * @���ս�������,return Person����
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
	 *  �ڶ�������������һ������Ԫ��
	 */
	public void insert(String last,String first,int age)
	{
		Person p = new Person(last,first,age);
		a[nElems] = p;
		// a[nElems] = new Person(last,first,age);
		nElems++;			// increment size
	}
	/**
	 * @param searchName,ɾ�� lastName Ϊ searchName �� Person
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
	 *  ��ʾ ObjectArray ��Ԫ��
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
