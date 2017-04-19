package com.myproject.dao;

import org.hibernate.HibernateException;

import com.myproject.exception.AdException;
import com.myproject.pojo.OrderContent;
import com.myproject.pojo.Orders;

public class OrderContentDAO extends DAO
{
	public OrderContent create(Orders orders) throws AdException
	{
        try
        {
            begin();
            System.out.println("inside OrderItem DAO");
            
            OrderContent orderContent = new OrderContent(orders);

            getSession().save(orderContent);

            commit();
            return orderContent;
        }
        catch (HibernateException e)
        {
            rollback();
            // throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
}
