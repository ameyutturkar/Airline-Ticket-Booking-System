package com.myproject.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Flight")
public class Flight
{
	@Id
	@GeneratedValue
	@Column(name="flightID", unique=true, nullable=false)
	private int flightID;
	
	@Column(name="flightName")
	private String flightName;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	/*@Column(name="totalTickets")
	private int totalTickets;
	
	@Column(name="totalBooked")
	private int totalBooked;*/
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="startDateTime")
	private Date startDateTime;
	
	@Column(name="endDateTime")
	private Date endDateTime;
	
	@Column(name="price")
	private float price;
	
	@Column(name="userName")
	private String userName;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="userID")
	//@JoinColumn(name="airlineID")
	private Airline airline;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="orderID")
	private Orders orders;
	
	public Flight()
	{
		
	}
	
	public Flight(String flightName, String source, String destination, int quantity,
			Date startDateTime, Date endDateTime, float price, String userName)
	{
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.quantity = quantity;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.price = price;
		this.userName = userName;
		//this.airline = airline;
	}
	
	public int getFlightID() {
		return flightID;
	}
	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	public Date getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}	
}
