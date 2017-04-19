package com.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.dao.UserDAO;
import com.myproject.exception.AdException;
import com.myproject.pojo.Airline;
import com.myproject.pojo.Flight;
import com.myproject.pojo.Users;

@Controller
@RequestMapping
public class GoToAirlineSignupController
{
	@RequestMapping(value="/signupSuccessAirline.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("airline") Airline airline)
	{
		return "AirlineSignup";
	}
	
	@RequestMapping(value="/toAddFlights.htm", method = RequestMethod.GET)
	public String initializeForm(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("flight") Flight flight)
	{
		HttpSession session = request.getSession();
		if(null != session.getAttribute("userName"))
		{
			return "AddDeleteFlights";
		}
		else
		{
			return "AirlineLoginForm";
		}
	}
	
	@RequestMapping(value="/goToAirlineLogin.htm", method = RequestMethod.GET)
	public String initializeForm1(@ModelAttribute("flight") Flight flight)
	{
		return "AirlineLoginForm";
	}
	
	@RequestMapping(value="/loginSuccessAirline.htm", method = RequestMethod.POST)
	public String searchUser(HttpServletRequest request, HttpServletResponse response)
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String roleType = "Airline";
		HttpSession session = request.getSession();
		if(null == session.getAttribute("userName"))
		{
			System.out.println(userName);
			System.out.println(password);
			
			session.setAttribute("userName", userName);
	        session.setAttribute("password", password);
			
			try
			{
				UserDAO userDAO = new UserDAO();
				String accountStatus = "Active";
				System.out.println("before going into userDAO");
				Users users = (Users)userDAO.fetchAirline(userName, password, roleType, accountStatus);
				session.setAttribute("users", users);
				if(null != users)
				{
					System.out.println("customer is not null");
					return "AirlineDashboard";
				}
				else
				{
					System.out.println("customer is null");
					session.removeAttribute(userName);
					session.invalidate();
					return "AirlineLoginForm";
				}
			}
			
			catch (AdException e)
			{
	            System.out.println("Exception: " + e.getMessage());
	            return "AirlineLoginForm";
	        }
		}
		return "AirlineDashboard";
	}
}
