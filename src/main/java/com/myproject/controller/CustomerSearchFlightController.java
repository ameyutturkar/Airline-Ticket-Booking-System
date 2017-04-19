package com.myproject.controller;


import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.dao.FlightDAO;
import com.myproject.dao.OrderDAO;
import com.myproject.exception.AdException;
import com.myproject.pojo.Customer;
import com.myproject.pojo.Flight;

@Controller
@RequestMapping(value="/searchFlights.htm", method = RequestMethod.POST)
public class CustomerSearchFlightController
{
	@RequestMapping(value="/searchFlights.htm", method = RequestMethod.POST)
	public ModelAndView searchFlights(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, AdException
	{
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if(null != session.getAttribute("userName"))
		{
			try
			{
				System.out.println("inside search flight controller mv");
				List flightList = new ArrayList();
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				String source = request.getParameter("source");
				String destination = request.getParameter("destination");
				String customerStartDate = request.getParameter("startDate");
				Date startDateTime = sdf.parse(customerStartDate);
				String customerEndDate = request.getParameter("endDate");
				Date endDateTime = sdf.parse(customerEndDate);
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				session.setAttribute("quantity", quantity);
				
				FlightDAO flightDAO = new FlightDAO();
				System.out.println("before going into flightDAO");
				
				flightList = flightDAO.getFlights(source, destination, startDateTime, endDateTime,
						quantity);
				System.out.println("after flightDAO");
				mv.addObject("flightList", flightList);
				System.out.println("size of the flightList is " + flightList.size());
				session.setAttribute("flightList", flightList);
				mv.setViewName("Success");
			}
			catch (AdException e)
			{
	            System.out.println("Exception: " + e.getMessage());
			}
			return mv;
		}
		else
		{
			mv.setViewName("LoginForm");
			return mv;
		}
	}
}
