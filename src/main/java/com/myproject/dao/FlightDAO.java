package com.myproject.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.myproject.exception.AdException;
import com.myproject.pojo.Airline;
import com.myproject.pojo.Flight;
import com.myproject.pojo.Users;

public class FlightDAO extends DAO
{
	//write create method like customer dao
	public FlightDAO()
	{
		
	}
	
	public Flight searchFlight(String flightName) throws AdException
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from Flight where flightName = :flightname");
			q.setString("flightName", flightName);
			Flight flight = (Flight) q.uniqueResult();
			commit();
			return flight;
		}
		catch (HibernateException e)
		{
			rollback();
			throw new AdException("Could not get flight " + flightName, e);
		}
	}
	
	public Flight searchFlightBook(int flightID) throws AdException
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from Flight where flightID = :flightID");
			q.setInteger("flightID", flightID);
			Flight flight = (Flight) q.uniqueResult();
			commit();
			return flight;
		}
		catch (HibernateException e)
		{
			rollback();
			throw new AdException("Could not get flight " + flightID, e);
		}
	}
	
	public List<Flight> getFlights(String source, String destination, Date startDateTime,
			Date endDateTime, int quantity) throws AdException
	{
		try
		{
			begin();
			System.out.println("Inside flightDAO getFlights() method");
			Session session = getSession();
			Criteria criteria = session.createCriteria(Flight.class);
			criteria.add(Restrictions.eq("source", source));
			criteria.add(Restrictions.eq("destination", destination));
			criteria.add(Restrictions.eq("startDateTime", startDateTime));
			criteria.add(Restrictions.eq("endDateTime", endDateTime));
			criteria.add(Restrictions.ge("quantity", quantity));
			System.out.println("Source for criteria is " + source);
			//List<Flight> results = criteria.list();
			List<Flight> results = criteria.list();
			System.out.println("Size of criteria.list is " + results.size());
			System.out.println("value of criteria is " + criteria);
			
			/*String hql = "select f.flightName, f.source,"
					+ " f.destination, f.startDateTime, f.endDateTime, f.quantity,"
					+ " f.price from Flight f";
			String hql = "from Flight";
			Query q = getSession().createQuery("from Flight");
			System.out.println("the value of q is " +q);
			q.setString("source", source);
			q.setString("destination", destination);
			q.setDate("startDateTime", startDateTime);
			q.setDate("endDateTime", endDateTime);
			q.setInteger("quantity", quantity);
			//List<Flight[]> flightList = (List<Flight[]>)q.list();
			
			List flightList = q.list();*/
			
			commit();
			return results;
		}
		catch (HibernateException e)
		{
			rollback();
			throw new AdException("Could not get flight for current selection", e);
		}
	}
	
	public Flight createFlight(String flightName, String source, String destination,
			int quantity, Date startDateTime, Date endDateTime, float price, String userName)
					throws AdException
	{
		try
		{
			begin();
			System.out.println("inside DAO");
			System.out.println("username is " + userName);
			//Customer customer = new Customer();
			Flight flight = new Flight(flightName, source, destination, quantity,
					startDateTime, endDateTime, price, userName);
			
			//int userID = flight.getAirline().getUserID();
			
			/*flight.setFlightName(flightName); 
			flight.setSource(source);
			flight.setDestination(destination);
			flight.setTotalTickets(totalTickets);
			flight.setTotalBooked(totalBooked);
			flight.setStartDateTime(startDateTime);
			flight.setEndDateTime(endDateTime);
			flight.setPrice(price);*/
		
			getSession().save(flight);
			commit();
			return flight;
		}
		catch (HibernateException e)
		{
			rollback();
			//throw new AdException("Could not create user " + customername, e);
			throw new AdException("Exception while creating flight: " + e.getMessage());
		}
	}
	
	public List<Flight> getAllFlights(String userName) throws AdException
	{
		try
		{
			begin();
			System.out.println("Inside flightDAO getFlights() method");
			Session session = getSession();
			Criteria criteria = session.createCriteria(Flight.class);
			criteria.add(Restrictions.eq("userName", userName));
			//List<Flight> results = criteria.list();
			List<Flight> results = criteria.list();
			System.out.println("Size of criteria.list is " + results.size());
			System.out.println("value of criteria is " + criteria);
			
			commit();
			return results;
		}
		catch (HibernateException e)
		{
			rollback();
			throw new AdException("Could not get flight for current selection", e);
		}
	}
	
	public void delete(Flight flight) throws AdException
	{
		try
		{
			begin();
			getSession().delete(flight);
			commit();
		}
		catch (HibernateException e)
		{
			rollback();
			throw new AdException("Could not delete flight " + flight.getFlightName(), e);
		}
	}
	
	public Flight getFlightQuantity(int flightID) throws AdException
	{
		try
		{
			begin();
			System.out.println("Inside flightdao get quantity");
			System.out.println("flightID is " + flightID);
			Query q = getSession().createQuery("from Flight where flightID = :flightID");
			//q.setString("accountStatus", accountStatus);
			q.setInteger("flightID", flightID);
			Flight flight = (Flight) q.uniqueResult();
			commit();
			return flight;
		}
		catch (HibernateException e)
		{
			rollback();
			throw new AdException("Could not update account status", e);
		}
	}
	
	public void updateFlightQuantity(Flight flight) throws AdException
	{
		try
		{
            begin();
            getSession().update(flight);
            commit();
        }
		catch (HibernateException e)
		{
            rollback();
            throw new AdException("Could not update quantity ");
        }
	}

	/*public List getFlights(String source, String destination, Date startDateTime, Date endDateTime,
			int quantity) throws AdException
	{
		// TODO Auto-generated method stub
		List flightList = null;
		try
		{
			begin();
			Query q = getSession().createQuery("from Flight");
			//q.setString("source", source);
			//q.setString("destination", destination);
			//q.setDate("startDate", startDate);
			//q.setDate("endDate", endDate);
			//q.setInteger("quantity", quantity);
			//Flight flight = (Flight) q.uniqueResult();
			//List flightList = new List();
			//flightList = queryRunner.query(q, resultSetHandler);
			List list = q.list();
			commit();
			return list;
		}
		catch (HibernateException e)
		{
			rollback();
			throw new AdException("Could not get flight for current selection", e);
		}
	}*/
}
