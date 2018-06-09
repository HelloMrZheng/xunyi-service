package com.helpu.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	
	private HibernateUtils() {}

	private static HibernateUtils instance = new HibernateUtils();
	
	public static HibernateUtils getInstance() {
		return instance;
	}
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.configure().build();
			sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		}
		return sessionFactory;		
	}
	
	public Session getSession() {
		// 获取跟当前线程绑定的 Session
		return getSessionFactory().getCurrentSession();
	}
	
}
