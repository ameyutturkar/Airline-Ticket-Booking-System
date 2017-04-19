//package com.myproject.controller;
//
//import java.io.File;
//import java.io.IOException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.SimpleFormController;
//
//import com.myproject.dao.CustomerDAO;
//import com.myproject.dao.UserDAO;
//import com.myproject.exception.AdException;
//import com.myproject.pojo.Customer;
//import com.myproject.pojo.Flight;
//import com.myproject.pojo.Users;
//
//@Controller
//@RequestMapping(value = "/customerDocumentUpload.htm", method = RequestMethod.POST)
//public class UploadDocumentController extends SimpleFormController
//{
//	CustomerDAO customerDAO;
//    public void UploadDocumentController(CustomerDAO customerDAO)
//    {
//        this.customerDAO = customerDAO;
//    }
//    
//    @RequestMapping(value = "/customerDocumentUpload.htm", method = RequestMethod.POST)
//    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response,
//			@ModelAttribute("customer") Customer customer) throws IllegalStateException, IOException
//    {
//    	ModelAndView mv = new ModelAndView();
//		HttpSession session = request.getSession();
//		
//		//Customer customer = (Customer) command;
//	    try
//	    {
//	    	String userName = (String) session.getAttribute("userName");
//	    	System.out.println("userName in session is " + userName);
//	    	//String photo = (String) request.getAttribute("action");
//	    	//String photo = String.valueOf(customer.getPhoto());
//	    	//System.out.println("photo path from queryString is " + photo);
//	    	CustomerDAO customerDAO = new CustomerDAO();
//	    	customer = customerDAO.getCustomerForFile(userName);
//	    	File file;
//	    	String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.
//	    	String path = null;
//	    	if(check.equalsIgnoreCase("\\"))
//	    	{
//	    		path = getServletContext().getRealPath("").replace("build\\",""); //Netbeans projects gives real path as Lab6/build/web/ so we need to replace build in the path.
//	    	}
//	    	
//	    	//path="C:\\Eclipse_Workspace\\Project_Web_Tools\\src\\main\\webapp\\resources\\images";
//		    
//	    	if(check.equalsIgnoreCase("/"))
//	    	{
//	    		path = getServletContext().getRealPath("").replace("build/","");
//	    		path += "/"; //Adding trailing slash for Mac systems.
//	    	}
//	    	if(customer.getPhotoName() != null)
//	    	{
//	    		String fileNameWithExt = System.currentTimeMillis() +
//	    				customer.getPhoto().getOriginalFilename();
//	    		file = new File(path + fileNameWithExt);
//	    		String context = getServletContext().getContextPath();
//	            
//	    		customer.getPhoto().transferTo(file);
//	    		customer.setPhotoName(context + "/" + fileNameWithExt);
//	    		customerDAO.uploadPhoto(customer);
//	    	}
//	    	mv.setViewName("HelloUser");
//	    }
//	    catch (AdException e)
//		{
//            System.out.println("Exception: " + e.getMessage());
//		}
//			return mv;
//    }
//}
