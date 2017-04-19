package com.myproject.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myproject.pojo.Airline;
import com.myproject.pojo.Customer;

public class AirlineValidator implements Validator
{
	public boolean supports(Class aClass)
    {
        return aClass.equals(Airline.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Airline airline = (Airline) obj;
       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "airlineName", "error.invalid.airlineName", "Airline Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "airlineEmail", "error.invalid.airlineEmail", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "airlineAddress", "error.invalid.airlineAddress", "Address Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.userName", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "error.invalid.userPassword", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleType", "error.invalid.roleType", "Role Type Required");
    }
}
