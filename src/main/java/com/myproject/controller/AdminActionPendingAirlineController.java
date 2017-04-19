package com.myproject.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.dao.AirlineDAO;
import com.myproject.dao.UserDAO;
import com.myproject.exception.AdException;
import com.myproject.pojo.Airline;
import com.myproject.pojo.Users;

@Controller
@RequestMapping(value = "/actionPendingRequests.htm", method = RequestMethod.GET)
public class AdminActionPendingAirlineController
{
	@RequestMapping(value = "/actionPendingRequests.htm", method = RequestMethod.GET)
	public ModelAndView actionPendingRequest(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, AdException
	{
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if(null != session.getAttribute("userName"))
		{
			try
			{
				String action = request.getParameter("action");
				System.out.println("clicked action value is " + action);
				int userID = Integer.parseInt(request.getParameter("userID"));
				System.out.println("userID from admin screen is " + userID);
				if(action.equalsIgnoreCase("accept"))
				{
					System.out.println("in side accept");
					String accountStatus = "Active";
					Airline airline = new Airline();
					AirlineDAO airlineDAO = new AirlineDAO();
					airline = airlineDAO.getAirlineStatus(userID);
					airline.setAccountStatus(accountStatus);
					airlineDAO.updateAirlineStatus(airline);
					mv.setViewName("AdminLoginSuccess");
				}
				else if(action.equalsIgnoreCase("reject"))
				{
					System.out.println("in side reject");
					String accountStatus = "Rejected";
					Airline airline = new Airline();
					AirlineDAO airlineDAO = new AirlineDAO();
					airline = airlineDAO.getAirlineStatus(userID);
					airline.setAccountStatus(accountStatus);
					airlineDAO.updateAirlineStatus(airline);
					mv.setViewName("AdminLoginSuccess");
				}
			}
			catch (AdException e)
			{
	            System.out.println("Exception: " + e.getMessage());
			}
			return mv;
		}
		else
		{
			mv.setViewName("AdminLoginForm");
			return mv;
		}
	}
}
