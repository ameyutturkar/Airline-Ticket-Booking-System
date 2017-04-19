package com.myproject.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.dao.OrderDAO;
import com.myproject.dao.UserDAO;
import com.myproject.exception.AdException;
import com.myproject.pojo.Customer;
import com.myproject.pojo.Users;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class GoToCustomerSignupController
{
	@RequestMapping(value="/signupSuccessCustomer.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("customer") Customer customer)
	{
		return "Signup";
	}
	
	@RequestMapping(value="/toCustomerSearch.htm", method = RequestMethod.GET)
	public String initializeForm3(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("customer") Customer customer)
	{
		HttpSession session = request.getSession();
		if(null != session.getAttribute("userName"))
		{
			return "Success";
		}
		else
		{
			return "LoginForm";
		}
	}
	
	@RequestMapping(value="/toCustomerDocuments.htm", method = RequestMethod.GET)
	public String initializeForm1(@ModelAttribute("customer") Customer customer)
	{
		return "UploadDocuments";
	}
	
//	@RequestMapping(value="/toCustomerViewHistory.htm", method = RequestMethod.GET)
//	public String initializeForm2(@ModelAttribute("customer") Customer customer)
//	{
//		return "CustomerHistory";
//	}
	
	@RequestMapping(value="/toCustomerDashboard.htm", method = RequestMethod.GET)
	public String initializeForm4(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("customer") Customer customer)
	{
		HttpSession session = request.getSession();
		if(null != session.getAttribute("userName"))
		{
			return "CustomerDashboard";
		}
		else
		{
			return "LoginForm";
		}
	}
	
	@RequestMapping(value="/loginSuccessCustomer.htm", method = RequestMethod.POST)
	public String searchUser(HttpServletRequest request, HttpServletResponse response)
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String roleType = "Customer";
		HttpSession session = request.getSession();
		if(null == session.getAttribute("userName"))
		//add above condition to airline and admin login controller
		{
			session.setAttribute("userName", userName);
			String tempUserName = (String) session.getAttribute("userName");
			session.setAttribute("userName", tempUserName);
			System.out.println(tempUserName);
			System.out.println(userName);
			System.out.println(roleType);
			System.out.println(password);
			
			try
			{
				UserDAO userDAO = new UserDAO();
				System.out.println("before going into userDAO");
				//String tempUserName = (String) session.getAttribute("userName");
				//System.out.println(tempUserName);
				//userDAO.fetchUser(userName, password, roleType);
				Users users = new Users();
				users = userDAO.fetchUser(userName, password, roleType);
				//return "Success";
				if(null != users)
				{
					System.out.println("customer is not null");
					return "CustomerDashboard";
				}
				else
				{
					System.out.println("customer is null");
					session.removeAttribute(userName);
					session.invalidate();
					return "LoginForm";
				}
			}
			catch (AdException e)
			{
	            System.out.println("Exception: " + e.getMessage());
	            return "LoginForm";
	        }
		}
		return "CustomerDashboard";
	}
	
	@RequestMapping(value="/toCustomerViewHistory.htm", method = RequestMethod.POST)
	public ModelAndView getHistory(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, AdException
	{
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if(null != session.getAttribute("userName"))
		{
			try
			{
				String userName = (String) session.getAttribute("userName");
				System.out.println("userName from session is " + userName);
				OrderDAO orderDAO = new OrderDAO();
				List customerOrderList = null;
				customerOrderList = orderDAO.viewHistory(userName);
				System.out.println("size of the customerOrderList is " + customerOrderList.size());
				session.setAttribute("viewHistory", customerOrderList);
				mv.setViewName("CustomerHistory");
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
	
	/*@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(validator);
	}
	
	@RequestMapping(value="/loginSuccess.htm", method=RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, @RequestParam("button") String button)
	{
		HttpSession session = request.getSession();
        String action1 = request.getParameter("userName");
        String action = request.getParameter("roleType");
        ModelAndView mv = new ModelAndView();
        
        if(button.equalsIgnoreCase("Login"))
		{
        	System.out.println(action);
        	session.setAttribute("roletype", action);
        	session.setAttribute("user", action1);
        	mv.setViewName("HelloUser");
		}
        else if (button.equalsIgnoreCase("Signup"))
        {
        	System.out.println(action);
        	session.setAttribute("roletype", action);
        	session.setAttribute("user", action1);
        	mv.setViewName("Signup");
        }
        return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	 protected String doSubmitAction(@ModelAttribute("users") Users users, BindingResult result) throws Exception
	 {
		 validator.validate(users, result);
		 if (result.hasErrors())
		 {
			 return "LoginForm";
		 }
		 
		 
		 return "LoginForm";
	 }
	 @RequestMapping(method = RequestMethod.GET)
	 public String initializeForm(@ModelAttribute("users") Users users, BindingResult result)
	 {
		 return "LoginForm";
	 }*/
}