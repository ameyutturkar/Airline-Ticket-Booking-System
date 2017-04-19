package com.myproject.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.pojo.Customer;

public class CustomerValidator implements Validator
{
	private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
	public boolean supports(Class aClass)
    {
        return aClass.equals(Customer.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Customer customer = (Customer) obj;
//        Pattern pattern = Pattern.compile(IMAGE_PATTERN);
//        Matcher matcher;
//        MultipartFile photo;
        customer.getCustomerName().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim();
        customer.getCustomerAddress().replaceAll("[^\\dA-Za-z ]","").trim();
        customer.getCustomerEmail().replaceAll("\\s+","").trim();
        customer.getUserName().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim();
        customer.getUserPassword().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim();
        customer.getRoleType().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim();
       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerName", "error.invalid.customerName", "Customer Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerEmail", "error.invalid.customerEmail", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAddress", "error.invalid.customerAddress", "Address Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.userName", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "error.invalid.userPassword", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleType", "error.invalid.roleType", "Role Type Required");
        //ValidationUtils.rejectIfEmpty(errors, "photo", "error.invalid.photo", "Field cannot be empty");
        
    }
}
