package com.helpu.beans;

import java.util.Date;

public class Address {

	private String id;
	
	private String district; // 区县
	
	private String town; // 乡镇
	
	private String village; // 村庄
	
	private String villageGroup; // 队组
	
	private String no; // 门牌号
	
	private Date creationDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getVillageGroup() {
		return villageGroup;
	}

	public void setVillageGroup(String villageGroup) {
		this.villageGroup = villageGroup;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Address [district=" + district + ", town=" + town + ", village=" + village + ", villageGroup=" + villageGroup
				+ ", no=" + no + "]";
	}

	public Address(String id, String district) {
		super();
		this.id = id;
		this.district = district;
	}
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

}
