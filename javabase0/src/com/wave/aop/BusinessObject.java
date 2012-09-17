package com.wave.aop;

import java.util.logging.Logger;

/**
 * @author jzq BO: 业务对象 2009-5-8
 * 处理商业逻辑的代码和日志记录代码混合在一起，这给日后的维护带来一定的困难，并且也会造成大量的代码重复。
 * 完全相同的log代码将出现在系统的每一个BusinessObject中。
 * 2009-5-8
 */
public class BusinessObject implements BusinessInterface {
	private Logger logger = Logger.getLogger(this.getClass().getName());


	/* pre process method
	 * 处理商业逻辑的代码和日志记录代码混合在一起，这给日后的维护带来一定的困难，并且也会造成大量的代码重复。
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
	 *  业务处理
	 */
	public void processBusiness() {
		//business processing
		System.out.println("here is business logic"); 
	}

}
