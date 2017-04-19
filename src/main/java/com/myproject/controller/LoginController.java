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

import com.myproject.pojo.Users;

@Controller
@RequestMapping(value="/login.htm", method=RequestMethod.GET)
public class LoginController
{
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	 @InitBinder
	 private void initBinder(WebDataBinder binder)
	 {
		 binder.setValidator(validator);
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
	 }
}
