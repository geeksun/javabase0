package com.base.reflect;

/**
 * @author jzq
 *  ������ԣ�
 *  
 */
public class CarMain {
	
	public CarMain() {
	}

	public static void main(String arges[]) {
		try {
			Reflect ref = new Reflect();
			//���� car ʵ��
			Car car = ref.ReflectCar();
			/*System.out.println(car.getName());
			System.out.println(car.getPrice());
			System.out.println(car.getColor());*/
			car.Run();
		} catch (Throwable x) {
			x.printStackTrace();
		}
	}
}
