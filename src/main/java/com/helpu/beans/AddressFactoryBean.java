package com.helpu.beans;

import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean 方式配置 bean
 * 应用场景：bean 的创建涉及复杂逻辑，单纯的xml配置不能胜任
 * 
 * @author zhengyadong
 * @date 2018年5月26日
 */
public class AddressFactoryBean implements FactoryBean<Address> {

	private String town;
	
	public void setTown(String town) {
		this.town = town;
	}
	
	public Address getObject() throws Exception {
		return new Address();
	}

	public Class<?> getObjectType() {
		return Address.class;
	}

}
