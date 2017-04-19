package com.myproject.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="airline")
@PrimaryKeyJoinColumn(name="userID")
public class Airline extends Users
{
	@Column(name="airlineName", unique=true)
	private String airlineName;
	
	@Column(name="airlineEmail")
	private String airlineEmail;
	
	@Column(name="airlineAddress")
	private String airlineAddress;
	
	@Column(name="accountStatus")
	private String accountStatus;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="airline")
	private Set<Flight> flights = new HashSet<Flight>();
	
	public Airline()
	{
		
	}
	
	public Airline(String airlineName, String airlineEmail, String airlineAddress,
			String accountStatus)
	{
		this.airlineName = airlineName;
		this.airlineEmail = airlineEmail;
		this.airlineAddress = airlineAddress;
		this.accountStatus = accountStatus;
		this.flights = new HashSet<Flight>();
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getAirlineEmail() {
		return airlineEmail;
	}

	public void setAirlineEmail(String airlineEmail) {
		this.airlineEmail = airlineEmail;
	}

	public String getAirlineAddress() {
		return airlineAddress;
	}

	public void setAirlineAddress(String airlineAddress) {
		this.airlineAddress = airlineAddress;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
}
