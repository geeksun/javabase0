package com.wave.aop;

import java.util.logging.Logger;

/**
 * @author jzq BO: ҵ����� 2009-5-8
 * ������ҵ�߼��Ĵ������־��¼��������һ������պ��ά������һ�������ѣ�����Ҳ����ɴ����Ĵ����ظ���
 * ��ȫ��ͬ��log���뽫������ϵͳ��ÿһ��BusinessObject�С�
 * 2009-5-8
 */
public class BusinessObject implements BusinessInterface {
	private Logger logger = Logger.getLogger(this.getClass().getName());


	/* pre process method
	 * ������ҵ�߼��Ĵ������־��¼��������һ������պ��ά������һ�������ѣ�����Ҳ����ɴ����Ĵ����ظ���
	 * public void processBusiness() {
		try {
			logger.info("start to processing...");
			// business logic here
			System.out.println("here is business logic");
			logger.info("end processing...");
		} catch (Exception e) {
			logger.info("exception happends...");
			// exception handling
		}
	}*/
	
	/**
	 *  ҵ����
	 */
	public void processBusiness() {
		//business processing
		System.out.println("here is business logic"); 
	}

}
