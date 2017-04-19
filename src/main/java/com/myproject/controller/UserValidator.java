package com.myproject.controller;

import com.myproject.dao.UserDAO;
import com.myproject.exception.AdException;
import com.myproject.pojo.Users;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

public class UserValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Users.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Users users = (Users) obj;
        UserDAO userDAO = new UserDAO();
        users.getUserName().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim();
        users.getUserPassword().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim();
        users.getRoleType().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleType", "error.invalid.users", "Role Type Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.users", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "error.invalid.password", "Password Required");
        
        try
        {
        	users = userDAO.getUserID(users.getUserName());
        	if(null != users)
        	{
        		System.out.println("The user already exists");
        		errors.rejectValue("userName", "error.invalid.users", "Username Already Exists");
        	}
        	else
        	{
        		System.out.println("New User");
        	}
        }
        catch (Exception e)
        {
        	System.out.println("Could check the user " + users.getUserName());
        }
    }
}
