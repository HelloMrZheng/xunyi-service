package com.helpu.log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.helpu.user.service.UserService;

public class LoggingProxy {

	// 要代理的对象
	private UserService target;
	
	public LoggingProxy(UserService target) {
		this.target = target;
	}
	
	public UserService getLoggingProxy() {
		UserService proxy = null;
		
		// 代理对象由哪一个类加载器负责加载
		ClassLoader loader = target.getClass().getClassLoader();
		
		// 代理对象的类型，即其中有哪些方法
		Class[] interfaces = new Class[] {UserService.class};
		
		// 当调用代理对象其中的方法时，该执行的代码
		InvocationHandler h = new InvocationHandler() {
			
			/**
			 * proxy：正在返回的代理对象，一般情况下，在 invoke 方法中不适用该对象
			 * method:正在被调用的方法
			 * args:调用方法时传入的参数
			 */
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				System.out.println(methodName);
				Object result = method.invoke(target, args);
				System.out.println("invoke..."+methodName+"end with"+result );
				return 0;
			}
		};
		
		proxy = (UserService) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
	
}
