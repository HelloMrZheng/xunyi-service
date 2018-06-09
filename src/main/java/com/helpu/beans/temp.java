package com.helpu.beans;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class temp {

	public static void main(String[] args) throws SQLException {

		// 1. 创建一个 SessionFactory 对象
		SessionFactory sessionFactory = null;

		// 2). 创建一个 ServiceRegistry 对象，hibernate 的任何配置和服务都需要在该对象中注册后才有效
		final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

		// 3). 创建 SessionFactory
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

		// 2. 创建一个 Session 对象
		Session session = sessionFactory.openSession();
		
		// 3. 开启事务
		Transaction transaction = session.beginTransaction();
		
		// 4. 执行保存操作
//		Address address = new Address("1","xunyi");
//		session.save(address);
		
		// 5. 提交事务
		transaction.commit();
		
		// 6. 关闭 Session
		session.clear();
		
		// 7. 关闭 SessionFactory 对象
		sessionFactory.close();
	}

}
