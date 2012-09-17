package com.geeksun.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * @author Administrator
 *  ������
 */
public class HibernateSessionFactory {
    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
    //  threadLocal ģʽ���� session,Ϊÿ���߳�ά��һ��˽�еı����ռ�
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
			//  ����ȡ��session ʵ������
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
        //  ����ȡ��session ʵ������
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