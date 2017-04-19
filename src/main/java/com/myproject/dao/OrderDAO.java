package com.myproject.dao;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.myproject.exception.AdException;
import com.myproject.pojo.Customer;
import com.myproject.pojo.Flight;
import com.myproject.pojo.Orders;

public class OrderDAO extends DAO
{
	public OrderDAO()
	{
		
	}
	
	public Orders bookFlight(int quantity, String userName, int flightID, float totalPrice) throws AdException
	{
		try
		{
			begin();
			Orders orders = new Orders(quantity, userName, flightID, totalPrice);
			getSession().save(orders);
			commit();
			return orders;
		}
		catch (HibernateException e)
		{
			rollback();
			//throw new AdException("Could not create user " + customername, e);
			throw new AdException("Exception while creating order: " + e.getMessage());
		}
	}
	
	public List<Order> viewHistory(String userName) throws AdException
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from Orders where userName = :userName");
			q.setString("userName", userName);
			List list = q.list();
			System.out.println("Size of the list is " + list.size());
			return list;
		}
		catch (HibernateException e)
		{
			rollback();
			//throw new AdException("Could not create user " + customername, e);
			throw new AdException("Exception while getting order: " + e.getMessage());
		}
	}
}
