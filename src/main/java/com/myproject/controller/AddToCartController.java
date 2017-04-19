package com.myproject.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.dao.FlightDAO;
import com.myproject.dao.OrderDAO;
import com.myproject.dao.UserDAO;
import com.myproject.exception.AdException;
import com.myproject.pojo.Airline;
import com.myproject.pojo.Customer;
import com.myproject.pojo.Flight;
import com.myproject.pojo.Orders;
import com.myproject.pojo.Users;

@Controller
@RequestMapping(value="/addToCart.htm", method=RequestMethod.POST)
public class AddToCartController
{
	@RequestMapping(value="/addToCart.htm", method=RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws AdException
	{
		try
		{
			HttpSession session = request.getSession();
			int orderquantity = (Integer) session.getAttribute("quantity");
			float unitPrice = Float.parseFloat(request.getParameter("price"));
			String userName = (String) session.getAttribute("userName");
			System.out.println("userName from session is " + userName);
			int flightID = Integer.parseInt(request.getParameter("flightID"));
			System.out.println("flightID from query string is " + flightID);
			System.out.println("quantity given by customer is " + orderquantity);
			
//			UserDAO userDAO = new UserDAO();
//			Users users = new Users();
//			users = userDAO.getUserID(userName);
//			int userID = users.getUserID();
//			System.out.println("userID for given user is " + userID);
			
			OrderDAO orderDAO = new OrderDAO();
			Flight flight = new Flight();
			float totalPrice = unitPrice * orderquantity;
			orderDAO.bookFlight(orderquantity, userName, flightID, totalPrice);
			session.setAttribute("orderedOty", orderquantity);
			
			FlightDAO flightDAO = new FlightDAO();
			flight = flightDAO.getFlightQuantity(flightID);
			int prvQuantity = flight.getQuantity();
			int newQuantity = prvQuantity - orderquantity;
			flight.setQuantity(newQuantity);
			flightDAO.updateFlightQuantity(flight);
		}
		catch(Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
		}
		return new ModelAndView("CustomerCart");
	}
}
