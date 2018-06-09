package com.helpu.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.helpu.beans.Address;

public class testHibernate {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Test
	public void test() throws InterruptedException {
		
		Address address = (Address) session.get(Address.class, "4");
		System.out.println(address);
		transaction.commit();
		session.close();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Address address1 = session.get(Address.class, "5");
		System.out.println(address1);
		Thread.sleep(10000);
		
		
	}
	
	
	@Before
	public void init() {
		
		/*Configuration configuration = new Configuration().configure();
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);*/
		
		final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		session = sessionFactory.openSession();
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
	}
	
	@After
	public void destroy() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
