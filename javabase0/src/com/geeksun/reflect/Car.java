package com.geeksun.reflect;

/**
 * @author jzq
 *  Java 反射机制
 *  
 */
public class Car {
	// 汽车价钱
	private Double price;

	// 汽车的颜色
	private String color;

	// 汽车名字
	private String name;

	//Action调用者
	private ActionInvoker invoker;
	
	public ActionInvoker getInvoker() {
		return invoker;
	}

	public void setInvoker(ActionInvoker invoker) {
		this.invoker = invoker;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 默认构造方法
	public Car() {
		invoker = new ActionInvoker();
	}

	// 参数化构造方法
	Car(String name, Double price, String color) {
		this.name = name;
		this.price = price;
		this.color = color;
	}

	public void SetPrice(Double price) {
		this.price = price;
	}

	public Double getPrice() {
		return this.price;
	}

	public void SetColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	public void SetName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	// 汽车行为
	public void Run() {
		System.out.println(name + "汽车的颜色为:" + color + ",她的价钱是:" + price);
	}
	
	public String execute(){
		return "success";
	}
	
}
