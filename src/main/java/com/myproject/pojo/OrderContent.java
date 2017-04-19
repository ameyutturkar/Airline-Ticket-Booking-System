package com.myproject.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Controller;

@Entity
@Table(name="ordercontent")
public class OrderContent
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="orderContentID", unique=true, nullable=false)
	private int orderContentID;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
	private Orders orders;
	
	public OrderContent(Orders orders)
	{
		this.orders = orders;
	}

	public int getOrderContentID() {
		return orderContentID;
	}

	public void setOrderContentID(int orderContentID) {
		this.orderContentID = orderContentID;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}	
}
