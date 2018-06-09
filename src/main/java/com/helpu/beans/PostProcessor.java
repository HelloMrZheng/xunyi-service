package com.helpu.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * bean 的后置处理器，两个方法运行在bean的构造方法之后，对 bean 调用初始化方法前后进行检查修正
 * 会为所有bean加上该处理器，然后逐个检查
 * @author z1363
 *
 */
public class PostProcessor implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName+"'s前置检查:");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName+"'s后置检查:");
		if (bean instanceof User) {
			User user = (User)bean;
			user.setName("被修改了...");
		}
		return bean;
	}

	
}
