package com.myproject.controller;

import java.io.File;
import java.io.IOException;

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
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.myproject.dao.CustomerDAO;
import com.myproject.exception.AdException;
import com.myproject.pojo.Customer;

@Controller
public class CustomerSignupController extends SimpleFormController
{
	@Autowired
	@Qualifier("customerValidator")
	CustomerValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		System.out.println("in binder");
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "/customerSignup.htm", method = RequestMethod.POST)
	public ModelAndView handleRequest(@ModelAttribute("customer") Customer customer,
			BindingResult result) throws IllegalStateException, IOException
	{
		validator.validate(customer, result);
		if (result.hasErrors())
		{
			System.out.println("in error");
			return new ModelAndView("LoginForm");
		}
		
		try
		{
			System.out.print("test");
			//CustomerDAO customerDAO = new CustomerDAO();
			CustomerDAO customerDAO = new CustomerDAO();
			System.out.print("test1");
			
			//below code is only for multipart
			/*File file;
	    	String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.
	    	String path = null;
	    	if(check.equalsIgnoreCase("\\"))
	        {
	         path = getServletContext().getRealPath("").replace("build\\",""); //Netbeans projects gives real path as Lab6/build/web/ so we need to replace build in the path.
	        }
	     
	         if(check.equalsIgnoreCase("/"))
	         {
	             path = getServletContext().getRealPath("").replace("build/","");
	             path += "/"; //Adding trailing slash for Mac systems.
	         }
	    	
	    	if(customer.getPhotoName() != null)
	    	{
	    		String fileNameWithExt = System.currentTimeMillis() +
	    				customer.getPhoto().getOriginalFilename();
	    		file = new File(path + fileNameWithExt);
	    		String context = getServletContext().getContextPath();
		            
	    		customer.getPhoto().transferTo(file);
	    		customer.setPhotoName(context + "/" + fileNameWithExt);
	    		//customerDAO.uploadPhoto(customer);
	    	}*/

			customerDAO.create(customer.getCustomerName(), customer.getCustomerEmail(),
					customer.getCustomerAddress(), customer.getUserName(), customer.getUserPassword(),
					customer.getRoleType());

			// DAO.close();
		}
		catch (AdException e)
		{
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("home");
		}
		
		return new ModelAndView("CustomerSignupSuccess");
	}
}
