package com.myproject.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.dao.AirlineDAO;
import com.myproject.exception.AdException;

@Controller
@RequestMapping(method = RequestMethod.POST)
public class AdminSearchPendingAirlineController
{
	@RequestMapping(value = "/searchPendingRequests.htm", method = RequestMethod.POST)
	public ModelAndView searchPendingRequest(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, AdException
	{
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if(null != session.getAttribute("userName"))
		{
			try
			{
				List airlineList = new ArrayList();
				String accountStatus = "Inactive";
				AirlineDAO airlineDAO = new AirlineDAO();
				airlineList = airlineDAO.adminSearch(accountStatus);
				mv.addObject("airlineList", airlineList);
				request.getSession().setAttribute("airlineList", airlineList);
				mv.setViewName("AdminLoginSuccess");
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
	
	@RequestMapping(value = "/searchRejectedRequests.htm", method = RequestMethod.POST)
	public ModelAndView searchRejectedRequest(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, AdException
	{
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if(null != session.getAttribute("userName"))
		{
			try
			{
				List airlineList = new ArrayList();
				String accountStatus = "Rejected";
				AirlineDAO airlineDAO = new AirlineDAO();
				airlineList = airlineDAO.adminSearch(accountStatus);
				mv.addObject("airlineList", airlineList);
				request.getSession().setAttribute("airlineList", airlineList);
				mv.setViewName("AdminLoginSuccess");
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
	
	@RequestMapping(value = "/searchAcceptedRequests.htm", method = RequestMethod.POST)
	public ModelAndView searchAcceptedRequest(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, AdException
	{
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if(null != session.getAttribute("userName"))
		{
			try
			{
				List airlineList = new ArrayList();
				String accountStatus = "Active";
				AirlineDAO airlineDAO = new AirlineDAO();
				airlineList = airlineDAO.adminSearch(accountStatus);
				mv.addObject("airlineList", airlineList);
				request.getSession().setAttribute("airlineList", airlineList);
				mv.setViewName("AdminLoginSuccess");
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
