package com.myproject.dao;

import org.hibernate.HibernateException; 
import org.hibernate.Query;

import com.myproject.exception.AdException;
import com.myproject.pojo.Airline;
import com.myproject.pojo.Customer;

public class CustomerDAO extends DAO
{
	public CustomerDAO()
	{
		
	}
	
	public Customer get(String customerName)throws AdException
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from Customer where customerName = :customername");
			q.setString("customerName", customerName);
			Customer customer = (Customer) q.uniqueResult();
			commit();
			return customer;
		}
		catch (HibernateException e)
		{
			rollback();
			throw new AdException("Could not get user " + customerName, e);
		}
	}
	
	public Customer getCustomerForFile(String userName)throws AdException
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from Customer where userName = :userName");
			q.setString("userName", userName);
			Customer customer = (Customer) q.uniqueResult();
			commit();
			return customer;
		}
		catch (HibernateException e)
		{
			rollback();
			throw new AdException("Could not get user " + userName, e);
		}
	}
	
	public Customer create(String customerName, String customerEmail, String customerAddress,
			String userName, String userPassword, String roleType) throws AdException
	{
		try
		{
			begin();
			System.out.println("inside DAO");
			//Customer customer = new Customer();
			Customer customer = new Customer(customerName, customerEmail, customerAddress);
			customer.setCustomerName(customerName);
			customer.setCustomerEmail(customerEmail);
			customer.setCustomerAddress(customerAddress);
			customer.setUserName(userName);
			customer.setUserPassword(userPassword);
			customer.setRoleType(roleType);
			getSession().save(customer);
			commit();
			return customer;
		}
		catch (HibernateException e)
		{
			rollback();
			//throw new AdException("Could not create user " + customername, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}
	
	public void delete(Customer customer) throws AdException
	{
		try
		{
			begin();
			getSession().delete(customer);
			commit();
		}
		catch (HibernateException e)
		{
			rollback();
			throw new AdException("Could not delete user " + customer.getCustomerName(), e);
		}
	}
	
	public void uploadPhoto(Customer customer) throws AdException
	{
		try
		{
            begin();
            getSession().update(customer);
            commit();
        }
		catch (HibernateException e)
		{
            rollback();
            throw new AdException("Could not update status ");
        }
	}
}