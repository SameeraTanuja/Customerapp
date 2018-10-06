package com.capgemini.customer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	private int customerId;
	private String customerName;
	private String email;
	private String address;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerId, String customerName, String email, String address) {
		super();
		this.customerId = customerId;
		this.setCustomerName(customerName);
		this.setEmail(email);
		this.setAddress(address);
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
