package com.myproject.dao;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.myproject.exception.AdException;
import com.myproject.pojo.Users;

import javassist.NotFoundException;

public class UserDAO extends DAO
{
	public Users fetchUser(String userName, String userPassword, String roleType) throws AdException
	{
		System.out.println("inside userDAO");
		try
        {
            begin();
            //add code here to check if the user is already in the session.
            /*this code will work after the user gets added to the session
             * in the VerifyCustomerLoginController
             * add above codes in remaining two logins too
            */
            Query q = getSession().createQuery("from Users where userName = :userName and "
            		+ "userPassword = :userPassword and roleType = :roleType");
            q.setString("userName", userName);
            q.setString("userPassword", userPassword);
            q.setString("roleType", roleType);
            Users users = (Users) q.uniqueResult();
            commit();
            //String dbUserName = users.getUserName();
            System.out.println(userName);
            System.out.println(userPassword);
            System.out.println(roleType);
            System.out.println(users);
            return users;
        }
        catch (HibernateException e)
        {
            rollback();
            throw new AdException("Could not get user " + userName, e);
        }
    }
	
	public Users fetchAirline(String userName, String userPassword, String roleType, String accountStatus) throws AdException
	{
		System.out.println("inside userDAO");
		try
        {
            begin();
            Query q = getSession().createQuery("from Users where userName = :userName and "
            		+ "userPassword = :userPassword and roleType = :roleType and "
            		+ "accountStatus = :accountStatus");
            q.setString("userName", userName);
            q.setString("userPassword", userPassword);
            q.setString("roleType", roleType);
            q.setString("accountStatus", accountStatus);
            Users users = (Users) q.uniqueResult();
            commit();
            //String dbUserName = users.getUserName();
            System.out.println(userName);
            System.out.println(userPassword);
            System.out.println(roleType);
            System.out.println(accountStatus);
            System.out.println(users);
            return users;
        }
        catch (HibernateException e)
        {
            rollback();
            throw new AdException("Could not get user " + userName, e);
        }
    }
	
//	public Boolean checkUserName(String userName)
//	{
//		begin();
//		if(null != userName && !userName.isEmpty())
//		{
//			Query q = getSession().createQuery("from Users where )
//		}
//	}
	
	public Users getUserID(String userName) throws AdException
	{
		Query q = getSession().createQuery("from Users where userName = :userName");
        q.setString("userName", userName);
        Users users = (Users) q.uniqueResult();
        commit();
        return users;
	}
}
