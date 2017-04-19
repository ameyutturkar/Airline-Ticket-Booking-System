package com.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping(value="/createUser.htm", method=RequestMethod.POST)
public class UserController
{
	@RequestMapping(value="/loginCustomer.htm", method=RequestMethod.GET)
	public String search()
	{
		return "LoginForm";
	}
	
	@RequestMapping(value="/loginAirline.htm", method=RequestMethod.GET)
	public String searchAirline()
	{
		return "AirlineLoginForm";
	}
	
	@RequestMapping(value="/loginAdmin.htm", method=RequestMethod.GET)
	public String searchAdmin()
	{
		return "AdminLoginForm";
	}
}
