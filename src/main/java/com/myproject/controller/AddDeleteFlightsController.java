package com.myproject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.dao.FlightDAO;
import com.myproject.exception.AdException;
import com.myproject.pojo.Airline;
import com.myproject.pojo.Flight;
import com.myproject.pojo.Users;

@Controller
public class AddDeleteFlightsController
{
	@Autowired
	@Qualifier("flightValidator")
	FlightValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		System.out.println("in binder");
		System.out.println("in binder again");
		//binder.setValidator(validator);
		binder.setValidator(validator);
	}
	
	@RequestMapping(value="/addDeleteFlights.htm", method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("flight") Flight flight,
			BindingResult result)
	{
		HttpSession session = request.getSession();
		if(null != session.getAttribute("userName"))
		{
			validator.validate(flight, result);
			if (result.hasErrors())
			{
				System.out.println("in error");
				return new ModelAndView("AirlineLoginForm");
			}
			
			try
			{
				System.out.println("test");
				//CustomerDAO customerDAO = new CustomerDAO();
				FlightDAO flightDAO = new FlightDAO();
				Airline airline = new Airline();
				//Airline airline = (Airline)session.getAttribute("users");
				
				String tempUserName = (String) session.getAttribute("userName");
				System.out.println(tempUserName);
				System.out.println("test1");

				flightDAO.createFlight(flight.getFlightName(), flight.getSource(), flight.getDestination(),
						flight.getQuantity(), flight.getStartDateTime(), flight.getEndDateTime(),
						flight.getPrice(), tempUserName);

				// DAO.close();
			}
			catch (AdException e)
			{
				System.out.println("Exception: " + e.getMessage());
			}
			
			return new ModelAndView("AirlineDashboard");
		}
		else
		{
			return new ModelAndView("AirlineLoginForm");
		}
		
	}
	
	@RequestMapping(value="/toAirlineDashboard.htm", method = RequestMethod.GET)
	public String initializeForm(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("flight") Flight flight)
	{
		HttpSession session = request.getSession();
		if(null != session.getAttribute("userName"))
		{
			return "AirlineDashboard";
		}
		else
		{
			return "AirlineLoginForm";
		}
	}
	
	@RequestMapping(value="/toDeleteFlights.htm", method = RequestMethod.GET)
	public ModelAndView searchAllFlights(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, AdException
	{
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		//HttpSession session = request.getSession();
		if(null != session.getAttribute("userName"))
		{
			try
			{
				System.out.println("inside search flight controller mv");
				List flightList = new ArrayList();
				String userName = (String) session.getAttribute("userName");
				System.out.println("userName in session is " + userName);
				FlightDAO flightDAO = new FlightDAO();
				System.out.println("before going into flightDAO");
				
				flightList = flightDAO.getAllFlights(userName);
				System.out.println("after flightDAO");
				mv.addObject("flightList", flightList);
				System.out.println("size of the flightList is " + flightList.size());
				session.setAttribute("flightList", flightList);
				mv.setViewName("DeleteFlights");
			}
			catch (AdException e)
			{
	            System.out.println("Exception: " + e.getMessage());
			}
			return mv;
		}
		else
		{
			mv.setViewName("AirlineLoginForm");
			return mv;
		}
		
	}
	
	@RequestMapping(value="/deleteFlight.htm", method = RequestMethod.POST)
	public ModelAndView deleteFlight(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, AdException
	{
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if(null != session.getAttribute("userName"))
		{
			try
			{
				System.out.println("inside delete flight controller mv");
				//List flightList = new ArrayList();
				int flightID = Integer.parseInt(request.getParameter("flightID"));
				System.out.println("flightID from querystring is " + flightID);
				FlightDAO flightDAO = new FlightDAO();
				System.out.println("before going into flightDAO");
				Flight flight = new Flight();
				flight = flightDAO.searchFlightBook(flightID);
				System.out.println("after flightDAO");
				flightDAO.delete(flight);
				mv.setViewName("DeleteFlights");
			}
			catch (AdException e)
			{
	            System.out.println("Exception: " + e.getMessage());
			}
			return mv;
		}
		else
		{
			mv.setViewName("AirlineLoginForm");
			return mv;
		}
	}
}
