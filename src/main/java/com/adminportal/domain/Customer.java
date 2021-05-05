package com.adminportal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String customerName;
	private String shopName;
	private String phoneNumber;
	private String AreaLocated;
	private String facebookName;
	private String email;
	@Column(columnDefinition="text")
	private String description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAreaLocated() {
		return AreaLocated;
	}
	public void setAreaLocated(String areaLocated) {
		AreaLocated = areaLocated;
	}
	public String getFacebookName() {
		return facebookName;
	}
	public void setFacebookName(String facebookName) {
		this.facebookName = facebookName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
