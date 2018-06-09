package com.helpu.beans;

import java.util.Date;

public class User {

	private String id;
	
	private String name;
	
	private String password;
	
	private String tel;
	
	private Address address;
	
	private String state;
	
	private String star;
	
	private String ip;
	
	private Date registerDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", tel=" + tel + ", address=" + address + ", state=" + state + ", star=" + star
				+ ", ip=" + ip + ", registerDate=" + registerDate + "]";
	}
	
	public User() {
		// TODO Auto-generated constructor stub
		System.out.println("User's Constructor...");
	}
	
	public User(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void pre() {
		System.out.println("User's init...");
	}
	
	public void suf() {
		System.out.println("只有单例bean会在IoC容器关闭时调用该销毁方法...");
	}
	
	
	
}
