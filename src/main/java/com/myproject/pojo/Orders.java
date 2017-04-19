package com.myproject.pojo;

import java.util.Date;
import java.util.HashSet; 
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="orderID", unique=true, nullable=false)
	private long orderID;
	
//	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	@JoinColumn(name="userID")
//	private Customer customer;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="orders")
	private Set<Flight> flights = new HashSet<Flight>();
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="flightID")
	private int flightID;
	
	@Column(name="totalPrice")
	private float totalPrice;
	
	public Orders()
	{
		
	}
	
	public Orders(int quantity, String userName, int flightID, float totalPrice)
	{
		this.quantity = quantity;
		this.userName = userName;
		this.flightID = flightID;
		this.totalPrice = totalPrice;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
