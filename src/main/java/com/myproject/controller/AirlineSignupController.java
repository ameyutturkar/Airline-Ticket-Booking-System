package com.myproject.controller;

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

import com.myproject.dao.AirlineDAO;
import com.myproject.dao.CustomerDAO;
import com.myproject.exception.AdException;
import com.myproject.pojo.Airline;

@Controller
public class AirlineSignupController
{
	@Autowired
	@Qualifier("airlineValidator")
	AirlineValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(validator);
	}
	
	@RequestMapping(value="/airlineSignup.htm", method = RequestMethod.POST)
	public ModelAndView handleRequest(@ModelAttribute("airline") Airline airline,
			BindingResult result)
	{
		validator.validate(airline, result);
		if (result.hasErrors())
		{
			System.out.println("in error");
			return new ModelAndView("AirlineLoginForm");
		}
		
		try
		{
			System.out.print("test");
			//CustomerDAO customerDAO = new CustomerDAO();
			AirlineDAO airlineDAO = new AirlineDAO();
			System.out.print("test1");

			airlineDAO.create(airline.getAirlineName(), airline.getAirlineEmail(),
					airline.getAirlineAddress(), airline.getUserName(), airline.getUserPassword(),
					airline.getRoleType(), airline.getAccountStatus());

			// DAO.close();
		}
		catch (AdException e)
		{
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("home");
		}
		
		return new ModelAndView("SignupSuccess");
	}
}
