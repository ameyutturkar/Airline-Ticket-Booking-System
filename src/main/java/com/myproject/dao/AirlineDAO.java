package com.myproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.myproject.exception.AdException;
import com.myproject.pojo.Airline;
import com.myproject.pojo.Customer;
import com.myproject.pojo.Users;

public class AirlineDAO extends DAO
{
	public AirlineDAO()
	{
		
	}
	
	public Airline get(String airlineName)throws AdException
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from Airline where airlineName = :airlinename");
			q.setString("airlineName", airlineName);
			Airline airline = (Airline) q.uniqueResult();
			commit();
			return airline;
		}
		catch (HibernateException e)
		{
			rollback();
			throw new AdException("Could not get user " + airlineName, e);
		}
	}
	
	public Airline create(String airlineName, String airlineEmail, String airlineAddress,
			String userName, String userPassword, String roleType, String accountStatus) throws AdException
	{
		try
		{
			begin();
			System.out.println("inside DAO");
			//Customer customer = new Customer();
			Airline airline = new Airline(airlineName, airlineEmail, airlineAddress,
					accountStatus);
			airline.setAirlineName(airlineName);
			airline.setAirlineEmail(airlineEmail);
			airline.setAirlineAddress(airlineAddress);
			airline.setUserName(userName);
			airline.setUserPassword(userPassword);
			airline.setRoleType(roleType);
			airline.setAccountStatus(accountStatus);
			airline.setAccountStatus("Inactive");
			System.out.println("inside DAO before save and commit");
			getSession().save(airline);
			commit();
			return airline;
		}
		catch (HibernateException e)
		{
			rollback();
			//throw new AdException("Could not create user " + customername, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}
	
	public void delete(Airline airline) throws AdException
	{
		try
		{
			begin();
			getSession().delete(airline);
			commit();
		}
		catch (HibernateException e)
		{
			rollback();
			throw new AdException("Could not delete user " + airline.getAirlineName(), e);
		}
	}
	
	public List<Airline> adminSearch(String accountStatus) throws AdException
	{
		try
		{
			begin();
			System.out.println("Inside admin search");
			Session session = getSession();
			Criteria criteria = session.createCriteria(Airline.class);
			criteria.add(Restrictions.eq("accountStatus", accountStatus));
			List<Airline> airlineList = criteria.list();
			System.out.println("size of the airlineList is " + airlineList.size());
			commit();
			return airlineList;
		}
		catch (HibernateException e)
		{
			rollback();
			throw new AdException("Could not get airlines for current selection", e);
		}
	}
	
	public Airline getAirlineStatus(int userID) throws AdException
	{
		try
		{
			begin();
			System.out.println("Inside airline status update");
			System.out.println("userID is " + userID);
			Query q = getSession().createQuery("from Airline where userID = :userID");
			//q.setString("accountStatus", accountStatus);
			q.setInteger("userID", userID);
			Airline airline = (Airline) q.uniqueResult();
			commit();
			return airline;
		}
		catch (HibernateException e)
		{
			rollback();
			throw new AdException("Could not update account status", e);
		}
	}
	
	public void updateAirlineStatus(Airline airline) throws AdException
	{
		try
		{
            begin();
            getSession().update(airline);
            commit();
        }
		catch (HibernateException e)
		{
            rollback();
            throw new AdException("Could not update status ");
        }
	}
}
