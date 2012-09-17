package com.geeksun.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * @author Administrator
 *  工具类
 */
public class HibernateSessionFactory {
    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
    //  threadLocal 模式管理 session,为每个线程维护一个私有的变量空间
	private static final ThreadLocal threadLocal = new ThreadLocal();
    private  static Configuration configuration = new Configuration();
    private static org.hibernate.SessionFactory sessionFactory;
    private static String configFile = CONFIG_FILE_LOCATION;

    private HibernateSessionFactory() {
    }
	
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession(): null;
			//  将获取的session 实例保存
			threadLocal.set(session);
		}
        return session;
    }
	public static void rebuildSessionFactory() {
		try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err
					.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        //  将获取的session 实例保存
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }
	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setConfigFile(String configFile) {
		HibernateSessionFactory.configFile = configFile;
		sessionFactory = null;
	}
	public static Configuration getConfiguration() {
		return configuration;
	}
}