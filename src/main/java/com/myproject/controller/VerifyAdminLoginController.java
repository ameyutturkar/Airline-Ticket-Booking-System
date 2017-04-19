package com.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.dao.AirlineDAO;
import com.myproject.dao.UserDAO;
import com.myproject.exception.AdException;
import com.myproject.pojo.Users;

@Controller
@RequestMapping(value="/loginSuccessAdmin.htm", method = RequestMethod.POST)
public class VerifyAdminLoginController
{
	@RequestMapping(value="/loginSuccessAdmin.htm", method = RequestMethod.POST)
	public String searchUser(HttpServletRequest request, HttpServletResponse response)
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String roleType = "Admin";
		HttpSession session = request.getSession();
		if(null == session.getAttribute("userName"))
		{
			session.setAttribute("userName", userName);
			String tempUserName = (String) session.getAttribute("userName");
			System.out.println("tempUserName is " + tempUserName);
			System.out.println("username is " + userName);
			System.out.println("password is " + password);
			
			try
			{
				UserDAO userDAO = new UserDAO();
				System.out.println("before going into userDAO");
				userDAO.fetchUser(userName, password, roleType);
				System.out.println("admin username is " +userName);
				Users users = (Users)userDAO.fetchUser(userName, password, roleType);
				session.setAttribute("users", users);
				if(null != users)
				{
					System.out.println("customer is not null");
					return "AdminLoginSuccess";
				}
				else
				{
					System.out.println("customer is null");
					session.removeAttribute(userName);
					session.invalidate();
					return "AdminLoginForm";
				}
			}
			
			catch (AdException e)
			{
	            System.out.println("Exception: " + e.getMessage());
	            return "AdminLoginForm";
	        }
		}
		return "AdminLoginSuccess";
	}
}
