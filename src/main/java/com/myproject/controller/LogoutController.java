package com.myproject.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Controller
@RequestMapping
public class LogoutController
{
	@RequestMapping(value="/userLogout.htm", method=RequestMethod.GET)
	public String userLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String userName1 = (String) session.getAttribute("userName");
		session.removeAttribute(userName1);
		session.invalidate();
		System.out.println("check if username1 is still in session " + userName1);
//		String userName2 = (String) session.getAttribute("userName");
//		System.out.println("check if username2 is still in session " + userName2);
//		if (null == userName1)
//		{
//			request.setAttribute("Error", "Session has ended.  Please login.");
//			RequestDispatcher rd = request.getRequestDispatcher("home");
//			rd.forward(request, response);
//		}
		return "home";
	}
}
