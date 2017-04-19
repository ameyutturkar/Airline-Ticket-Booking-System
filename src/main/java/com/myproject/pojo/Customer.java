package com.myproject.pojo;

import java.util.HashSet; 
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="customer")
@PrimaryKeyJoinColumn(name = "userID")
public class Customer extends Users
{
	@Column(name="customerName")
	private String customerName;
	
	@Column(name="customerEmail")
	private String customerEmail;
	
	@Column(name="customerAddress")
	private String customerAddress;
	
//	@OneToMany(fetch=FetchType.EAGER, mappedBy="customer")
//	private Set<Orders> orders = new HashSet<Orders>();
	
	public Customer()
	{
		
	}
	public Customer(String customerName, String customerEmail, String customerAddress)
	{
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
//	public Set<Orders> getOrders() {
//		return orders;
//	}
//	public void setOrders(Set<Orders> orders) {
//		this.orders = orders;
//	}
}