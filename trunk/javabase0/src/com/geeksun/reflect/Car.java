package com.geeksun.reflect;

/**
 * @author jzq
 *  Java �������
 *  
 */
public class Car {
	// ������Ǯ
	private Double price;

	// ��������ɫ
	private String color;

	// ��������
	private String name;

	//Action������
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

	// Ĭ�Ϲ��췽��
	public Car() {
		invoker = new ActionInvoker();
	}

	// ���������췽��
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

	// ������Ϊ
	public void Run() {
		System.out.println(name + "��������ɫΪ:" + color + ",���ļ�Ǯ��:" + price);
	}
	
	public String execute(){
		return "success";
	}
	
}
