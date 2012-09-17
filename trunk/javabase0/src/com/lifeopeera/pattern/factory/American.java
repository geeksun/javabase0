package com.lifeopeera.pattern.factory;
public class  American implements Person
{
	public String sayHello(String name)
	{
		return name+",hello";
	}
	public String sayGoodBye(String name)
	{
		return name+",byebye";
	}
}

